package org.example.leetcode.interview150.easy.stack;


import java.util.Deque;
import java.util.LinkedList;

//71. Simplify Path
//Medium
//Topics
//Companies
//Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.
//
//In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.
//
//The simplified canonical path should adhere to the following rules:
//
//It must start with a single slash '/'.
//Directories within the path should be separated by only one slash '/'.
//It should not end with a slash '/', unless it's the root directory.
//It should exclude any single or double periods used to denote current or parent directories.
//Return the new path.
//
//
//
//Example 1:
//
//Input: path = "/home/"
//
//Output: "/home"
//
//Explanation:
//
//The trailing slash should be removed.
//
//
//Example 2:
//
//Input: path = "/home//foo/"
//
//Output: "/home/foo"
//
//Explanation:
//
//Multiple consecutive slashes are replaced by a single one.
//
//Example 3:
//
//Input: path = "/home/user/Documents/../Pictures"
//
//Output: "/home/user/Pictures"
//
//Explanation:
//
//A double period ".." refers to the directory up a level.
//
//Example 4:
//
//Input: path = "/../"
//
//Output: "/"
//
//Explanation:
//
//Going one level up from the root directory is not possible.
//
//Example 5:
//
//Input: path = "/.../a/../b/c/../d/./"
//
//Output: "/.../b/d"
//
//Explanation:
//
//"..." is a valid name for a directory in this problem.
//
//
//
//Constraints:
//
//1 <= path.length <= 3000
//path consists of English letters, digits, period '.', slash '/' or '_'.
//path is a valid absolute Unix path.
public class _02_SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();

        // Split the input path by "/"
        String[] components = path.split("/");

        // Process each component of the path
        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Move up one directory level
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component); // Push directory or file name onto stack
            }
        }

        // Build simplified path from stack
        StringBuilder simplifiedPath = new StringBuilder();
        while (!stack.isEmpty()) {
            simplifiedPath.append("/").append(stack.pollLast());
        }

        // If the stack is empty, return "/"
        // Otherwise, return the simplified path
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }

    public static void main(String[] args) {
        _02_SimplifyPath solution = new _02_SimplifyPath();

        // Example 1
        String path1 = "/home/";
        System.out.println("Output for Example 1: " + solution.simplifyPath(path1)); // Output: "/home"

        // Example 2
        String path2 = "/home//foo/";
        System.out.println("Output for Example 2: " + solution.simplifyPath(path2)); // Output: "/home/foo"

        // Example 3
        String path3 = "/home/user/Documents/../Pictures";
        System.out.println("Output for Example 3: " + solution.simplifyPath(path3)); // Output: "/home/user/Pictures"

        // Example 4
        String path4 = "/../";
        System.out.println("Output for Example 4: " + solution.simplifyPath(path4)); // Output: "/"

        // Example 5
        String path5 = "/.../a/../b/c/../d/./";
        System.out.println("Output for Example 5: " + solution.simplifyPath(path5)); // Output: "/.../b/d"
    }

}
