package com.ttopacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import com.ttopacademy.ui.fragments.CategoryListFragment;
import dagger.hilt.android.AndroidEntryPoint;

/** Main Activity for app. */
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_view);

        if (fragment == null) {
            fragment = new CategoryListFragment();
            fm.beginTransaction().add(R.id.fragment_container_view, fragment).commit();
        }
    }
}