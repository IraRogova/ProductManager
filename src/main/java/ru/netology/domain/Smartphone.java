package ru.netology.domain;

public class Smartphone extends Product{

    private String brand;

    public Smartphone (){
        super();
    }

    public Smartphone(int id, String name, int price) {
        super(id, name, price);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


}
