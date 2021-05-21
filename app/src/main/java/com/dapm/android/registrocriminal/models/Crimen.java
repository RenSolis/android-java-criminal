package com.dapm.android.registrocriminal.models;

import java.util.Date;
import java.util.UUID;

public class Crimen {
    private UUID mId;
    private String title;
    private Date date;
    private boolean mResolved;
    private boolean mCrimenMayor;

    public Crimen() {
        this.mId = UUID.randomUUID();
        this.date = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setResolved(boolean resolved) {
        mResolved = resolved;
    }

    public boolean getCrimenMayor() {
        return mCrimenMayor;
    }

    public void setCrimenMayor(boolean tipo) {
        mCrimenMayor = tipo;
    }
}
