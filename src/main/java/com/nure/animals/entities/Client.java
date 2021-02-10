package com.nure.animals.entities;

public class Client {
	private int idClient;
    private String Name;

    public Client(){}

    public int getIdClient(){
        return idClient;
    }
    public String getName(){
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", Name='" + Name + '\'' +
                '}';
    }

}
