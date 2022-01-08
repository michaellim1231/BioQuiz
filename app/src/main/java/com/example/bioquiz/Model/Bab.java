package com.example.bioquiz.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Bab implements Parcelable {

    private List<Babs> babs;

    protected Bab(Parcel in) {
    }

    public static final Creator<Bab> CREATOR = new Creator<Bab>() {
        @Override
        public Bab createFromParcel(Parcel in) {
            return new Bab(in);
        }

        @Override
        public Bab[] newArray(int size) {
            return new Bab[size];
        }
    };

    public static Babs objectFromData(String str) {

        return new Gson().fromJson(str, Babs.class);
    }

    public List<Babs> getBabs() {
        return babs;
    }

    public void setBabs(List<Babs> babs) {
        this.babs = babs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class Babs {
        private int bab_id;
        private String bab;

        public static Babs objectFromData(String str) {

            return new Gson().fromJson(str, Babs.class);
        }

        public int getBab_id() {
            return bab_id;
        }

        public void setBab_id(int bab_id) {
            this.bab_id = bab_id;
        }

        public String getBab() {
            return bab;
        }

        public void setBab(String bab) {
            this.bab = bab;
        }
    }
}


