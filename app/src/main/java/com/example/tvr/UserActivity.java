package com.example.tvr;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tvr.user.PodcastFragment;
import com.example.tvr.user.Program10Fragment;
import com.example.tvr.user.Program11Fragment;
import com.example.tvr.user.Program12Fragment;
import com.example.tvr.user.Program1Fragment;
import com.example.tvr.user.Program2Fragment;
import com.example.tvr.user.Program3Fragment;
import com.example.tvr.user.Program4Fragment;
import com.example.tvr.user.Program5Fragment;
import com.example.tvr.user.Program6Fragment;
import com.example.tvr.user.Program7Fragment;
import com.example.tvr.user.Program8Fragment;
import com.example.tvr.user.Program9Fragment;
import com.example.tvr.user.RadioFragment;
import com.google.android.material.navigation.NavigationView;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        // Inisialisasi DrawerLayout
        drawerLayout = findViewById(R.id.drawerLayout);

        // Inisialisasi ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Inisialisasi NavigationView
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        // Tampilkan fragment Program1Fragment saat aplikasi pertama kali dijalankan
        displaySelectedFragment(new Program1Fragment());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        // Periksa id menu yang dipilih
        switch (id) {
            case R.id.nav_program1:
                displaySelectedFragment(new Program1Fragment());
                break;
            case R.id.nav_program2:
                displaySelectedFragment(new Program2Fragment());
                break;
            case R.id.nav_program3:
                displaySelectedFragment(new Program3Fragment());
            case R.id.nav_program4:
                displaySelectedFragment(new Program4Fragment());
                break;
            case R.id.nav_program5:
                displaySelectedFragment(new Program5Fragment());
                break;
            case R.id.nav_program6:
                displaySelectedFragment(new Program6Fragment());
                break;
            case R.id.nav_program7:
                displaySelectedFragment(new Program7Fragment());
                break;
            case R.id.nav_program8:
                displaySelectedFragment(new Program8Fragment());
                break;
            case R.id.nav_program9:
                displaySelectedFragment(new Program9Fragment());
                break;
            case R.id.nav_program10:
                displaySelectedFragment(new Program10Fragment());
                break;
            case R.id.nav_program11:
                displaySelectedFragment(new Program11Fragment());
                break;
            case R.id.nav_program12:
                displaySelectedFragment(new Program12Fragment());
                break;
            case R.id.nav_podcast:
                displaySelectedFragment(new RadioFragment());
                break;
            case R.id.logout:
                logout();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displaySelectedFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, fragment);
        fragmentTransaction.commit();
    }

    private void logout(){
        // Menghapus Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        // Lakukan tindakan lain setelah logout, seperti memindahkan pengguna ke halaman login
        Intent intent = new Intent(UserActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Menutup MainActivity agar tidak dapat dikembalikan dengan tombol back
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
