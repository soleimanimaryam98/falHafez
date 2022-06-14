package com.example.falhafez;

// ایجاد یک مدل بر اساس API برای بیوگرافی کاربران
public class ModelBio {
    long id;
    String name;
    String description;
    String fullUrl;
    long rootCatId;
    String nickname;
    boolean published;
    String imageUrl;
    int birthYearInLHijri;
    boolean validBirthDate;
    int deathYearInLHijri;
    boolean validDeathDate;
    int pinOrder;
    String birthPlace;
    double birthPlaceLatitude;
    double birthPlaceLongitude;
    String deathPlace;
    double deathPlaceLatitude;
    double deathPlaceLongitude;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public long getRootCatId() {
        return rootCatId;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isPublished() {
        return published;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getBirthYearInLHijri() {
        return birthYearInLHijri;
    }

    public boolean isValidBirthDate() {
        return validBirthDate;
    }

    public int getDeathYearInLHijri() {
        return deathYearInLHijri;
    }

    public boolean isValidDeathDate() {
        return validDeathDate;
    }

    public int getPinOrder() {
        return pinOrder;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public double getBirthPlaceLatitude() {
        return birthPlaceLatitude;
    }

    public double getBirthPlaceLongitude() {
        return birthPlaceLongitude;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public double getDeathPlaceLatitude() {
        return deathPlaceLatitude;
    }

    public double getDeathPlaceLongitude() {
        return deathPlaceLongitude;
    }
}

