package com.aniketvishal.weddingdemo1;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by gautam on 25/2/17.
 */

public class Screenshot_Activity extends AppCompatActivity {
    @BindView(R.id.screenshot_image)
    TouchImageView screenshotimage;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    GradientDrawable gd;

    int image;
    int imagestring;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.screenshot_activity);
        ButterKnife.bind(this);
        imagestring=getIntent().getIntExtra(CONSTANT.textimage,0);
        initilizeFullScreen();

    }

    private void initilizeFullScreen() {

        Picasso.with(getApplicationContext()).load(imagestring).fit().centerInside()
                .placeholder(R.drawable.gradient_mini)
                .into(screenshotimage);
        // screenshotimage.setBackgroundResource(R.drawable.gradient_blue);


    }

}

