package com.acampdev.heyperu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbarID);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerLayoutID);
        navigationView=findViewById(R.id.navigationID);
        txtEmail=findViewById(R.id.userEmailID);
        if(savedInstanceState!=null){
            String correo= (String) savedInstanceState.get("KEY");
            txtEmail.setText(correo);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.isCheckable()) menuItem.setCheckable(false);
                else menuItem.setCheckable(true);
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.menuPlacesViews:
                        setFragment(0);
                        break;
                    case R.id.menuSettings:
                        setFragment(1);
                        break;
                    case R.id.menuSalir:
                        setFragment(2);
                        break;
                    default:
                }
                return false;
            }
        });
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        setFragment(0);
    }

    public void  setFragment(int pos){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        switch (pos){
            case 0:
                Lugares lugares= new Lugares();
                transaction.replace(R.id.fragmentID,lugares);
                transaction.commit();
                break;
            case 1:
                Settings settings= new Settings();
                transaction.replace(R.id.fragmentID,settings);
                transaction.commit();
                break;
            case 2:
                Salir salir= new Salir();
                transaction.replace(R.id.fragmentID,salir);
                transaction.commit();
                break;
            default:
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data !=null;
    }
}
