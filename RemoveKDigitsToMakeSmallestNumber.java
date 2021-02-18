/*
https://leetcode.com/problems/remove-k-digits/

imagine the situation as a line plot (graph)

if the next number is on a decreasing slope & we can still remove elements
    this means previous num was more
    deleting previous will delete bigger number
    bring smaller number into its place
    resultant number will be smaller
    thus delete the previous number than current

else move to the next number

in the end if there is digits left for removal, keep on deleting chars

do not forget to:
    remove leading 0
    return 0 in case of empty string
*/

class RemoveKDigitsToMakeSmallestNumber {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        
        //keep on decreasing digits till we have decreasing slope
        int i = 0;
        while(i<sb.length() && k>0){
            if(checkIsCurrentOnDecreasingSlope(sb,i)){
                sb.deleteCharAt(i-1);
                k--;
                i--;
            }
            else{
                i++;
            }
        }
        
        //handling case where we have increasing slopes towards the end
        //and digits left for removal
        while(k-->0) sb.deleteCharAt(--i);
        
        //Sanitising the output and returing
        while(sb.length()!=0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        if(sb.length()==0) return "0";
        return sb.toString();
    }

    private boolean checkIsCurrentOnDecreasingSlope(StringBuilder sb, int index){
        if(index==0) return false;
        int curr = sb.charAt(index) - '0';
        int prev = sb.charAt(index-1) -'0';
        if(curr<prev) return true;
        return false;
    }
}
