package com.dapm.android.registrocriminal;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crimen> mCrimenes;

    private CrimeLab(Context context) {
        mCrimenes = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Crimen crimen = new Crimen();
            crimen.setTitle("Crimen #: " + i);
            crimen.setResolved((i % 2) == 0);
            crimen.setCrimenMayor((i % 2) == 0);

            mCrimenes.add(crimen);
        }
    }

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }

        return sCrimeLab;
    }

    public List<Crimen> getCrimenes() {
        return mCrimenes;
    }

    public Crimen get(UUID id) {
        for (Crimen c: mCrimenes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }
}
