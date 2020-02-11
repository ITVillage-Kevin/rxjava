package com.itvillage.chapter04.chapter0401;

public class Car {
    private CarMaker carMaker;
    private CarType carType;
    private String carName;
    private int carPrice;
    private boolean isNew;

    public Car(CarMaker carMaker, CarType carType, String carName, int carPrice, boolean isNew) {
        this.carMaker = carMaker;
        this.carType = carType;
        this.carName = carName;
        this.carPrice = carPrice;
        this.isNew = isNew;
    }

    public CarMaker getCarMaker() {
        return carMaker;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public boolean isNew() {
        return isNew;
    }
}
