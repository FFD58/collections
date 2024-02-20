package ru.fafurin.lesson2;

// Урок 2. LinkedList
public class Main {
    public static void main(String[] args) {

// 1. Как реализуется Array List?

// Ответ.
//      Array List представляет коллекцию, которая наследует свою функциональность от класса AbstractList и применяет интерфейс List.
//      Array List представляет простой список, аналогичный массиву, за тем исключением, что количество элементов в нём не фиксировано.
//      При добавлении элементов, создается новый массив, затем в него копируются элементы из старого массива.


// 2. Как реализуется Linked List?

// Ответ.
//      LinkedList представляет структуру данных в виде связанного списка.
//      Он наследуется от класса AbstractSequentialList и реализует интерфейсы List, Dequeue и Queue.
//      LinkedList содержит все те методы, которые определены в интерфейсах List, Queue, Deque,
//      т.е. он соединяет функциональность работы со списком и функциональность очереди.

// 3. Сравните их реализации

// Ответ.
//        ArrayList следует использовать, когда в приоритете доступ по индексу,
//        так как эти операции выполняются за константное время.
//        Добавление в конец списка в среднем тоже выполняется за константное время.
//        Кроме того в ArrayList нет дополнительных расходов на хранение связки между элементами.
//        Минусы в скорости вставки/удаления элементов находящихся не в конце списка,
//        так как при этой операции все элементы правее добавляемого/удаляемого сдвигаются.

//        LinkedList удобен когда важнее быстродействие операций вставки/удаления,
//        которые в LinkedList выполняются за константное время.
//        Операции доступа по индексу производятся перебором с начала или конца
//        (смотря что ближе) до нужного элемента.
//        Дополнительные затраты на хранение связки между элементами.
    }
}
