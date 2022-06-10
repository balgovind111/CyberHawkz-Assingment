package com.example.cyber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;

    String logo_url = "https://s27389.pcdn.co/wp-content/uploads/2021/04/creating-rolling-out-effective-cyber-security-strategy-1024x440.jpeg.optimal.jpeg";


    // images url array for slider images

    private String [] images = {"https://assets.losspreventionmedia.com/uploads/2020/07/cyber-security-hacker-covid-pandemic-1280x720-1.jpg",
            "https://onlinedegrees.sandiego.edu/wp-content/uploads/2020/01/USD-Cyber-Cybersecurity-vs-Information-Security-vs-Network-Security-_2.jpeg",
            "https://media.istockphoto.com/photos/digital-cloud-security-background-concept-picture-id1331943958?b=1&k=20&m=1331943958&s=170667a&w=0&h=rgUhLZ3zSEoCI07y3dx1LWKne-bEp8qfjMC6dXsbtWU="};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo_image = findViewById(R.id.institute_logo);

        Glide.with(this).load(logo_url).into(logo_image);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this , images);

        viewPager.setAdapter(viewPagerAdapter);


        TabLayout tabLayout = findViewById(R.id.tab_strip);

        tabLayout.setupWithViewPager(viewPager);


        // scheduling slider timer

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
    }


    // class for auto sliding images

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < images.length - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }


}
