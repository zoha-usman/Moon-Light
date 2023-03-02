package com.zohausman.e_commerce_zoha_usaman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
  DrawerLayout drawerLayout;
  NavigationView navigationView;
  Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout= findViewById(R.id.drawerLayout);
        navigationView= findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.toolbar);
//        step1
         setSupportActionBar(toolbar);
//         step2

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.OpenDrawer,
                R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id==R.id.navHome){
                    Toast.makeText(MainActivity.this, "home Second time", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.navMyOrder){
                    loadFragment(new AFragment());

                }

                else {
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
        
    }

    public void onBlackPressed(){
    if (drawerLayout.isDrawerOpen(GravityCompat.START)){
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    else {
        super.onBackPressed();
    }
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
         ft.add(R.id.container, fragment);
         ft.commit();
}

}