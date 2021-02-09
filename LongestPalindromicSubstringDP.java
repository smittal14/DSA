class LongestPalindromicSubstringDP {
    
    public String longestPalindrome(String s) {
        
        int len = s.length();
        int[][] table = new int[len][len];
        int maxLength = 1;
        int start = 0;
        
        //fill the table for length 1
        for(int i=0;i<len;i++){
            table[i][i] = 1;
        }
        
        //fill the table for length 2
        for(int i=0;i<len-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                table[i][i+1]=1;
                if(2>maxLength){
                    maxLength=2;
                    start=i;
                }
            }
        }
        
        //fill the tables for length >2
        //keep track of the maxLength of the table
        //also keep track of the start index of palindrome
        for(int l=3;l<=len;l++){
            for(int st=0;st<=len-l;st++){
                //start of string = st
                //end of string = st+l-1
                if(s.charAt(st)==s.charAt(st+l-1) 
                   && table[st+1][st+l-2]==1){
                    table[st][st+l-1]=1;
                    if(l>maxLength){
                        maxLength = l;
                        start = st;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
     }
}
