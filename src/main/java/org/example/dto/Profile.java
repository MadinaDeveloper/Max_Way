package org.example.dto;

import org.example.enums.ProfileStep;

public class Profile {
    private Long id;
    private String username;
    private String name;
    private String phone;
    private ProfileStep profileStep;
    private String lang;
    private String brithday;


    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Profile(Long id) {
        this.id = id;
    }

    public ProfileStep getStep() {
        return profileStep;
    }

    public void setStep(ProfileStep profileStep) {
        this.profileStep = profileStep;
    }

    public String writableString() {
        return id + "#" + username + "#" + name + "#" + phone + "#" + profileStep + "#" + lang+"#"+brithday;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", profileStep=" + profileStep +
                ", lang='" + lang + '\'' +
                ", brithday='" + brithday + '\'' +
                '}';
    }
}
