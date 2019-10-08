package com.acampdev.heyperu.Models;

public class Tourist {

    private int id;
    private String name;
    private String ubigeo;
    private String img;
    private String description;
    private String lat;
    private String longt;

    public Tourist(String name, String ubigeo, String img, String description, String lat, String longt, int id) {
        this.name = name;
        this.ubigeo = ubigeo;
        this.img = img;
        this.description = description;
        this.lat = lat;
        this.longt = longt;
        this.id = id;
    }


    public Tourist() {
        this.id = id;
        this.name = name;
        this.ubigeo = ubigeo;
        this.img = img;
        this.description = description;
        this.lat = lat;
        this.longt =longt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }
}
