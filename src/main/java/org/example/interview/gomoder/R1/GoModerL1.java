package org.example.interview.gomoder.R1;

import java.util.HashSet;
import java.util.Set;

public class GoModerL1 {
    public static void main(String[] args) {

        ////CreditCard: id, name, type, expiryDate, customer, savingAccount, primeMember, active, ;
        //// saving account
        //// Customer : odActivated
        //CC : {
        //   customer : {
        //		accounts: [{
        //			svacc:{
        //			}
        //		}]
        //	}
        //}
        //
        //-> cc is having a field, prime member(boolean), convert true only if customer have more than 10L in saving a/c
        //->customer is having a/c, deactivated customer, null values in saving a/c
        //-> customer is having more than a 10 lac, this customer would be having a field, overDraftactivated odActivated.
        //
        //import com.example.CreditCard;
        //
        //rule "Check Customer is primeMember"
        //when
        //	$app : CreditCard(customer.isActive() &&
        //						customer.getSavingAccount().get(0).getAmount()>10L)
        //then
        //	$app.setPrimeMember(true);
        //	customer.setOdActivated(true);
        //	$app.setCustomer();
        //end
        //
        //
        //
        //
        //
        //
        //working memory & prod memory in drools
        //
        //
        //accpet: json/xml
        //return :
        //
        //hierarchy of logger
        //
        //
        //fully MS,
        //tech stack : java8 SB, aws.


        String s1 = "Rajshree";

        String s2 = "soni";

        String s3=  new String("Rajshree");

        String s4=  new String("Rajshree");

        // class: Student: rollno, name, studentClass;
        // unique set of student based on their name and class/

        Set<Student> set = new HashSet<>();
        set.add(new Student("01", "Rajshree","One"));
        set.add(new Student("02", "Rajshree","Two"));
        set.add(new Student("03", "Rajshree","Two"));
        set.add(new Student("04", "Soni","One"));

        set.forEach(e-> System.out.println(e.getName()+" : "+e.getClassName()));


    }
}

class Student {
    private String rollNo;
    private String name;
    private String className;

    public Student(String rollNo, String name, String className){
        this.rollNo = rollNo;
        this.name = name;
        this.className = className;
    }

    public String getRollNo(){
        return rollNo;
    }
    public String getName(){
        return name;
    }
    public String getClassName(){
        return className;
    }
}

//final class ImmutableClass{
//
//    private final int data;
//    private final Map<String, Integer> map;
//    public ImmutableClass(int data){
//        this.data=data;
//    }
//
//    public ImmutableClass(int data, Map<String, Integer> map){
//        this.data=data;
//        map = new HashMap<>();
//        map.put();
//    }
//
//    //getter//private setter
//}
