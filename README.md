# AOSP Extensions

This repository defines extensions to the AOSP project mostly directed to login management. It introduces two factor (or three factor) authentication to the login with different "strong factors" (like **strong** for PIN/pattern/password, **normal** for biometric authentication and **weak** for the new challenge authentication. Typically, a user can login for a two factor weak authentication requiring a **normal** and **weak** authentication which is less than a one factor **strong** authentication. Later version will make this configurable in the security settings.

The extensions allow the usage of escrow tokens for login. Therefore, a **strong** authentication is required for setting up the system but not for login since **normal** plus **weak** is sufficient. Parents can set up the phone for there children who provides login via fingerprint and solving a "challenge" like a math problem.

All icons are taken or derived from the [OpenMoji Project](https://openmoji.org).

## Installation

We assume, you have the AOSP project checked out and in place. An introduction can be found [here](https://source.android.com/docs/setup).

At present, the extensions are developed on the branch android-10.0.0_r4 (with build id QP1A.191005.007) and installed on a Pixel 3a (target `aosp_sargo-userdebug`) and target `aosp_x86_64-eng` for development. It is strongly recommended to use this branch for starting.

### Setup

To setup, checkout this repository and import it into eclipse. Edit the variable `AOSP_HOME` of the project from `/home/notalexa/android` to the correct place of your AOSP project. The project should compile now (well, with the exception of 2 errors) and the directory `aosp-frameworks` should point to the frameworks directory and `aosp-build` to the build directory. Copy the content of `src/frameworks` to `aosp-frameworks` and `src/build` to `aosp-build` and check that timestamps are newer for `make`to reprocess. The workspace should show errors now. Call `make` in the AOSP home directory. **This will force an error since the API has changed (and the changes are not checked in).** Follow the hint in the error message and call 

	make api-stubs-docs-update-current-api
	
and `make` again. After this (and a refresh) the workspace should be error free again.
	
### Prepare Android Studio

Apps are developed in Android Studio and an SDK is needed to create emulators. Call `make sdk sdk_repo`. Calling this the first time may produce errors because some targets needed are not build automatically. In our case, the command 

	make libaapt2_jni \
		dmtracedump \
		etc1tool \
		deployagent \
		aapt \
		split-select \
		bcc_compat \
		apksigner \
		dx \
		layoutlib-legacy


was sufficient. Create a directory `<updateSite>` (`~/updateSite` for now) and copy the files `out/host/linux-x86/sdk/aosp_x86_64/sdk-repo-linux-system-images-eng.notalexa.zip` and `out/host/linux-x86/sdk/aosp_x86_64/repo-sys-img.xml` to this directory. Edit `repo-sys-img.xml` and change the `<sdk:revision>` to some higher value, the `<sdk:tag-id>` to `notalexa` and the `<sdk:tag-display>` to `Not Alexa Android System Image`. Modify `<sdk:url>` and add `file://<updateSite>/` to the url (with the directory value of course).

Every time you changed the image using `make sdk sdk_repo`, you should update the system image file and modify the `repo-sys-img.xml` incrementing `<sdk:revision>` and update `<sdk:size>` and `<sdk:checksum>` to the new values.

We are now ready to setup Android Studio. Open the SDK manager. Android 10.1 should be installed. Go to the update sites and edit the custom update site (if already used create a new one). As URL choose `file:/<updateSite>/repo-sys-img.xml` (with the correct directory of course) and enable it. (If you want to use http to develop on another machine, you have to setup a server.)

In the list of SDK Platforms enable the Show Package Details checkbox and scroll to Android 10.0 (Q). The last item should be "Notalexa Android System Image..". Install this.

In the last step create a new virtual device (Pixel 3a for example) and choose as image the appropriate image in the x86 Images (Target is Android 10.0 (Notalexa Android System Image). Start it and setup a PIN.

## Using the Lock Screen Manager and demo apps

Changes to the system are not directly visible. To demonstrate the capabilities use the [Lock Screen Manager](https://github.com/notalexa/aosp_lockscreenmanager#readme) and the [Demo Apps](https://github.com/notalexa/android_demoapps#readme). After setting up the Manager (and enabling it removing the `#` in the mentioned make file) and importing the Android Project in Android Studio, you should update the SDK (including a higher revision number) and restart the emulator (using a cold boot). In the security setup, you can see the Lock Screen Manager now as an activie trust agent. Install the demo apps and configure the manager.

1. Enable the demo apps shown in the configuration activity. (Some, like the fortune app, has own configurations. Try them &#x1f600;...)
1. Enable pinless boot in the advance settings section. This is intended for parent/child configuration in which the child can reboot his phone without entering the pin.
1. Grant trust by the agent. If biometric trust is granted, it is sufficient to solve the challenge to login. Interesting for phones reused as devices in a smart home.
 


