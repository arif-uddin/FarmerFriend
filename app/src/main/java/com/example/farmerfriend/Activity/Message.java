package com.example.farmerfriend.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.example.farmerfriend.Fragments.ChatsFragment;
import com.example.farmerfriend.Fragments.UsersFragment;
import com.example.farmerfriend.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class Message extends AppCompatActivity {

    private TabLayout tabLayout;
     private ViewPager viewPager;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser==null)
        {
            Toast.makeText(getApplicationContext(),"Please Login first!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Message.this,Login.class);
            startActivity(intent);
            finish();
        }

        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        viewPager=(ViewPager)findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new ChatsFragment(),"মেসেজ");
        viewPagerAdapter.addFragment(new UsersFragment(),"বিশেষজ্ঞ");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        ViewPagerAdapter(FragmentManager fm){
            super(fm);
            this.fragments=new ArrayList<>();
            this.titles=new ArrayList<>();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(Fragment fragment,String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(firebaseUser==null)
        {
            Toast.makeText(getApplicationContext(),"Please Login first!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Message.this,Login.class);
            startActivity(intent);
            finish();
        }
    }
}