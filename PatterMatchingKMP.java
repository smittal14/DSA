/*
this is pattern matching problem
- use naive method : good enough for practical purposes like ctrl+f search
- use KMP : O(n) time complexity

KMP : 
prepare longest prefix suffix array
compare from the beginning of pattern
if match
    increase pattern and string index
    if pattern ends
        increase string index
        move pattern index to zero
if mismatch
    reset pattern index to lps of previous index in pattern
    compare next index in string
    if pattern index reaches zero, no more reduction possible,
        just increase string index
        
Edge cases:
    0 length of haystack and needle
    no needle present in haystack
    no matching pattern
    needle length greater than haystack
    pattern matches from 0 index of hay
    pattern matches till last index of hay
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = computeLPSArray(needle);
        int hIndex = 0;
        int nIndex = 0;
        while(hIndex<haystack.length()){
            if(nIndex == needle.length()) break;
            if(haystack.charAt(hIndex)==needle.charAt(nIndex)){
                hIndex++;
                nIndex++;
            }
            else if(nIndex==0){
                hIndex++;
            }
            else{
                nIndex = lps[nIndex-1];
            }
        }
        if(nIndex!=needle.length()) return -1;
        return hIndex-needle.length();
    }
    
    private int[] computeLPSArray(String s) {
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
        return dp;
    }
}
