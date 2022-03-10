package com.example.listview;

public class ItemModel {
    private int iconoClass;
    private int iconoList;
    private int imgGrande;

    private String tittle;
    private String subtittle;
    private String desript;
    private String detail;//caja grande


    public ItemModel(int iconoClass, int iconoList, int imgGrande, String tittle, String subtittle, String desript, String detail) {
        this.iconoClass = iconoClass;
        this.iconoList = iconoList;
        this.imgGrande = imgGrande;
        this.tittle = tittle;
        this.subtittle = subtittle;
        this.desript = desript;
        this.detail = detail;
    }

    public int getIconoClass() {
        return iconoClass;
    }

    public void setIconoClass(int iconoClass) {
        this.iconoClass = iconoClass;
    }

    public int getIconoList() {
        return iconoList;
    }

    public void setIconoList(int iconoList) {
        this.iconoList = iconoList;
    }

    public int getImgGrande() {
        return imgGrande;
    }

    public void setImgGrande(int imgGrande) {
        this.imgGrande = imgGrande;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSubtittle() {
        return subtittle;
    }

    public void setSubtittle(String subtittle) {
        this.subtittle = subtittle;
    }

    public String getDesript() {
        return desript;
    }

    public void setDesript(String desript) {
        this.desript = desript;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
