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
 * An authentication level describes a level of trust, which has to
 * be reached before the device should be unlocked. A higher level
 * means more authentication should be presented.
 * 
 * <br>This class can be used in <code>AIDL</code> files.
 * 
 * Note that a weak authentication is never good enough to shift
 * a normal authentication over a strong authentication.
 * 
 * @author notalexa
 *
 */
public enum AuthLevel implements Parcelable {
	/**
	 * Simplest authentication: No authentication required.
	 */
	NoAuth(0,0),
	/**
	 * Weak authentication: The user has to solve a challenge which is 
	 * not considered as granting any security (but serves as a 
	 * barrier to unlock the device).
	 */
	WeakAuth(0x100,0),
	/**
	 * Normal authentication using a fingerprint for example
	 */
	Auth(0xC00,1),
	/**
	 * Weak two factor authentication.
	 */
	WeakTwoFactorAuth(0xD00,1),
	/**
	 * Strong single factor authentication
	 */
	StrongAuth(0x1000,1),
	/**
	 * Normal two factor authentication <code>(2*C)</code>
	 */
	TwoFactorAuth(0x1800,2),
	/**
	 * Weak three factor authentication <code>(2*C+1)</code>
	 */
	WeakThreeFactorAuth(0x1900,2),
	/**
	 * Strong two factor authentication (combination of {@link #StrongAuth} and {@link #Auth}.
	 */
	StrongTwoFactorAuth(0x1C00,2);
	
	public static final Creator<AuthLevel> CREATOR=new Creator<AuthLevel>() {

		@Override
		public AuthLevel createFromParcel(Parcel in) {
			return AuthLevel.valueOf(in.readString());
		}

		@Override
		public AuthLevel[] newArray(int size) {
			return new AuthLevel[size];
		}
	};
	
	private int mLevel;
	private int mFactors;
	private AuthLevel(int level,int factors) {
		this.mLevel=level;
		this.mFactors=factors;
	}
	
	/**
	 * The trust level of the authentication level is the sum of the trust levels of the different authentication
	 * types granted or presented.
	 * 
	 * @return the numeric value of this level
	 */
	public int getTrustLevel() {
		return mLevel;
	}
	
	/**
	 * 
	 * @return the number of "real" authentication factors.
	 */
	public int getFactors() {
		return mFactors;
	}
	
	/**
	 * 
	 * @return the next authentication level which contains a strong authentication factor
	 */
	public AuthLevel getNextStrongLevel() {
	    if(this==NoAuth) {
	        return this;
	    } else {
	        return getTrustLevel()<=StrongAuth.getTrustLevel()?StrongAuth:StrongTwoFactorAuth;
	    }
	}
	
	/**
	 * 
	 * @return <code>true<code> if this auth level requires a strong authentication (that is a PIN/Password/Pattern)
	 */
	public boolean isStrong() {
	    switch(this) {
    	    case StrongAuth:
    	    case StrongTwoFactorAuth:return true;
    	    default:return false;
	    }
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(this.name());
	}
}
