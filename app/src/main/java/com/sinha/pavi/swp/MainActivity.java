package com.sinha.pavi.swp;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.sinha.pavi.swp.adapter.Sm;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private List<Ism> listSliding;

    private Sm adapter;
    private ListView lvs;
    private DrawerLayout drawerLayout;
    private RelativeLayout maincontent;
    private ActionBarDrawerToggle actionBarDrawerToggle;





    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lvs=(ListView)findViewById(R.id.ls);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        listSliding=new ArrayList<>();
        listSliding.add(new Ism(R.mipmap.ic_launcher,"settings"));
        listSliding.add(new Ism(R.mipmap.ic_launcher,"about"));
        listSliding.add(new Ism(R.mipmap.ic_launcher,"others"));
        adapter=new Sm(this,listSliding);
        lvs.setAdapter(adapter);




        setTitle(listSliding.get(0).getTitle());

        lvs.setItemChecked(0,true);
        drawerLayout.closeDrawer(lvs);
        lvs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

           setTitle(listSliding.get(position).getTitle());
                lvs.setItemChecked(position,true);
                replaceFragment(position);
                drawerLayout.closeDrawer(lvs);


            }
        });


actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_opened,R.string.drawer_closed){


    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        invalidateOptionsMenu();
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
        invalidateOptionsMenu();
    }
}
;


        drawerLayout.setDrawerListener(actionBarDrawerToggle);









        viewPager = (ViewPager) findViewById(R.id.view_pager);
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Product1());
        fragmentList.add(new Product2());
        fragmentList.add(new Product3());

        Myswip myswip = new Myswip(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(myswip);

    }




  public boolean OnCreateOptionsMenu(Menu menu){



      getMenuInflater().inflate(R.menu.main_menu,menu);

return true;

  }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return  true;


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    private void replaceFragment(int pos){

Fragment fragment=null;
        switch (pos){
            case 0:fragment=new Product1();
                break;
            case 1:fragment=new Product2();
                break;
            case 2:fragment=new Product3();
                break;
            default:fragment=new Product1();
                break;


        }

if(null!=fragment){


    android.app.FragmentManager fragmentManager=getFragmentManager();
    android.app.FragmentTransaction transaction =fragmentManager.beginTransaction();
    transaction.replace(R.id.main_content,null);




    transaction.addToBackStack(null);
    transaction.commit();



}

    }



}




