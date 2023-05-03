// Find the difference of two arrays
import java.util.*;
public class DifferenceOfArr{
    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();      // create 2 hashsets
            Set<Integer> set2 = new HashSet<>();
            for(int num : nums1){ set1.add(num); } // add nums1 elements to set1
            for(int num : nums2){ set2.add(num); }  // add nums2 elements to set2
            
            List<List<Integer>> resultList = new ArrayList<>();  // Initialize result list with 2 empty sublists that we will return
            resultList.add(new ArrayList<>());
            resultList.add(new ArrayList<>());
    
            for(int num : set1){                             // just iterate to all elements of set1
                if(!set2.contains(num)){ resultList.get(0).add(num); }
                // add those elements to first sublist of result list, which are not in set2.
            }
            for(int num : set2){                                            // just iterate to all elements of set2
                if(!set1.contains(num)){ resultList.get(1).add(num); }     
                 // add those elements to first sublist of result list, which are not in set1
            }
            return resultList;
        }
    }
}

/*   Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
    Note that the integers in the lists may be returned in any order.
 
 */

 /*  Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is at index 0 of nums2, nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is at index 1 of nums1, nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
  

First create 2 sets. Then add nums1 elements to set1, and nums2 to set2.This will give us 2 sets with unique elements only.
Now,  just iterate to all elements of set1 and add those elements to first sublist of result list, which are not in set2.
Similarly, iterate to all elements of set2 and add those elements to second sublist of result list, which are not in set1.
Now, we got our result list.

Time: O(n)  : n is length of input array with bigger length
Space: O(m) : m is size of hashset with bigger length

 */