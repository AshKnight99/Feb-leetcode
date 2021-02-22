/*
Longest Word in Dictionary through Deleting
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.
*/
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = new String();
        for(int i = 0; i < d.size(); i++){
            String str = d.get(i);
            if(str.length() > result.length() || (str.length() == result.length()) && (str.compareTo(result) < 0))
                if(isSubsequence(str,s))result = new String(str);
        }
        return result;
    }
    private boolean isSubsequence(String str, String s){
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(str.charAt(j) == s.charAt(i))
                j++;
            if(j == str.length()) break;
        }
        return j == str.length();
    }
}