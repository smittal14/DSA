class LongestPalindromicSubstringUsingMidIndex {
    
    public String longestPalindrome(String s) {
        
        //assume a number to be mid of palindrome
        //extend it till it ceases to be a palindrome
        //or reaches the boundary limit
        //the trick here is to do handle differently for odd and even lengths
        int maxLengthOfPalindrome = 1;
        int startIndex = 0;
        int lengthOfPalindrome = 1;
        String max = Character.toString(s.charAt(0));

        for(int i=0;i<s.length();i++){
            int lenOdd = extendPalindrome(s,i,i);
            int lenEven = extendPalindrome(s,i,i+1);
            if(maxLengthOfPalindrome<Math.max(lenOdd,lenEven)){
                if(lenOdd>lenEven){
                    maxLengthOfPalindrome = lenOdd;
                    //start = (2*i-lenOdd+1)/2
                    //end = (2*i+lenOdd-1)/2
                    max = s.substring((2*i-lenOdd+1)/2,((2*i+lenOdd-1)/2)+1);
                }
                else{
                    maxLengthOfPalindrome = lenEven;
                    max = s.substring((2*i-lenEven+2)/2,(2*i+lenEven+2)/2);  
                }                
            }            
        }
        return max;
     }
    
    private int extendPalindrome(String s, int i, int j){
        int lengthOfPalindrome = 0;
        while((i>=0 && j<s.length()) &&(s.charAt(i)==s.charAt(j)) ){
            i--;
            j++;
        }
        lengthOfPalindrome = j-i-1;
        return lengthOfPalindrome;
    }
}
