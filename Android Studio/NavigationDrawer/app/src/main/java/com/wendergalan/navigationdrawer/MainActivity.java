package com.wendergalan.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        view = findViewById(R.id.drawerLayout);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_inbox:
                final Snackbar snackbar = Snackbar.make(view, "CAIXA DE ENTRADA", Snackbar.LENGTH_LONG);
                snackbar.setAction("FECHAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });

                View snackView = snackbar.getView();
                snackView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                TextView snackActionView = snackView.findViewById(android.support.design.R.id.snackbar_action);
                snackActionView.setTextColor(getResources().getColor(android.R.color.white));

                snackbar.show();
                break;
            case R.id.menu_starred:
                Toast.makeText(this, "Menu Favoritos", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_sent_email:
                Toast.makeText(this, "Menu Emails Enviados", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_trash:
                Toast.makeText(this, "Menu Lixeira", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_spam:
                Toast.makeText(this, "Menu Spam", Toast.LENGTH_LONG).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
