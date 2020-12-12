package ru.mirea.pois.data;

public class Customer {
    private String name;
    private double Cost;
    private int numYears;
    private double AllCost;

    public Customer(String name, double cost, int numYears, double allCost) {
        this.name = name;
        Cost = cost;
        this.numYears = numYears;
        AllCost = allCost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return Cost;
    }

    public int getNumYears() {
        return numYears;
    }

    public double getAllCost() {
        return AllCost;
    }
}
