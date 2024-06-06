package org.example.leetcode.leetcode75.bitManipulation;

//1318. Minimum Flips to Make a OR b Equal to c
//Solved
//Medium
//Topics
//Companies
//Hint
//Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
//Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
//
//
//
//Example 1:
//
//
//
//Input: a = 2, b = 6, c = 5
//Output: 3
//Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
//Example 2:
//
//Input: a = 4, b = 2, c = 7
//Output: 1
//Example 3:
//
//Input: a = 1, b = 2, c = 3
//Output: 0
//
//
//Constraints:
//
//1 <= a <= 10^9
//1 <= b <= 10^9
//1 <= c <= 10^9
public class _03_MinFlipsToMake_a_or_b_equalTo_c {

    public int minFlips2(int a, int b, int c) {
        int flips = 0;

        // Check each bit of a, b, and c
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            // If bit i of c is not equal to the bitwise OR of bit i of a and b
            if ((bitA | bitB) != bitC) {
                // If bit i of c is 1, it means at least one of bit i of a or b should be 1
                if (bitC == 1) {
                    // Increment flips if both bit i of a and b are 0
                    if (bitA == 0 && bitB == 0)
                        flips++;
                } else {
                    // If bit i of c is 0, both bit i of a and b should be 0
                    if (bitA == 1)
                        flips++;
                    if (bitB == 1)
                        flips++;
                }
            }
        }

        return flips;
    }

    public int minFlips(int a, int b, int c) {
        int flips = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if ((bitA | bitB) != bitC) { // If a bit in a or b is different from the corresponding bit in c
                if (bitC == 0) { // If the corresponding bit in c is 0
                    flips += (bitA == 1 && bitB == 1) ? 2 : 1; // Flip both a and b if their corresponding bits are both 1
                } else { // If the corresponding bit in c is 1
                    flips += (bitA == 0 && bitB == 0) ? 1 : 0; // Flip either a or b if their corresponding bits are both 0
                }
            }
        }

        return flips;
    }

    public static void main(String[] args) {
        _03_MinFlipsToMake_a_or_b_equalTo_c solution = new _03_MinFlipsToMake_a_or_b_equalTo_c();

        int a1 = 2, b1 = 6, c1 = 5;
        System.out.println(solution.minFlips(a1, b1, c1)); // Output: 3

        int a2 = 4, b2 = 2, c2 = 7;
        System.out.println(solution.minFlips(a2, b2, c2)); // Output: 1

        int a3 = 1, b3 = 2, c3 = 3;
        System.out.println(solution.minFlips(a3, b3, c3)); // Output: 0
    }
}

