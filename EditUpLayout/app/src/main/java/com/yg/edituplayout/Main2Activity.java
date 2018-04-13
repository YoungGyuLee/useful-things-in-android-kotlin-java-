package com.yg.edituplayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private SoftKeyPadDetector2 mSoftKeyPadDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mSoftKeyPadDetector = new SoftKeyPadDetector2(this);
        mSoftKeyPadDetector.setOnSoftInputListener(mSoftKeyPadChangeListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSoftKeyPadDetector.startDetect();
    }

    @Override
    protected void onPause() {
        mSoftKeyPadDetector.stopDetect();
        super.onPause();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // receive Orientation changed.

    }

    private OnSoftKeyPadListener2 mSoftKeyPadChangeListener = new OnSoftKeyPadListener2() {
        @Override
        public void onSoftKeyPadChanged(boolean visible, int height) {
            if(visible) {
                Toast.makeText(Main2Activity.this, "SoftKeyPad show.\nheight:" + height, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Main2Activity.this, "SoftKeyPad hide.", Toast.LENGTH_SHORT).show();
            }
        }
    };

}
