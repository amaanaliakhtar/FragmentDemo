package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, FirstFragment.class, null)
                    .commit();
        }

    }

    public void replaceFragment(View view){

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, SecondFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("Second Fragment") // name can be null
                .commit();

    }
}