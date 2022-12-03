/*
 * Copyright (C) 2012 The Android Open Source Project
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
package com.android.keyguard;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.service.trust.AuthType;
import android.telephony.SubscriptionManager;

import com.android.internal.telephony.IccCardConstants;
import com.android.internal.widget.LockPatternUtils;
import com.android.keyguard.KeyguardSecurityModel.SecurityMode;

public class KeyguardSecurityModel {

    /**
     * The different types of security available.
     * @see KeyguardSecurityContainer#showSecurityScreen
     */
    public enum SecurityMode {
        Invalid, // NULL state
        None, // No security enabled
        Challenge, // Weak security: Ask the user a challenge.
        Pattern, // Unlock by drawing a pattern.
        Password, // Unlock by entering an alphanumeric password
        PIN, // Strictly numeric password
        SimPin, // Unlock by entering a sim pin.
        SimPuk // Unlock by entering a sim puk
    }

    private final boolean mIsPukScreenAvailable;
    private KeyguardUpdateMonitor mMonitor;
    private LockPatternUtils mLockPatternUtils;

    KeyguardSecurityModel(KeyguardUpdateMonitor monitor,LockPatternUtils utils,Context context) {
        mMonitor = monitor;
        mLockPatternUtils = utils;
        mIsPukScreenAvailable = context.getResources().getBoolean(
                com.android.internal.R.bool.config_enable_puk_unlock_screen);
    }
    
    boolean isLockScreenDisabled(int userId) {
    	return getSecurityMode(userId)==SecurityMode.None||mLockPatternUtils.isLockScreenDisabled(userId);
    }

    SecurityMode getSecurityMode(int userId) {
        //KeyguardUpdateMonitor monitor = KeyguardUpdateMonitor.getInstance(mContext);

        if (mIsPukScreenAvailable && SubscriptionManager.isValidSubscriptionId(
        		mMonitor.getNextSubIdForState(IccCardConstants.State.PUK_REQUIRED))) {
            return SecurityMode.SimPuk;
        }

        if (SubscriptionManager.isValidSubscriptionId(
        		mMonitor.getNextSubIdForState(IccCardConstants.State.PIN_REQUIRED))) {
            return SecurityMode.SimPin;
        }
        int delta=mMonitor.getRemainingTrustWeight(userId);
        if(delta<=0) {
            return SecurityMode.None;
        }
        if(delta<=AuthType.Challenge.getTrustWeight()) {
            return SecurityMode.Challenge;
        }

        final int security = mLockPatternUtils.getActivePasswordQuality(userId);
        switch (security) {
            case DevicePolicyManager.PASSWORD_QUALITY_NUMERIC:
            case DevicePolicyManager.PASSWORD_QUALITY_NUMERIC_COMPLEX:
                return SecurityMode.PIN;

            case DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC:
            case DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC:
            case DevicePolicyManager.PASSWORD_QUALITY_COMPLEX:
            case DevicePolicyManager.PASSWORD_QUALITY_MANAGED:
                return SecurityMode.Password;

            case DevicePolicyManager.PASSWORD_QUALITY_SOMETHING:
                return SecurityMode.Pattern;
            case DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED:
                return SecurityMode.None;

            default:
                throw new IllegalStateException("Unknown security quality:" + security);
        }
    }
}
