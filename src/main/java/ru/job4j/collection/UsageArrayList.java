package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> objList = new ArrayList<String>();
        objList.add("Petr");
        objList.add("Ivan");
        objList.add("Stepan");
        for (String elem : objList) {
            System.out.println(elem);
        }
    }
}