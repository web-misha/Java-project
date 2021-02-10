package com.nure.animals.entities;

public class Wild extends Animals {
	private int idWild;
    private int MaxSpeed;
    private int idAnimals;

    public Wild(){}

    public int getIdWild() {
        return idWild;
    }
    public int getMaxSpeed() {
        return MaxSpeed;
    }
    public int getIdAnimals() {
        return idAnimals;
    }

    public void setIdAnimals(int idAnimals) {
        this.idAnimals = idAnimals;
    }
    public void setIdWild(int idWild) {
        this.idWild = idWild;
    }
    public void setMaxSpeed(int maxSpeed) {
        MaxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Wild{" +
                "idWild=" + idWild +
                ", MaxSpeed=" + MaxSpeed +
                ", idAnimals=" + idAnimals +
                '}';
    }
}
