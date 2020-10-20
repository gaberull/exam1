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
```No variants found for 'app'. Check build files to ensure at least one variant exists.```
  - You have opened the project by the project folder instead of by the app folder. Re-open the project but this time select AndroidMidTerm/app as the directory to open by.
```
A problem occurred configuring project ':app'.
> Failed to install the following Android SDK packages as some licences have not been accepted.
     build-tools;28.0.3 Android SDK Build-Tools 28.0.3
     platforms;android-28 Android SDK Platform 28
```
  - You have missing components. Go to Settings->Appearance and Behavior->System Settings->Android SDK and install the missing components listed. Note: There are three tabs. SDK Platforms, SDK Tools, and SDK Update Sites. Also, right above the Apply button there is "Show Package Details." Click that to install specific packages.
