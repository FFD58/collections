package ru.fafurin.lesson4;

import java.util.Comparator;

class CustomerComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        return customer2.getLoyaltyPoints() - customer1.getLoyaltyPoints();
    }
}