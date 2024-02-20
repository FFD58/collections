package ru.fafurin.lesson6;

import java.util.TreeSet;

// Урок 9. SortedSet / NavigableSet / TreeSet
public class Main {
    public static void main(String[] args) {
// Вам нужно реализовать класс, создать сет студентов и попробуйте его поместить в TreeSet.
        TreeSet<Student> students = new TreeSet<>();

        students.add(new Student("student1", 2));
        students.add(new Student("student2", 3));
        students.add(new Student("student3", 5));
        students.add(new Student("student4", 2));
        students.add(new Student("student5", 4));

        System.out.println(students);
    }
}
