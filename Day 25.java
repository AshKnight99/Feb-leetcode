/*
Shortest Unsorted Continuous Subarray
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
Return the shortest such subarray and output its length.
 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?
*/
//O(n) approach
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length - 1, left = -1, right = -1,
            max = nums[0], min = nums[len];
        for (int i = 1; i <= len; i++) {
            int a = nums[i], b = nums[len - i];
            if (a < max) right = i;
            else max = a;
            if (b > min) left = i;
            else min = b;
        }
        return Math.max(0, left + right - len + 1);
    }
}
/*
O(NlogN approach)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
      
        int arr[] = nums.clone();
        Arrays.sort(arr);
        int left = -1, right = -1;
        int i = 0, j = n - 1;
        while(i < n){
            if(arr[i] != nums[i]){
                if(left == -1)
                    left = i;
            else right = i;
                }
            i++;
        }
        
        return left == -1 ? 0 : right - left + 1;
    }
}
*/