/*
Valid Anagram
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int bin[] = new int[26];
        for(char x : s.toCharArray()){
            bin[x - 'a']++;
        }
        for(char x : t.toCharArray()){
            bin[x-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(bin[i] != 0)
                return false;
        }
        return true;
    }
}