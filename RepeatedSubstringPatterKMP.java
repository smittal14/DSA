/*
https://leetcode.com/problems/remove-k-digits/

find lps of the string of length n
let lps be n-x
that means first x characters are equal to next x characters (use pen and paper)

that means if we are able to place group of x characters side by side
we will get string after some integer number of times

for above to be possible we need n%x equals 0
hence x is the repeated substring we are looking for
*/
class RepeatedSubstringPatterKMP {
    public boolean repeatedSubstringPattern(String s) {
        int lpsOfString = computeLPSArray(s)[s.length()-1];
        int tentativePatternLength = s.length()-lpsOfString;
        if(lpsOfString==0) return false;
        return (s.length()%tentativePatternLength==0);
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
