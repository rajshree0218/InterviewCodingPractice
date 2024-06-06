package org.example.leetcode.interview150.medium.arrayandstring;

import java.util.TreeMap;

//12. Integer to Roman
//Solved
//Medium
//Topics
//Companies
//Seven different symbols represent Roman numerals with the following values:
//
//Symbol	Value
//I	1
//V	5
//X	10
//L	50
//C	100
//D	500
//M	1000
//Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
//
//If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
//If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
//Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
//Given an integer, convert it to a Roman numeral.
//
//
//
//Example 1:
//
//Input: num = 3749
//
//Output: "MMMDCCXLIX"
//
//Explanation:
//
//3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
// 700 = DCC as 500 (D) + 100 (C) + 100 (C)
//  40 = XL as 10 (X) less of 50 (L)
//   9 = IX as 1 (I) less of 10 (X)
//Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
//Example 2:
//
//Input: num = 58
//
//Output: "LVIII"
//
//Explanation:
//
//50 = L
// 8 = VIII
//Example 3:
//
//Input: num = 1994
//
//Output: "MCMXCIV"
//
//Explanation:
//
//1000 = M
// 900 = CM
//  90 = XC
//   4 = IV
//
//
//Constraints:
//
//1 <= num <= 3999
public class _18_IntegerToRoman {
    public static void main(String[] args) {

    }

    // Best and efficient way:  runtime: 3ms, memory :43.46MB
    // TC & SC both is : O(1)
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (num > 0) {
            if (num >= values[index]) {
                result.append(symbols[index]);
                num -= values[index];
            } else {
                index++;
            }
        }

        return result.toString();
    }

    //runtime:3ms, memory: 43.82MB
    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();

        process(sb, '*' , 'M', '*', num/1000);
        num = num % 1000;

        process(sb, 'M', 'C', 'D', num/100);
        num = num % 100;

        process(sb, 'C', 'X', 'L', num/10);
        num = num % 10;

        process(sb, 'X', 'I', 'V', num);

        return sb.toString();
    }

    void process(StringBuilder sb, char major, char minor, char middle, int val){
        if(val <= 3){
            for(int i = 1; i<=val;i++){
                sb.append(minor);
            }
        }
        else if(val == 4){
            sb.append(minor);
            sb.append(middle);
        }else if(val == 5){
            sb.append(middle);
        }else if(val <=8 ){
            sb.append(middle);
            for(int i = 6; i <= val; i++){
                sb.append(minor);
            }
        }else if(val == 9){
            sb.append(minor);
            sb.append(major);
        }
    }

    //Runtime:3ms, memory: 43.93MB
    public String intToRoman3(int num) {
        StringBuilder sb = new StringBuilder();

        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        char[] symbols = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int index = 0;

        while (num > 0) {
            int quotient = num / values[index];
            num %= values[index];

            if (quotient <= 3) {
                for (int i = 0; i < quotient; i++) {
                    sb.append(symbols[index]);
                }
            } else if (quotient == 4) {
                sb.append(symbols[index]);
                sb.append(symbols[index - 1]);
            } else if (quotient == 5) {
                sb.append(symbols[index - 1]);
            } else if (quotient <= 8) {
                sb.append(symbols[index - 1]);
                for (int i = 6; i <= quotient; i++) {
                    sb.append(symbols[index]);
                }
            } else if (quotient == 9) {
                sb.append(symbols[index]);
                sb.append(symbols[index - 2]);
            }

            index += 2; // Move to the next pair of symbols (e.g., 'M'-'C', 'C'-'X', etc.)
        }

        return sb.toString();
    }


    // Runtime : 3ms, memory: 44.40MB
    // TC & SC both is : O(1)
    public String intToRoman4(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (num > 0) {
            if (num >= values[index]) {
                result.append(symbols[index]);
                num -= values[index];
            } else {
                index++;
            }
        }
        return result.toString();
    }

    // Runtime : 8ms, memory : 44.74MB
    // TC & SC both is : O(1)
    // Time Complexity (TC): O(log num)
    //Space Complexity (SC): O(1)
    //This solution provides an efficient implementation for converting an integer to its Roman numeral representation, with both time and space complexities being constant or logarithmic in terms of the input integer num.
    public String intToRoman5(int num) {
        TreeMap<Integer, String> integerToRomanMap = new TreeMap<>();
        integerToRomanMap.put(1, "I");
        integerToRomanMap.put(4, "IV");
        integerToRomanMap.put(5, "V");
        integerToRomanMap.put(9, "IX");
        integerToRomanMap.put(10, "X");
        integerToRomanMap.put(40, "XL");
        integerToRomanMap.put(50, "L");
        integerToRomanMap.put(90, "XC");
        integerToRomanMap.put(100, "C");
        integerToRomanMap.put(400, "CD");
        integerToRomanMap.put(500, "D");
        integerToRomanMap.put(900, "CM");
        integerToRomanMap.put(1000, "M");

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            int largestDecimal = integerToRomanMap.floorKey(num);
            String romanSymbol = integerToRomanMap.get(largestDecimal);
            result.append(romanSymbol);
            num -= largestDecimal;
        }

        return result.toString();
    }
}
