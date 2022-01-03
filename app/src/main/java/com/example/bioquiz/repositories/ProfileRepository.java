package com.example.bioquiz.repositories;

import android.util.Log;

import com.example.bioquiz.retrofit.RetrofitService;

public class ProfileRepository {
    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfileRepository";

    private ProfileRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ProfileRepository getInstance(String token) {
        if (profileRepository == null) {
            profileRepository = new ProfileRepository(token);
        }

        return profileRepository;
    }

    public synchronized void resetInstance() {
        if (profileRepository != null) {
            profileRepository = null;
        }
    }

}
