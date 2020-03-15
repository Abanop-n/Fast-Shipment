package com.example.android.fastshipv1;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class home1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);



        BottomNavigationView bottomnav = (BottomNavigationView) findViewById(R.id.Buttomnav);
        bottomnav.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,new Home_fragement()).commit();






    }

    protected BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selected = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selected = new Home_fragement();


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer , selected).commit();
            return true;
        }
    };

}
