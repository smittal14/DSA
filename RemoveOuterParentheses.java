/*
*Return String formed after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
*
*Traps:
*1.For finding valid parenthese, you might decide to use stack since that is how you think, BUT you can avoid that using count variable of open parentheses
*2.You might think of using substring to append string, BUT substring itself is an O(n) function
*
*/
class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        
        StringBuilder result = new StringBuilder();
        char OPEN = '(';
        int count = 0;
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==OPEN){
                if(count!=0) result.append(S.charAt(i));
                count++;//increasing count of open parentheses
            }
            else{
                count--;//decrease count of open parenthese
                if(count!=0) result.append(S.charAt(i));
            }
        }
        return result.toString();
    }
}
