package com.example.json;

public class Peak {//ha de tener los mismos atributos que el json
    String name;
    String height;
    String prominence;
    String zone;
    String url;
    String country;

    public Peak() {
    }

    public Peak(String name, String height, String prominence, String zone, String url, String country) {
        this.name = name;
        this.height = height;
        this.prominence = prominence;
        this.zone = zone;
        this.url = url;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getProminence() {
        return prominence;
    }

    public void setProminence(String prominence) {
        this.prominence = prominence;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
