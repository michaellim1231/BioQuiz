package com.example.bioquiz.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Material implements Parcelable
{
    private List<Materi> materi;

    protected Material(Parcel in) {
    }

    public static final Creator<Material> CREATOR = new Creator<Material>() {
        @Override
        public Material createFromParcel(Parcel in) {
            return new Material(in);
        }

        @Override
        public Material[] newArray(int size) {
            return new Material[size];
        }
    };

    public static Materi objectFromData(String str) {

        return new Gson().fromJson(str, Materi.class);
    }

    public List<Materi> getMateri() {
        return materi;
    }

    public void setMateri(List<Materi> materi) {
        this.materi = materi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class Materi {
        private int material_id;
        private String bab_material;
        private String desc_material;

        public static Materi objectFromData(String str) {

            return new Gson().fromJson(str, Materi.class);
        }

        public int getMaterial_id() {
            return material_id;
        }

        public void setMaterial_id(int material_id) {
            this.material_id = material_id;
        }

        public String getBab_material() {
            return bab_material;
        }

        public void setBab_material(String bab_material) {
            this.bab_material = bab_material;
        }

        public String getDesc_material() {
            return desc_material;
        }

        public void setDesc_material(String desc_material) {
            this.desc_material = desc_material;
        }
    }
}

