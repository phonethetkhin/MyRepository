package com.example.drawersample;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dlMain;
    NavigationView nvMain;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dlMain = findViewById(R.id.dlMain);
        nvMain = findViewById(R.id.nvMain);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(this, dlMain, R.string.open, R.string.close);
        dlMain.addDrawerListener(toggle);
        toggle.syncState();

       /* View headerView = nvMain.getHeaderView(0);
        TextView tvName = headerView.findViewById(R.id.tvName);

        tvName.setText("John");*/

        nvMain.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch (id) {
                case R.id.nav_account: {
                    Toast.makeText(this, "Account Clicked", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.nav_settings: {
                    Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                    break;

                }
                case R.id.nav_logout: {
                    Toast.makeText(this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                    break;
                }
                default:
                    return true;
            }


            return false;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}