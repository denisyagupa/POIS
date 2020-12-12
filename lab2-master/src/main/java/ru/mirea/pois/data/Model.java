package ru.mirea.pois.data;

import org.kie.api.runtime.KieSession;

public class Model {
    Customer customer;
    double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void printResult(double cost){
        System.out.println("Name: " + customer.getName() + "\nOrder cost: " + customer.getCost() + "\nCost with discount: " + cost);
    }


}
