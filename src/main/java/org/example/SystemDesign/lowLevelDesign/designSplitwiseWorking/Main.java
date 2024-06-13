package org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking;

public class Main {
    /*
    * Designing a Splitwise application involves multiple components to handle user management, expense management, and settling balances.
    *
    * Core Components:
    * User: Represents a user in the system.
    * Expense: Represents an expense added by a user.
    * Group: Represents a group of users who share expenses.
    * Split: Represents how an expense is split among users.
    * Balance: Represents the balance between users.
    *
    * Classes:
    * User: Represents a user in the system.
    * Expense: Base class for expenses.
    * EqualExpense: Extends Expense for equal splitting.
    * ExactExpense: Extends Expense for exact amounts.
    * PercentageExpense: Extends Expense for percentage-based splitting.
    * Group: Represents a group of users who share expenses.
    * SplitwiseService: Main service class to manage users, expenses, and balances.
    *
    * Explanation:
    * User Class: Represents a user with basic details.
    * Expense Class and its Subclasses: Represents an expense and its different types (equal, exact, percentage-based).
    * Split Class: Represents a portion of the expense assigned to a user.
    * Group Class: Represents a group of users sharing expenses.
    * SplitwiseService Class: Main service class that handles adding users, groups, expenses, and calculating balances.
    * Main Method: Demonstrates adding users, an expense, and showing balances.
    *
    *
    *
    *
    * User Class: Represents a user in the system.
    * Split Class: Represents a part of an expense that a user needs to pay.
    *              Has a relationship with User (composition).
    * Expense Class: Abstract class representing a general expense.
    *                Contains a list of Split objects, representing how the expense is divided.
    *                Has a relationship with User (composition).
    *                Has a relationship with Split (composition).
    *                Is a relationship with EqualExpense, ExactExpense, and PercentageExpense (inheritance).
    * EqualExpense Class: Concrete class extending Expense for equal split expenses.
    *                     Is a relationship with Expense (inheritance).
    * ExactExpense Class: Concrete class extending Expense for exact split expenses.
    *                     Is a relationship with Expense (inheritance).
    * PercentageExpense Class: Concrete class extending Expense for percentage split expenses.
    *                          Is a relationship with Expense (inheritance).
    * Group Class: Represents a group of users.
    *              Has a relationship with User (composition).
    * SplitwiseService Class: Manages users, groups, and expenses.
    *                         Has a relationship with User, Group, and Expense (composition).
    *
    * Relationships:
    * User: Basic entity representing a user.
    * Split: Represents the part of an expense a user is responsible for.
    *        Has a relationship with User.
    * Expense: Abstract base class representing an expense.
    *          Has a relationship with User and Split.
    * EqualExpense, ExactExpense, PercentageExpense: Is a relationship with Expense.
    * Group: Represents a group of users.
    *        Has a relationship with User.
    * SplitwiseService: Manages users, groups, and expenses.
    *                   Has a relationship with User, Group, and Expense.
    *
    * Notes:
    * - This is a simplified implementation focusing on core functionalities.
    * - For a full-fledged application, consider adding more features like user authentication,
    * detailed error handling, persistent storage, and a user interface.
    * - Dependency injection and design patterns can be used to improve code maintainability and scalability.
    *
    * */

    /* UML Diagram
                                +----------------+             +-----------------+
                                |     User       |             |     Split       |
                                |----------------|<------------|-----------------|
                                | - id           |             | - user: User    |
                                | - name         |             | - amount        |
                                | - email        |             +-----------------+
                                | - phone        |
                                +----------------+

                                    | 1
                                    |
                                    | *
                                +---v------------+
                                |    Expense     |
                                |----------------|
                                | - id           |
                                | - amount       |
                                | - paidBy: User |
                                | - splits: List<Split> |
                                | - description  |
                                +----------------+
                                    /|\    /|\
                                     |      |
                                     |      |
                                     |      |
                                +----v-----++ +----v-----++ +----v-----++
                                | EqualExpense | ExactExpense | PercentageExpense |
                                |--------------|--------------|------------------|
                                |              |              |                  |
                                |              |              |                  |
                                +--------------+--------------+------------------+

                                    | 1
                                    |
                                    |
                                    |
                                    | *
                                +---v------------+
                                |    Group       |
                                |----------------|
                                | - id           |
                                | - name         |
                                | - members: List<User> |
                                +----------------+

                                    | *
                                    |
                                    |
                                    |
                                    | *
                                +---v-------------+
                                | SplitwiseService|
                                |-----------------|
                                | - userMap       |
                                | - groupMap      |
                                | - balanceSheet  |
                                |-----------------|
                                | + addUser()     |
                                | + addGroup()    |
                                | + addExpense()  |
                                | + showBalances()|
                                | + showBalance() |
                                +-----------------+

    * */

    /*
    * Factory Pattern:
    * Although the Factory Pattern is not explicitly implemented in your code, it would be a good fit for creating different types of Expense objects (EqualExpense, ExactExpense, PercentageExpense). You could implement a factory class to encapsulate the logic of instantiating these expense objects.
    *
    * Strategy Pattern: This pattern can be inferred in the way different Expense types handle the splitting logic. Each concrete Expense class (EqualExpense, ExactExpense, PercentageExpense) encapsulates the strategy for splitting the expenses differently.
    *
    * Composite Pattern:
    * This pattern is visible in the way Expense objects manage Split objects. The Expense class contains a list of Split objects, treating both individual splits and composite splits uniformly.
    *
    * Model-View-Controller (MVC) (if considering a full application perspective):
    * Although not explicitly shown in your provided code, if you were to expand this to a full application, you might use an MVC pattern where:
    * The User, Expense, Split, and Group classes represent the Model.
    * Methods in SplitwiseService might act as the Controller managing interactions between the user interface (view) and the data (model).
    * The console output in showBalances() and showBalance() methods could be considered a simplistic View.
    *
    * Observer Pattern:
    * This is not explicitly used in your implementation but could be added. For example, users (or the UI) could be notified of changes in their balances by observing the SplitwiseService.
    *
    * Repository Pattern:
    * The SplitwiseService class acts as a repository for managing users, groups, and expenses. It provides methods to add and retrieve these entities.
    * */
}
