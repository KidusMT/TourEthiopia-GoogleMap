package com.kidusmt.android.tourethiopia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by KidusMT on 4/8/2017.
 */

public class SplashActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        StartAnimations();

        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(SplashActivity.this,AvailableCities.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        });
        td.start();
    }
    private void StartAnimations() {

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l=(RelativeLayout) findViewById(R.id.rel_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash_image);
        //startButton.clearAnimation();
        iv.clearAnimation();
        //startButton.startAnimation(anim);
        iv.startAnimation(anim);

    }
    @Override
    protected void onPause() {//this on pause method is used for pausing the splash activity and destroy the activity so that
        super.onPause();      //our memory space will not be used. You can refer the activity life cycle from the android website
        finish();
    }

}
