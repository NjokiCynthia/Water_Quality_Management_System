package com.example.wqms.navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wqms.R;
import com.example.wqms.databinding.ActivityNavigateBinding;
//import com.example.wqms.navigation.databinding.ActivityNavigateBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Navigate extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigateBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        View headerView = navigationView.getHeaderView(0);
//        TextView navUsername = (TextView) headerView.findViewById(R.id.navUsername);
//        navUsername.setText("Your Text Here");

//        View nav = navigationView.getHeaderView(0);
//        TextView Username= (ImageView)nav.findViewById(R.id.username);
//        TextView Email= (ImageView)nav.findViewById(R.id.Email);

        setSupportActionBar(binding.appBarNavigate.toolbar);
        binding.appBarNavigate.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_content_navigate);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigate, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigate);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}