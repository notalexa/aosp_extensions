/*
 * Copyright (C) 2020 Not Alexa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.service.trust;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The class represents a set of authentications. The weight of this set is the sum of trust levels of all
 * authentication types contained in this set.
 * 
 * <br>This class can be used in <code>AIDL</code> files.
 * 
 * @author notalexa
 * @see AuthSet
 *
 */
public class AuthSet implements Parcelable {
	private static final AuthType[] TYPES=AuthType.values();
	private static final AuthSet[] SETS;
	private static final int MASK;
	public static final AuthSet NONE;
	static {
		int m=1;
		for(AuthType type:TYPES) {
			m=Math.max(m,type.getMask());
		}
		m<<=1;
		MASK=m-1;
		SETS=new AuthSet[m];
		for(int i=0;i<m;i++) {
			SETS[i]=new AuthSet(i);
		}
		NONE=SETS[0];
	}
	
	public static final Creator<AuthSet> CREATOR=new Creator<AuthSet>() {

		@Override
		public AuthSet createFromParcel(Parcel in) {
			return get(in.readInt());
		}

		@Override
		public AuthSet[] newArray(int size) {
			return new AuthSet[size];
		}
	};
	
	private static int calculateWeight(int mask) {
		int weight=0;
		for(AuthType type:TYPES) {
			if((mask&type.getMask())!=0) {
				weight+=type.getTrustWeight();
			}
		}
		return weight;
	}
	
	private static String getDescr(int mask) {
		StringBuilder descr=new StringBuilder().append(AuthSet.class.getSimpleName()).append('(').append(Integer.toHexString(mask)).append(")[");
		boolean first=true;
		for(AuthType type:TYPES) {
			if((mask&type.getMask())!=0) {
				if(!first) {
					descr.append(',');
				}
				first=false;
				descr.append(type.name());
			}
		}
		return descr.append(']').toString();
	}
	
	/**
	 * Each set is uniquely identified by it's mask. The method truncates the mask to a suitable value
	 * ignoring upper bits.
	 * 
	 * @param mask the mask of the authentication set
	 * @return the set corresponding to the given mask.
	 */
	public static AuthSet get(int mask) {
		return SETS[mask&MASK];
	}
	
	/**
	 * Returns an authentication set containing the given types. <code>null</code> is allowed as an argument
	 * 
	 * @param types the types contained in the requested authentication set
	 * @return the corresponding authentication set
	 */
	public static AuthSet get(AuthType...types) {
		return get(mask(types));
	}
	
	private static int mask(AuthType...types) {
		int m=0;
		for(AuthType type:types) {
			if(type!=null) {
				m|=type.getMask();
			}
		}
		return m;
	}
	
	private String mDescr;
	private int mMask;
	private int mWeight;
	private AuthSet(int mask) {
		this.mMask=mask;
		this.mWeight=calculateWeight(mask);
		this.mDescr=getDescr(mask)+" with weight "+mWeight;
	}
	
	
	/**
	 * 
	 * @return the mask of this set
	 */
	public int mask() {
		return mMask;
	}
	
	/**
	 * 
	 * @return the trust weight of this set
	 */
	public int getTrustWeight() {
		return mWeight;
	}
	
	public int hashCode() {
		return mMask;
	}
	
	public boolean equals(Object other) {
		if(other==this) {
			return true;
		} else if(other.hashCode()!=hashCode()) {
			return false;
		} else if(other instanceof AuthSet) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Enables the given authentication types in addition to the types of this set.
	 * 
	 * @param types the types to enable (<code>null</code> is allowed)
	 * @return an authentication set with the types enabled
	 */
	public AuthSet enable(AuthType...types) {
		return get(mMask|mask(types));
	}
	
	/**
	 * Enable the authentication types contained in <code>set</code>.
	 * 
	 * @param set the set of authentication types to enable
	 * @return the set of authentication types contained in this set or in <code>set</code>. 
	 */
	public AuthSet enable(AuthSet set) {
		return get(mMask|set.mMask);
	}
	
	/**
	 * 
	 * @param set the second set of authentication types
	 * @return the set of all authentication types contained both in this set and <code>set</code>.
	 */
	public AuthSet and(AuthSet set) {
		return get(mMask&set.mMask);
	}
	
	/**
	 * Disables the given authentication types if contained in this set.
	 * 
	 * @param types the types to disable (<code>null</code> is allowed)
	 * @return an authentication set with the types disabled
	 */
	public AuthSet disable(AuthType...types) {
		return get(mMask&~mask(types));
	}
	
	/**
	 * Disable the authentication types contained in <code>set</code>.
	 * 
	 * @param set the set of authentication types
	 * @return the set of authentications types contained in this set but not in <code>set</code>;
	 */
	public AuthSet disable(AuthSet set) {
		return get(mMask&~set.mMask);
	}
	
	/**
	 * 
	 * @param type the type to check. This type should not be <code>null</code>.
	 * @return <code>true</code> if the type is contained in this set.
	 */
	public boolean contains(AuthType type) {
		return 0!=(mMask&type.getMask());
	}
	
	/**
	 * Check for all authentication types.
	 * 
	 * @param set the set of authentication types to check
	 * @return <code>true</code> if this set contains all of the types in <code>set</code>.
	 */
	public boolean containsAll(AuthSet set) {
		return set.mMask==(set.mMask&mMask);
	}
	
	/**
	 * Check for at least one authentication type.
	 * 
	 * @param set the set of authentication types to check
	 * @return <code>true</code> if this set contains at least one of the types in <code>set</code>.
	 */
	public boolean containsOne(AuthSet set) {
		return 0!=(set.mMask&mMask);
	}
	
	/**
	 * 
	 * @return Does this set contains a strong authentication factor?
	 */
	public boolean isStrong() {
		return 0!=(mWeight&0xF0);
	}
	
	/**
	 * The effective weight of the set is the weight with "real" authentication types counted correctly.
	 * 
	 * @param requestedFactors the number of requested (real) authentication types
	 * @return the effective weight of this set
	 */
	public int getEffectiveWeight(int requestedFactors) {
		int factors=mWeight&0xF;
		if(requestedFactors>=factors) {
			return mWeight;
		} else {
			return mWeight-(factors-requestedFactors)*AuthType.Biometric.getTrustWeight();
		}
	}
	
	/**
	 * Check if this set implies the given authentication level. If this results in <code>true</code>, the system considers
	 * the device as unlockable in general (that is if no other restrictions are present).
	 *  
	 * @param level the level to check
	 * @return <code>true</code> if the authentication types contained in this set implies the given level.
	 * This method takes the number of requested "effective" factors into account. Therefore, a set of {@link AuthType#Biometric}
	 * and {@link AuthType#Location} will not imply a level {@link AuthLevel#WeakTwoFactorAuth} while {@link AuthType#Secret} will do.
	 */
	public boolean implies(AuthLevel level) {
		return level.getTrustLevel()<=getEffectiveWeight(level.getFactors());
	}
	
	/**
	 * The remaining trust weight needed to grant the given <code>level</code> if this set is already granted.
	 * This value is allways positive. A value of zero implies that the {link {@link #implies(AuthLevel)} method would
	 * return <code>true</code>.
	 * 
	 * @param level the requested authentication level
	 * @return the weight needed to grant the given level if this set is already granted
	 */
	public int getRemainingTrustWeight(AuthLevel level) {
		int granted=getEffectiveWeight(level.getFactors());
		return Math.max(0,level.getTrustLevel()-granted);
	}

	
	public String toString() {
		return mDescr;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(mMask);
	}
}
