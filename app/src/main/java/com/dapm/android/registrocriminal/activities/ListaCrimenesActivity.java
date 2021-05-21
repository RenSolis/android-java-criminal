package com.dapm.android.registrocriminal.activities;

import androidx.fragment.app.Fragment;

import com.dapm.android.registrocriminal.fragments.FragmentoListaCrimenes;

public class ListaCrimenesActivity extends SingleFragmentoActivity {
    @Override
    protected Fragment createFragment() {
        return new FragmentoListaCrimenes();
    }
}
