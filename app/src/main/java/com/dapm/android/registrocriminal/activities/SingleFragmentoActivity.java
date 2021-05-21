package com.dapm.android.registrocriminal.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dapm.android.registrocriminal.R;

public abstract class SingleFragmentoActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_fragmento);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragmento = manager.findFragmentById(R.id.fragment_container);

        if (fragmento == null) {
            fragmento = createFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragmento).commit();
        }
    }
}
