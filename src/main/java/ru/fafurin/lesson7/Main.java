package ru.fafurin.lesson7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Урок 11. HashMap
public class Main {
    public static void main(String[] args) {
// Вам необходимо используя HushMap написать базу данных студентов, реализовать бесконечный цикл,
// пользователь вводит имя студента и оценку и в случае если студент уже внесен в данную базу данных,
// вводимая оценка должна сохраняться в списке и после каждого ввода необходимо осуществлять вывод на экран средней оценки всех студентов

        HashMap<String, Integer> students = new HashMap<>();
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a student name: ");
            String name = scanner.next();
            System.out.println("Enter a student grade: ");
            int grade = scanner.nextInt();
            students.put(name, grade);
            if (students.containsKey(name)) {
                grades.add(grade);
                System.out.println("Average students grade: " + getAverageStudentsGrade(grades));
            }
        }
    }

    private static int getAverageStudentsGrade(ArrayList<Integer> grades) {
        int max = 0;
        for (Integer grade : grades) {
            max+=grade;
        }
        return max/(grades.size());
    }
}
