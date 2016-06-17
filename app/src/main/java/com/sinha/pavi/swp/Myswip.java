package com.sinha.pavi.swp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class Myswip extends FragmentPagerAdapter {


    List<Fragment> fragmentList;

    public Myswip(FragmentManager fm, List<Fragment> fragmentList)

    {
        super(fm);
        this.fragmentList =fragmentList;

    }

    public Fragment getItem(int position){


        return fragmentList.get(position);


    }


    public int getCount(){


        return fragmentList.size();


    }











}
