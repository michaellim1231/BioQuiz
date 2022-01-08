package com.example.bioquiz.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Stage implements Parcelable {
    private List<Stages> stages;

    protected Stage(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Stage> CREATOR = new Creator<Stage>() {
        @Override
        public Stage createFromParcel(Parcel in) {
            return new Stage(in);
        }

        @Override
        public Stage[] newArray(int size) {
            return new Stage[size];
        }
    };

    public static Stages objectFromData(String str) {

        return new Gson().fromJson(str, Stages.class);
    }

    public List<Stages> getStages() {
        return stages;
    }

    public void setStage(List<Stages> stages) {
        this.stages = stages;
    }

    public static class Stages {
        private int stage_id;
        private String stage;
        private int bab_id;

        public static Stages objectFromData(String str) {

            return new Gson().fromJson(str, Stages.class);
        }

        public int getStage_id() {
            return stage_id;
        }

        public void setStage_id(int stage_id) {
            this.stage_id = stage_id;
        }

        public String getStage() {
            return stage;
        }

        public void setStage(String stage) {
            this.stage = stage;
        }

        public int getBab_id() {
            return bab_id;
        }

        public void setBab_id(int bab_id) {
            this.bab_id = bab_id;
        }
    }
}