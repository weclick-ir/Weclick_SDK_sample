# Weclick SDK Installation

The following tutorial will guide you to Install Weclick SDK via *jar* file.

##Getting Started

* First of all download latest version of sdk *jar* file from [release](https://github.com/weclick-ir/Weclick_SDK_sample/releases) tab.
* Move this file to */libs* folder of your project.
* Add this following lines to your **app level module** `buil.gradle` file dependencies:

```gradle
dependencies {
    compile files('libs/androrm.jar')
    //...
}
```
* Now you should add your `Client Key` and `Application Id` to the `AndroidManifest.xml` file in *Application* scope:

```xml
 <meta-data
            android:name="ir.weclick.APPLICATION_ID"
            android:value="YOUR_APPLICATION_IP"/>
  <meta-data
            android:name="ir.weclick.CLIENT_KEY"
            android:value="YOUR_CLIENT_KEY" />
 ```
* Add following lines for permissions(before *Application* scope):

```xml
  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
  <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
  <uses-permission android:name="android.permission.INTERNET" />
  <uses-permission android:name="android.permission.READ_PHONE_STATE" />
```

##Initilizing SDK

If your app covering device with API 23 and above you should check permissions. after permissons granted initialize Weclick SDK:

```java
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_READ_PHONE_STATE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        } else {
            Weclick.initialize(getApplicationContext());
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Weclick.initialize(getApplicationContext());
                }
                break;

            default:
                break;
        }
    }


}
```

but if your target API is below 23 just add this line in your starting method ( `onCreate`  ) of Ativity:

```java
    Weclick.initialize(getApplicationContext());

```

