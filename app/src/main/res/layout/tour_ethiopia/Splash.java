package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/*
 * Created by KidusMT on 5/3/2016.
 */
public class Splash extends Activity implements View.OnClickListener {

    Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        startButton = (Button)findViewById(R.id.start_button);
        StartAnimations();
        startButton.setOnClickListener(this);
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
        startButton.clearAnimation();
        iv.clearAnimation();
        startButton.startAnimation(anim);
        iv.startAnimation(anim);

    }
    @Override
    protected void onPause() {//this on pause method is used for pausing the splash activity and destroy the activity so that
        super.onPause();      //our memory space will not be used. You can refer the activity life cycle from the android website
        finish();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(com.googleplaystore.kidusmt.tour_ethiopia.Splash.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        com.googleplaystore.kidusmt.tour_ethiopia.Splash.this.finish();
    }
}
