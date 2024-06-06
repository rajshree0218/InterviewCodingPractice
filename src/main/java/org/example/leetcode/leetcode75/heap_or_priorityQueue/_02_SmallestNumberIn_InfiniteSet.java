package org.example.leetcode.leetcode75.heap_or_priorityQueue;

import java.util.TreeSet;

//2336. Smallest Number in Infinite Set
//Medium
//Topics
//Companies
//Hint
//You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
//
//Implement the SmallestInfiniteSet class:
//
//SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
//int popSmallest() Removes and returns the smallest integer contained in the infinite set.
//void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
//
//
//Example 1:
//
//Input
//["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
//[[], [2], [], [], [], [1], [], [], []]
//Output
//[null, null, 1, 2, 3, null, 1, 4, 5]
//
//Explanation
//SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
//smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
//smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
//smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
//smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
//                                   // is the smallest number, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
//
//
//Constraints:
//
//1 <= num <= 1000
//At most 1000 calls will be made in total to popSmallest and addBack.
public class _02_SmallestNumberIn_InfiniteSet {

    private TreeSet<Integer> set;
    private int nextSmallest;

    public _02_SmallestNumberIn_InfiniteSet() {
        set = new TreeSet<>();
        nextSmallest = 1;
    }

    public int popSmallest() {
        if (!set.isEmpty()) {
            return set.pollFirst(); // Removes and returns the smallest element in the TreeSet
        } else {
            return nextSmallest++;
        }
    }

    public void addBack(int num) {
        if (num < nextSmallest && !set.contains(num)) {
            set.add(num);
        }
    }

    public static void main(String[] args) {
        _02_SmallestNumberIn_InfiniteSet smallestInfiniteSet = new _02_SmallestNumberIn_InfiniteSet();
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1
        smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 2
        System.out.println(smallestInfiniteSet.popSmallest()); // return 3
        System.out.println(smallestInfiniteSet.popSmallest()); // return 4
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1
        System.out.println(smallestInfiniteSet.popSmallest()); // return 5
        System.out.println(smallestInfiniteSet.popSmallest()); // return 6
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

