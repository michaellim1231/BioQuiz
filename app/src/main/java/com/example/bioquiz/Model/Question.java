package com.example.bioquiz.Model;

import com.google.gson.Gson;

import java.util.List;

public class Question {

    private List<Soal> soal;

    public static Question objectFromData(String str) {

        return new Gson().fromJson(str, Question.class);
    }

    public List<Soal> getSoal() {
        return soal;
    }

    public void setSoal(List<Soal> soal) {
        this.soal = soal;
    }

    public static class Soal {
        private int soal_id;
        private String soal_text;
        private int stage_id;

        public static Soal objectFromData(String str) {

            return new Gson().fromJson(str, Soal.class);
        }

        public int getSoal_id() {
            return soal_id;
        }

        public void setSoal_id(int soal_id) {
            this.soal_id = soal_id;
        }

        public String getSoal_text() {
            return soal_text;
        }

        public void setSoal_text(String soal_text) {
            this.soal_text = soal_text;
        }

        public int getStage_id() {
            return stage_id;
        }

        public void setStage_id(int stage_id) {
            this.stage_id = stage_id;
        }
    }
}
