package com.example.car;

public class Information {
    private String PersonName;
    private String PersonTel;
    private String CarName;
    private String CarLogo;

    public Information(String personName, String personTel, String carName, String carLogo) {
        PersonName = personName;
        PersonTel = personTel;
        CarName = carName;
        CarLogo = carLogo;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getPersonTel() {
        return PersonTel;
    }

    public void setPersonTel(String personTel) {
        PersonTel = personTel;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarLogo() {
        return CarLogo;
    }

    public void setCarLogo(String carLogo) {
        CarLogo = carLogo;
    }
}
