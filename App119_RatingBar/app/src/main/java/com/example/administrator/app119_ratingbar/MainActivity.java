package com.example.administrator.app119_ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView image=(ImageView)findViewById(R.id.image1);
        RatingBar ratingBar=(RatingBar)findViewById(R.id.rationg);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                image.setImageAlpha((int) rating*255/5);
            }
        });
    }
}
