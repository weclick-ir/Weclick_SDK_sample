package ir.weclick.weclicksdkstarter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import ir.weclick.Weclick;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_READ_PHONE_STATE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check for permission
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        //if permission doesn't granted you should request permission
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        }
        //or permission granted and you should initialize Weclick here
        else {
            Weclick.initialize(getApplicationContext());
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                    //after requesting permission next step is initializing SDK
                    Weclick.initialize(getApplicationContext());
                }
                break;

            default:
                break;
        }
    }
}
