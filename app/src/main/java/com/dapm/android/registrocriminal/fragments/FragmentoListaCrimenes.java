package com.dapm.android.registrocriminal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dapm.android.registrocriminal.R;
import com.dapm.android.registrocriminal.models.CrimeLab;
import com.dapm.android.registrocriminal.models.Crimen;

import java.text.SimpleDateFormat;
import java.util.List;

public class FragmentoListaCrimenes extends Fragment {
    private RecyclerView mCrimenesRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_crimenes, container, false);

        mCrimenesRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_crimen);
        mCrimenesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        actualizarUI();

        return view;
    }

    private void actualizarUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crimen> crimenes = crimeLab.getCrimenes();

        mAdapter = new CrimeAdapter(crimenes);
        mCrimenesRecyclerView.setAdapter(mAdapter);
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitulo;
        private TextView mFecha;
        private Crimen mCrimen;
        private ImageView mImageCrime;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_lista_crimen, parent, false));

            itemView.setOnClickListener(this);

            mTitulo = (TextView) itemView.findViewById(R.id.crime_title);
            mFecha = (TextView) itemView.findViewById(R.id.crime_date);
            mImageCrime = (ImageView) itemView.findViewById(R.id.crime_resuelto);
        }

        public void enlazar(Crimen crimen) {
            mCrimen = crimen;
            mTitulo.setText(mCrimen.getTitle());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
            mFecha.setText(dateFormat.format(mCrimen.getDate()));
            mImageCrime.setVisibility(mCrimen.getResolved() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mCrimen.getTitle() + " pulsado", Toast.LENGTH_SHORT).show();
        }
    }

    private class CrimeMayorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitulo;
        private TextView mFecha;
        private Crimen mCrimen;
        private ImageView mImageCrime;

        public CrimeMayorHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_lista_crimen_mayor, parent, false));

            itemView.setOnClickListener(this);

            mTitulo = (TextView) itemView.findViewById(R.id.crime_title);
            mFecha = (TextView) itemView.findViewById(R.id.crime_date);
            mImageCrime = (ImageView) itemView.findViewById(R.id.crime_resuelto);
        }

        public void enlazar(Crimen crimen) {
            mCrimen = crimen;
            mTitulo.setText(mCrimen.getTitle());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
            mFecha.setText(dateFormat.format(mCrimen.getDate()));
            mImageCrime.setVisibility(mCrimen.getResolved() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mCrimen.getTitle() + " pulsado policia", Toast.LENGTH_SHORT).show();
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter {
        private List<Crimen> mCrimenes;

        public CrimeAdapter(List<Crimen> crimenes) {
            mCrimenes = crimenes;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            if (viewType == 0) {
                return new CrimeHolder(layoutInflater, parent);
            }

            return new CrimeMayorHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Crimen crimen = mCrimenes.get(position);

            if (crimen.getCrimenMayor()) {
                CrimeMayorHolder crimeMayorHolder = (CrimeMayorHolder) holder;
                crimeMayorHolder.enlazar(crimen);
            } else {
                CrimeHolder crimeHolder = (CrimeHolder) holder;
                crimeHolder.enlazar(crimen);
            }
        }

        @Override
        public int getItemCount() {
            return mCrimenes.size();
        }

        @Override
        public int getItemViewType(int position) {
            Crimen crimen = mCrimenes.get(position);

            if (crimen.getCrimenMayor()) {
                return 1;
            }

            return 0;
        }
    }
}
