package com.nure.animals.entities;

public class Animals {
	private int idAnimals;
    private int Price;
    private String Name;
    private int idClient;

    public  Animals(){}

    public int getIdAnimals(){
        return  idAnimals;
    }
    public int getPrice(){
        return  Price;
    }
    public String getName(){
        return Name;
    }
    public int getIdClient(){
        return idClient;
    }

    public void setIdAnimals(int idAnimals) {
        this.idAnimals = idAnimals;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "idAnimals=" + idAnimals +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", idClient=" + idClient +
                '}';
    }

}
