package Seminar_DZ;

import java.util.*;

/**
 * DZ_01 (Seminar_java_06)
 * Задание 1. Объявить и инициализировать экземпляр класса HashSet. Обобщение String.
 * Задание 2. Добавить пять элементов в множество.
 * Задание 3. Отсортировать значения используя итератор.
 * Задание 4. Отсортированный результат сохранить в LinkedHashSet
 * Задание 5. Создать TreeSet с компаратором. 
 * Задание 6. Скопировать содержимое первого множества (HashSet) в TreeSet. 
 * Задание 7. *Скорректировать компаратор так, чтобы поля хранились в обратном порядке.
 */

public class DZ_01 {

    public static void main(String[] args) {
        // 1.
        System.out.println("\n***** Задание 1:");
        HashSet<String> hSet = new HashSet<String>();
        System.out.println("HashSet (hSet): " + hSet);

        // 2.
        System.out.println("\n***** Задание 2:");
        hSet.add("Москва");
        hSet.add("Санкт-Петербург");
        hSet.add("Тула");
        hSet.add("Армавир");
        hSet.add("Кострома");
        System.out.println("HashSet (hSet): " + hSet);

        // 3.
        System.out.println("\n***** Задание 3:");
        LinkedHashSet<String> lhSet = new LinkedHashSet<>();
        lhSet.size();
        if (!hSet.isEmpty()) {
            Iterator<String> it = hSet.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

        // 4.
        System.out.println("\n***** Задание 4:");
        Iterator<String> it = hSet.iterator();
        ArrayList<String> aList = new ArrayList<>();
        while (it.hasNext()) {
            aList.add(it.next());
        }
        Collections.sort(aList);
        for (int i = 0; i < aList.size(); i++) {
            lhSet.add(aList.get(i));
        }
        System.out.println("LinkedHashSet (lhSet): " + lhSet);

        // 5.
        System.out.println("\n***** Задание 5:");
        TreeSet<String> tSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {return 0;}
                if (o1.compareTo(o2)>0) {return 1;}
                else return -1;
            }
        });
        System.out.println("TreeSet (tSet): " + tSet);

        // 6.
        System.out.println("\n***** Задание 6:");
        tSet.addAll(hSet);
        System.out.println("TreeSet (tSet): " + tSet);

        // 7.
        System.out.println("\n***** Задание 7:");
        TreeSet<String> tSetRev = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.equals(o1)) {return 0;}
                if (o2.compareTo(o1)>0) {return 1;}
                else return -1;
            }
        });
        tSetRev.addAll(hSet);
        System.out.println("TreeSet revers (tSetRev): " + tSetRev);
    }
}
