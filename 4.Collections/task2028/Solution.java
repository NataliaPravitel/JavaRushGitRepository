package com.javarush.task.task20.task2028;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));

        System.out.println();
        System.out.println("remove 3: ");
        list.remove("3");
        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("8"));

        System.out.println();
        System.out.println("add 16: ");
        list.add("16");
        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 9. The actual parent is " + ((CustomTree) list).getParent("16"));

        System.out.println();
        System.out.println("remove 4, 5, 6: ");
        list.remove("4");
        list.remove("5");
        list.remove("6");
        System.out.println("The list size is " + list.size());
        System.out.println();
        System.out.println("Expected: true. Actual: " + list.add("20"));
        ((CustomTree) list).printChild("1");
        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 1. The actual parent is " + ((CustomTree) list).getParent("20"));
    }
}