package com.example.bioquiz.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class RegisterResponse implements Parcelable {

    private String name;
    private String city;
    private String school;
    private String birthyear;
    private String email;
    private String username;
    private String password;


    protected RegisterResponse(Parcel in) {
        name = in.readString();
        city = in.readString();
        school = in.readString();
        birthyear = in.readString();
        username = in.readString();
        email = in.readString();
        password = in.readString();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(city);
        dest.writeString(school);
        dest.writeString(birthyear);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(password);
    }
}
