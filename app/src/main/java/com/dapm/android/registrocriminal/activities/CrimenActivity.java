package com.dapm.android.registrocriminal.activities;

import androidx.fragment.app.Fragment;

import com.dapm.android.registrocriminal.fragments.FragmentoCrimen;

public class CrimenActivity extends SingleFragmentoActivity {
    @Override
    protected Fragment createFragment() {
        return new FragmentoCrimen();
    }
}
