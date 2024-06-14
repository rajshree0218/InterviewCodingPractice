package org.example.interview.Infosys.R1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InfosysL1 {
    public static void main(String[] args) {

        //Write a function that takes an integer array and moves all 0s (zeros) to the end of the array
        // while maintaining the relative order of non-zero elements (in-place).

        int[] arr = {0,2,19,0,0,5};
        // o/p: 2, 19, 5, 0,0,0
        int n= arr.length;
        int j=0;
        for(int i=0; i<n; i++){
            if(arr[i] != 0){ //
                arr[j++] = arr[i];
            }
        }
        while(j<n){
            arr[j++] = 0;
        }

        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));

        // Employee :
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Rajshree", "01"));
        list.add(new Employee("Shree", "02"));
        list.add(new Employee("ABC", "03"));

        System.out.println();
        //Write a program to sort a list of employees by name
        List<Employee> employeeList = list.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        employeeList.forEach(e-> System.out.println(e.getName()));


        //Write a function that takes an integer array and a d value,
        // and rotates the elements of the array by d positions (in-place or by returning a new array).
        //As an example; if a==2, then array = {0,1,2,3,4} would become array = {3,4,0,1,2}
        int[] arr1 = {0,1,2,3,4};
        int d = 2;
        // in queue to do.
        // i/p:
        // Output: [4, 5, 1, 2, 3]
        //int[] nums = {1, 2, 3, 4, 5};
        //int d = 8;


//        o/p: 3,4,0,1,2 // 4 3 0 1 2
        int[] arr2 = new int[arr1.length]; // 3 4 0 1 2
        int j1=0;
        int length = arr1.length;
        for(int i=d+1; i<length;i++){
            arr2[j1++] = arr1[i];
        }
        for(int i=0;i<d+1;i++){
            arr2[j1++] = arr1[i];
        }
        for(int i=0;i<length;i++){
            arr1[i] = arr2[i];
        }

        Arrays.stream(arr1).forEach(e-> System.out.print(e+" "));


    }
}

class BST{
    Node root;
    class Node{
        Node prev;
        Node next;
        int data;

        Node(Node node, int data){
            this.data = data;
        }
    }
    // max depth of binary tree
    // 5
    //3         //7
    //1   //2

    // 53127 //
    //
    public  int findMaxDepth(Node root){
        int length = 0;
//        while(root!= null){
//
//        }
//        int leftDepth =
        return length;
    }

//    public Node maxDepth(Node node){
//
//    }
}



class Employee{
    String name;
    String id;

    public Employee(String name, String id){
        this.name = name;
        this.id = id;
    }

    //getter setter
    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }
}