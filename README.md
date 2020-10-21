# Installing Android Studio
- Download Android Studio here https://developer.android.com/studio
  - Leave everything checked and just do a normal install
  - Personalize it how you would like then click finish
  
 # Creating a Project from Scratch
- Choose empty activity
- Name your project
- Choose Kotlin or Java
  - Kotlin can also use java code, so I recommend Kotlin
- Click finish

# Importing a Project from Git
- Click the VCS tab in Android Studio
- Click checkout from version control
- Click git
- Paste the github link into the URL
  - The link for this project is https://github.com/CodyStandridge/AndroidMidTerm.git
- Click clone
- Click yes to open the project
- Leave the setting as is (use explicit module groups and use default gradle wrapper)
- Finally click ok

# Creating a Virtual Device for Testing
- Click AVD Manager (5th button from the right)
- Click create virtual device
- Choose any device (I chose Pixel 2)
- Chose Android Pie or Oreo
- Click next then finish

# Starting
- Main file is MainActivity.kt
  - This is where you will write your code for the most part
- activity_main.xml is where you will make any graphical changes
  - Here you will add buttons, text boxes, layouts, etc. 

# Android Mid Term
- For this project you will need to display the random number gotten from your websites 
- One method for this is to use Volley to make GET requests. 
  - You can find out how to use it here https://developer.android.com/training/volley/request
  - This repository also has example code using Volley to connect to the OU calendar
- In order to make GET request to your website you will need to make endpoints
  - You can find out how to make endpoints for an app engine here: https://cloud.google.com/endpoints/docs/openapi/get-started-app-engine-standard
  - You can find out how to make endpoints for a compute engine here: https://cloud.google.com/endpoints/docs/openapi/get-started-compute-engine-docker
  
# First Launch Errors
```
A problem occurred configuring project ':app'.
> Failed to install the following Android SDK packages as some licences have not been accepted.
     build-tools;28.0.3 Android SDK Build-Tools 28.0.3
     platforms;android-28 Android SDK Platform 28
```
  - You have missing components. Go to Settings->Appearance and Behavior->System Settings->Android SDK and install the missing components listed. Note: There are three tabs. SDK Platforms, SDK Tools, and SDK Update Sites. Also, right above the Apply button there is "Show Package Details." Click that to install specific packages.
```
Task 'wrapper' not found in project ':app'.
```
  - You have the wrong Module SDK selected for the 'app'. Rick click app go to Modules and select the correct SDK version. Should be 28 Android 9.0 Pie for this project.
```
Android Emulator Hypervisor Driver for AMD Processors installation failed. 
To install Android Emulator Hypervisor Driver for AMD Processors follow the instructions found at:
https://github.com/google/android-emulator-hypervisor-driver-for-amd-processors
```
  - You have a driver issue. Make sure you check you update the latest drivers.
  - Android Emulator Hypervisor Driver Windows: https://github.com/google/android-emulator-hypervisor-driver-for-amd-processors/wiki/Is-Hyper-V-really-disabled%3F</br>
  - HAXM: https://github.com/intel/haxm/tree/master/CheckTool</br>
  - Virtualization (VT-x/AMD-V) - Enabling virtualization: https://2nwiki.2n.cz/pages/viewpage.action?pageId=75202968#:~:text=Press%20F2%20key%20at%20startup,changes%20and%20Reboot%20into%20Windows.</br>

# Next Steps
This project is a single Activity without any architecture in it. All the source is within the MainActivity. Which is fine for this project, but it is not ideal for anything larger. There is no data caching, no seperation of concerns, and no way to test this code with unit tests.</br>
</br>
The first step to fix this problem is to learn about ViewModels. It is a way to seperate logic from the UI. To extract code from MainActivity to be able to save data between state changes, ie landscape to portrait.</br>
https://codelabs.developers.google.com/codelabs/kotlin-android-training-view-model/#0</br>
</br>
Next, it would be a good idea to learn about Model View ViewModel architecture. This will get you introduced to data caching and will allow you to close the app, reopen and still have access to what you were doing.</br>
https://codelabs.developers.google.com/codelabs/android-training-livedata-viewmodel/#12</br>
</br>
Finally, you should look into a more advanced architecture such as Clean architecture. This will seperate your logic into seperate modules that can run by themselves for testing, but can also run together. This is a modular setup that allows you to Unit test and Instrumentation test efficiently. Without it, it is very hard to write meaningful tests on Android.</br>
https://codingwithmitch.com/courses/android-clean-architecture/</br>
</br>
As a final note, if you are interested in learning more. Android has one of the greatest documentation and guides I've ever used. There is also a large repository of example open source projects.
https://developer.android.com/guide</br>
https://github.com/android/architecture-components-samples</br>
