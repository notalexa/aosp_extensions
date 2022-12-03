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

/**
 * The different authentication types of the system. Each type has a (unique) bit
 * set and a trust weight indicating the quality of the type.
 * Using the flag, different types can be mixed by defining a bit mask with the given bits, see {@link AuthSet}.
 * <br>
 * This class cannot be used in <code>AIDL</code> files. Use {@link AuthSet} instead.
 * <p>Note that the "real" authentication weights have a weight of <code>1 mod 5</code> and a strong authentication
 * type a weight <code>!=0 mod 10</code> and if the weight <code>mod 10</code> of all real authentication weights
 * are summed up are less than 10.
 * Therefore, we can check for the number of presented "real" authentication factors by taking the weight <code>mod 5</code>
 * and check if a strong authentication is present via a value <code>&gt;5 mod 10</code>.
 * 
 * @author notalexa
 * @see AuthSet
 */
public enum AuthType {
	None(-1,0x0000),
	/**
	 * The strong auth type (representing a PIN, Password, Pattern for example) 
	 */
	Secret(0,0x1011),
	/**
	 * A possession type (representing a FIDO token for example)
	 */
	Possession(1,0x0C01),
	/**
	 * A biometric type (representing a fingerprint or a face for example)
	 */
	Biometric(2,0x0C01),
	/**
	 * A location type (representing a specific WLAN for example)
	 *  
	 */
	Location(3,0x0C01),
	/**
	 * A challenge (representing a math equation for example)
	 */
	Challenge(4,0x0100);
	
	private int mMask;
	private int mWeight;
	private AuthType(int bit,int weight) {
		this.mMask=bit>=0?1<<bit:0;
		this.mWeight=weight;
	}

	/**
	 * 
	 * @return the big flag of this type
	 */
	public int getMask() {
		return mMask;
	}
	
	/**
	 * Each type represents a specific level of confidence. For example, 
	 * a strong auth type (PIN) is highly trusted, a challenge is weakly trusted.
	 * 
	 * @return the trust weight or confidence level of this type
	 */
	public int getTrustWeight() {
		return mWeight;
	}
	
	/**
	 * 
	 * @return <code>true</code> if this type is a strong authentication type
	 */
	public boolean isStrong() {
		return 0!=(mMask&0xF0);
	}
	
	/**
	 * 
	 * @return <code>true</code> if this type is a weak authentication type
	 */
	public boolean isWeak() {
		return 0==(mMask&0xFF);
	}
}
