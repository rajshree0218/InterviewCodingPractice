package org.example.SystemDesign.lowLevelDesign.designSplitwise;

/*
*
* Design a splitwise
*
* 1. I can add many friend.
* 2. I can create many group
* 3. I can add friends to a particular group
* 4. add/create expense inside group/directly in splitwise app.
* 5. split b/w friends
*
* 1. Requirement:
*   a. Add friends in capability
*   b. Add/manage group
*   c. Add/Manage friends inside a group
*   d. Manage expense inside a group/without a group.
*   e. Split the expense capability
*       -> equal split
*       -> unequal split
*       -> % wise split
*   f. Balance sheet of each user
*
*
* Step 2: Object Identification.
*   a. Splitwise
*   b. User
*   c. Group
*   d. Expense
*   e. Split?
*   f. BalanceSheet
*
* What happens when expense is created?
*
* Lunch :
* Amount : 400
* PaidBy : Rajshree
*
* Split equal : f1 : 100
* Split equal : f2 : 100
* Split equal : f3 : 100
* Split equal : f4 : 100
*
*
* */
public class Main {

    public static void main(String args[]){

        Splitwise splitwise = new Splitwise();
        splitwise.demo();
    }
}
