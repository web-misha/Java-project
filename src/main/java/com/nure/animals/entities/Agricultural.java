package com.nure.animals.entities;

public class Agricultural extends Animals {
	private int idAgricultural;
    private int Quantity;
    private int idAnimals;

    public Agricultural(){}

    public int getIdAgricultural() {
        return idAgricultural;
    }
    public int getQuantity() {
        return Quantity;
    }
    public int getIdAnimals() {
        return idAnimals;
    }

    public void setIdAgricultural(int idAgricultural) {
        this.idAgricultural = idAgricultural;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
    public void setIdAnimals(int idAnimals) {
        this.idAnimals = idAnimals;
    }

    @Override
    public String toString() {
        return "Agricultural{" +
                "idAgricultural=" + idAgricultural +
                ", Quantity=" + Quantity +
                ", idAnimals=" + idAnimals +
                '}';
    }
}
