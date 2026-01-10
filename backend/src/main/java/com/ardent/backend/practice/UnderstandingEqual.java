package com.ardent.backend.practice;

import java.lang.ref.Reference;

public class UnderstandingEqual {
    public static void main(String args[]){
        Student student1 = new Student(1);
        Student student2 = new Student(1);
//
//
////        Reference comparison
//        System.out.println(student1 == student2);
//        System.out.println(student1 + " | " + student2);
//        System.out.println(student1.equals(student2));
//
//        System.out.println(student1.getRoll() == student2.getRoll());
//        System.out.println(student1.getRoll());

        String s = "b";
        String t = "a";
        System.out.println(s == t);
        System.out.println(s.equals(t));



    }
}
