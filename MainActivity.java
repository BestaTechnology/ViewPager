package com.example.viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPager();
    }
    private void setupViewPager(){

        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentOne());
        adapter.addFragment(new FragmentTwo());
        adapter.addFragment(new FragmentThree());

        ViewPager vp  = (ViewPager) findViewById(R.id.viewpager);

        vp.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        //pass the view pager to the tab layout

        tabLayout.setupWithViewPager(vp);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.blue));
        tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.black));


        // set the tabs Index and set text, icon, etc for your tabs


        tabLayout.getTabAt(0).setText("Page One");
        tabLayout.getTabAt(1).setText("Page two");
        tabLayout.getTabAt(2).setText("Page Three");
    }

    class  SectionPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragmenrlist = new ArrayList<>();

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int i)
        {
            return mFragmenrlist.get(i);
        }

        @Override
        public int getCount()


        {
            return mFragmenrlist.size();
        }

        public void addFragment(Fragment fragment)


        {
            mFragmenrlist.add(fragment);
        }
    }
}
