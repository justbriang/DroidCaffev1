package com.example.droidcaffev1.models;

public class Hotel {
    private int Himage;
    private String Htitle;
    private String Hdescription;

    public Hotel() {
    }

    public Hotel(int himage, String htitle, String hdescription) {
        Himage = himage;
        Htitle = htitle;
        Hdescription = hdescription;
    }

    public int getHimage() {
        return Himage;
    }

    public void setHimage(int himage) {
        Himage = himage;
    }

    public String getHtitle() {
        return Htitle;
    }

    public void setHtitle(String htitle) {
        Htitle = htitle;
    }

    public String getHdescription() {
        return Hdescription;
    }

    public void setHdescription(String hdescription) {
        Hdescription = hdescription;
    }
}
