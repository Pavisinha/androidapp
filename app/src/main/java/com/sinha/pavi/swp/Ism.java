package com.sinha.pavi.swp;

/**
 * Created by pavitrasinha on 14-06-2016.
 */
public class Ism {

    private int imgId;
    private String title;

    public Ism(int imgId, String title) {
        this.imgId = imgId;
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
