package com.example.miniguides;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Local variables
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the local variables
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);

        // Create adapter to display fragments
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add pages (fragments) to show in tab-layout
        adapter.addFragment(new AllGuidesFragment(),"Alle hulpkaarten");
        adapter.addFragment(new AddGuideFragment(), "Voeg een hulpkaart toe");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
