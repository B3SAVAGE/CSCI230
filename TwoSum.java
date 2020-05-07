// Course: CSCI 230
//  Name: Ben Hairston
//  Homework Assignment 4
//  Problem 1.1: Leetcode 1 - Two Sum
//  Reference: Zybooks Hash Table Chapter
// Data Structure and Algorithm: HashTable


import java.util.HashMap;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
            int[] answer = new int[2];
            HashMap<Integer, Integer> Hash = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++) {
                if (Hash.containsKey(nums[i])) {
                    answer[0] = Hash.get(nums[i]);
                    answer[1] = i;
                }
                Hash.put(target - nums[i], i);
            }
            return answer;
        }

    }


