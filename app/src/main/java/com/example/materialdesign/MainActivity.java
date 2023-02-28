package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RecyclerView fruitRv;
    private ArrayList<String> contentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        fruitRv = findViewById(R.id.fruit_rv);
        NavigationView navView = findViewById(R.id.navView);
        CollapsingToolbarLayout collapsingBar = findViewById(R.id.collapsing_bar);
        AppBarLayout appBar = findViewById(R.id.appbar);

        setSupportActionBar(toolbar);

        navView.setItemIconTintList(null);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.game01:

                        break;
                    case R.id.game02:

                        break;
                    case R.id.game03:

                        break;
                }
                return true;
            }
        });


        FloatingActionButton floatBtn = findViewById(R.id.float_btn);

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "delete here", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "删除撤销", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        fruitRv.setLayoutManager(gridLayoutManager);

        contentList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            contentList.add("这个是第" + i + "项");
        }

        FruitAdapter fruitAdapter = new FruitAdapter(contentList, this);
        fruitRv.setAdapter(fruitAdapter);

        //折叠操作
        appBar.setExpanded(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_toolbar_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_back_up:
                Toast.makeText(this, "点击备份按钮", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, FloatingActivity.class));
                break;
            case R.id.menu_delete:
                Toast.makeText(this, "点击删除按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_setting:
                Toast.makeText(this, "点击设置按钮", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.START);

                break;
        }
        return true;
    }
}