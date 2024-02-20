package ru.fafurin.lesson4;

import java.util.PriorityQueue;

// Урок 5. PriorityQueue
public class Main {
    public static void main(String[] args) {

// Напишите свой компаратор для тима Customer и используйте его в коде из урока.
        PriorityQueue<Customer> customers = new PriorityQueue<>(new CustomerComparator());

        customers.add(new Customer("name1", 12));
        customers.add(new Customer("name2", 1));
        customers.add(new Customer("name3", 3));
        customers.add(new Customer("name4", 128));

        while (!customers.isEmpty()) {
            System.out.println(customers.poll());
        }

    }
}
