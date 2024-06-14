package org.example.interview.Coforge.R1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoforgeL1 {
    public static void main(String[] args) {
//        Q1. Sort the list based on number of occurences
//        Input: {2, 5, 2, 6, 8, 5, 8, 2}
//        Output: {6, 5, 5, 8, 8, 2, 2, 2}
        List<Integer> list = Arrays.asList(2, 5, 2, 6, 8, 5, 8, 2);
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<Integer, Long>> sortedList = map.entrySet().stream().sorted(Comparator.comparingLong(Map.Entry::getValue))
                .collect(Collectors.toList());

        sortedList.forEach(e-> { // 6=1, 5=2, 8=2, 2=3
            long length = e.getValue();
            for(int i =0; i<length ; i++){
                System.out.print(e.getKey() +" ");
            }
        });
        System.out.println();
        //-------------------

        // Q2.
//        The number 39 will reduce as
//        Step 1 :(39 → 3x9 = 27) →
//        Step 2 : (27 → 2x7 =  14) →
//        Step 3 : (14 → 1x4 = 4)
        int number = 39;
        while (number >= 10) {
            int product = 1;
            while (number != 0) {
                product *= number % 10;
                number /= 10;
            }
            number = product;
        }
        System.out.println(number);
        //----------------------------


        // Q3 check the below content of two string without equals method
        String s1 = "Hello World";
        String s2 = new String("Hello World");
        //with java8
        boolean same = IntStream.range(0, Math.min(s1.length(), s2.length()))
                .allMatch(i -> s1.charAt(i) == s2.charAt(i));

        if (same && s1.length() == s2.length()) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }


        // without java8
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        if (arr1.length != arr2.length) {
            System.out.println("Not Same");
        } else {
            boolean flag = true;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Same");
            } else {
                System.out.println("Not Same");
            }
        }

        boolean flag = false;
        for(int i = 0; i<s1.length();i++){
            for(int j = 0; j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }

        if(flag)
            System.out.println("Same");
        else    System.out.println("Not Same");
        //----------------------------------------


        // Q4. write a rest api for below, as request contains capital Id, same as for Name etc, so write model class as well. what happen if you made these  members private in the class.  if those are public then it will work.
        //Request
        //{
        //"Id":"100",
        //"Name":"Ram",
        //"Salary":"10000"
        //}

        //REst api
        //
        //@RestController
        //@RequestMapping("api")
        //public class Test{
        //
        //	@PostMapping("addData")
        //	public ResponseEntity<String> saveData(@RequestBody Employee employee){
        //		String vari = service.saveData;
        //		return ResponseEntity.ok(vari, HttpStatus.CREATED);
        //	}
        //}
        //
        //@Data
        //class Employee {
        //	private int Id;
        //	private String Name;
        //	private double Salary;
        //}
        //
        //
        //
        //localhost:8080/api/addData

    }
}
