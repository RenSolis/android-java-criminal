package com.dapm.android.registrocriminal.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dapm.android.registrocriminal.R;
import com.dapm.android.registrocriminal.models.Crimen;

public class FragmentoCrimen extends Fragment {
    private Crimen mCrimen;
    private EditText mTxtTitulo;
    private Button mBotonFecha;
    private CheckBox mCkbResuelto;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrimen = new Crimen();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_crimen, container, false);

        mTxtTitulo = (EditText) view.findViewById(R.id.titulo_crimen);
        mTxtTitulo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCrimen.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        mBotonFecha = (Button) view.findViewById(R.id.boton_fecha);
        mBotonFecha.setText(mCrimen.getDate().toString());
        mBotonFecha.setEnabled(false);

        mCkbResuelto = (CheckBox) view.findViewById(R.id.ckb_crimen_resuelto);
        mCkbResuelto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCrimen.setResolved(b);
            }
        });

        return view;
    }
}
