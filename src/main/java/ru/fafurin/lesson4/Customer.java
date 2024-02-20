package ru.fafurin.lesson4;

public class Customer {
    private String name;
    private int loyaltyPoints;

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public Customer(String name, int loyaltyPoints) {
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
