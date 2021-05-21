package com.dapm.android.registrocriminal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class CrimenActivity extends SingleFragmentoActivity {
    @Override
    protected Fragment createFragment() {
        return new FragmentoCrimen();
    }
}
