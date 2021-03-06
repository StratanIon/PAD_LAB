package md.utm.model;

import java.util.List;

public class Apartment {

    private int id;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Apartment() {
    }

    public Apartment(int id, String address) {
        this.id = id;
        this.address = address;
    }
}
