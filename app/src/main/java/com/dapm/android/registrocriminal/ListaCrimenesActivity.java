package com.dapm.android.registrocriminal;

import androidx.fragment.app.Fragment;

public class ListaCrimenesActivity extends SingleFragmentoActivity {
    @Override
    protected Fragment createFragment() {
        return new FragmentoListaCrimenes();
    }
}
