/*
Problem
- https://leetcode.com/problems/longest-happy-prefix/

Brute force approach :
- check for different length of prefixes starting from max possible length
- return as soon as you find a happy prefix
- but this will result in TLE exception since it is O(n2) process

Dynamic programming :
- make a DP table of length equal to length of the string
- dp[i] equal to max length of happy prefix
- run a for loop beginning from 1
- if ith char matches the next char of prev. prefix string : dp[i] = dp[i-1]+1 
- else - tricky part - look in code
- finally, return the substring of length dp[s.length()-1] starting from 0
*/
class LongestPrefixSuffix {
    public String longestPrefix(String s) {
        
        int[] dp = new int[s.length()];
        int prevLen = 0;
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(prevLen)==s.charAt(i)){
                dp[i] = prevLen+1;
                prevLen = dp[i];
            }
            else{
                //tricky part : example aabaaa
                if(prevLen!=0){
                    i--;
                    prevLen = dp[prevLen-1];
                }
                else{
                    dp[i] = 0;
                }
            }
        }
        return s.substring(0,dp[s.length()-1]);
    }
}
