# Weclick SDK Installation

The following tutorial will guide you to Install Weclick SDK via *jar* file.

##Getting Started

1. First of all download latest version of sdk *jar* file from [release](https://github.com/makbn/Weclick_sdk_sample/releases) tab.
2. Move this file to */libs* folder of your project.
3. After that add this following lines to your **app level module** `buil.gradle` file dependencies:

```gradle
dependencies {
    compile files('libs/androrm.jar')
    //...
}
```
4. Now you should add your `Client Key` and `Application Id` to the `AndroidManifest.xml` file in *Application* scope:

* ```xml
 <meta-data
            android:name="ir.weclick.APPLICATION_ID"
            android:value="YOUR_APPLICATION_IP"/>
  <meta-data
            android:name="ir.weclick.CLIENT_KEY"
            android:value="YOUR_CLIENT_KEY" />
 ```
5. Add following lines for permissions(befor *Application* scope):

```xml
  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
  <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
  <uses-permission android:name="android.permission.INTERNET" />
  <uses-permission android:name="android.permission.READ_PHONE_STATE" />
```

