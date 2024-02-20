package ru.fafurin.lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

// Урок 3. Comparable / Comparator
public class Main {
    public static void main(String[] args) {

//    Нужно отсортировать случайный список чисел.
//    Числа нужно отсортировать следующим образом:
//    Четные идут в начале по возрастанию, нечетные по убыванию в конце списка.

        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int x = 0; x < 30; x++) {
            numbers.add(random.nextInt(100));
        }

        numbers.sort(new IntegerComparator());

        for (Integer number : numbers) {
            if (number % 2 != 0) list.addLast(number);
            if (number % 2 == 0) list.addFirst(number);
        }
        System.out.println(list);
    }
}

