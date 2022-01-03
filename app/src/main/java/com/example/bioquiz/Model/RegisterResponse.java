package com.example.bioquiz.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class RegisterResponse implements Parcelable {

    private String name;
    private String email;
    private String password;
    private String password_confirmation;

    protected RegisterResponse(Parcel in) {
        name = in.readString();
        email = in.readString();
        password = in.readString();
        password_confirmation = in.readString();
    }

    public static final Creator<RegisterResponse> CREATOR = new Creator<RegisterResponse>() {
        @Override
        public RegisterResponse createFromParcel(Parcel in) {
            return new RegisterResponse(in);
        }

        @Override
        public RegisterResponse[] newArray(int size) {
            return new RegisterResponse[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(password_confirmation);
    }
}
