package com.webservicespoint.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;
    String TAG_FIRST="first";
    String TAG_SECOND="second";
    String TAG_THIRD="third";


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFirstFragment();
                    break;
                case R.id.navigation_dashboard:
                    showSecondFragment();
                    break;
                case R.id.navigation_notifications:
                    showThirdFragment();
                    break;
            }
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFirstFragment();

    }

    public void showFirstFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (firstFragment.isAdded()) {
            ft.show(firstFragment);
        } else {
            ft.add(R.id.content, firstFragment, TAG_FIRST);
        }
        if (secondFragment.isAdded()) {
            ft.hide(secondFragment);
        }
        if (thirdFragment.isAdded()) {
            ft.hide(thirdFragment);
        }
        ft.commit();
    }

    public void showSecondFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (secondFragment.isAdded()) {
            ft.show(secondFragment);
        } else {
            ft.add(R.id.content, secondFragment, TAG_SECOND);
        }
        if (firstFragment.isAdded()) {
            ft.hide(firstFragment);
        }
        if (thirdFragment.isAdded()) {
            ft.hide(thirdFragment);
        }
        ft.commit();
    }

    public void showThirdFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (thirdFragment.isAdded()) {
            ft.show(thirdFragment);
        } else {
            ft.add(R.id.content, thirdFragment, TAG_THIRD);
        }
        if (secondFragment.isAdded()) {
            ft.hide(secondFragment);
        }
        if (firstFragment.isAdded()) {
            ft.hide(firstFragment);
        }
        ft.commit();
    }
}
