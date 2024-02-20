package ru.fafurin.lesson3;

import java.util.Comparator;

class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer number1, Integer number2) {
        return number2 - number1;
    }
}