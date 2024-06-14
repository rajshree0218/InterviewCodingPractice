package org.example.interview.Vlink.R1;

import java.util.Random;

public class VLinkL1 {

    public static void main(String[] args) {
        String[] arr1 = {"aa","bb","cc","dd"};
        String[] arr2 = {"bb", "cc" ,"ee"};
//      output should be :["bb","cc"]
        int n = arr1.length;
        int m = arr2.length;
        for (String s1 : arr1) { //bb
            for (String s2 : arr2) {
                if (s1.equals(s2)) {
                    System.out.println(s1);
                }
            }
        }

        // you have one box inside box, you have 50 balls, and number printed on balls are in range of 1-50.
        //now you picked one ball, tell me which number is printed on that ball.
        // Pick a ball and print the number printed on it
        int pickedNumber = pickBall();
        System.out.println("The number printed on the picked ball is: " + pickedNumber);

        //Employee
        //String name
        //String id;
        //double salary;
        //
        //List<Employee> list = ne ArrayList<>();
        //list.add(new Employee("01","Rajshree"));
        //list.add(new Employee("02","Shree"));
        //list.add(new Employee("03","ABC"));
        //list.add(new Employee("01","TEST"));
        //
        //>10k
        //desc
        //
        //list.stream().filter(e-> e.getSalary()>10000)
        //.sorted(Comparator.comparingDouble(Employee::getSalary))
        //.distinct()
        //.forEach(e-> System.out.println(e));
        //
        //hasmpa id, employee
        //multiple employees having same id, first employee should get stored
        //Map<String, Employee> map = new HashMap<>();
        //list.stream().filter(e-> {
        //	if(!map.containsKey(e.getId())){
        //		map.put(e.getId(), e);
        //	}
        //}).collect(Collectors.toMap());



    }

    private static final int NUM_BALLS = 50;
    private static final Random random = new Random();

    public static int pickBall() {
        // Create an array representing the box with numbers printed on balls
        int[] box = new int[NUM_BALLS];
        for (int i = 0; i < NUM_BALLS; i++) {
            box[i] = i + 1; // Numbers printed on balls are in the range of 1-50
        }

        // Randomly pick a ball from the box
        int randomIndex = random.nextInt(NUM_BALLS);
        return box[randomIndex];
    }

}
