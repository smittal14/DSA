/*
*Question :
*A string S of lowercase English letters is given.
*We want to partition this string into as many parts as possible so that each letter appears in at most one part,
*and return a list of integers representing the size of these parts.

*Ideation :
*we can think in terms of finding the last index of every character
*and then work with whatsoever index ends last
*new partition starts when start index of current character is more/equal to
*end index of any character encountered so far in current partition
*
*Data structure :
*we can either use hashmap for recording start and end indices
*but the problem is, we won't be able to retain insertion order in the keys
*(if we do not use linkedhashmap)
*hence for sequential access we need array
*but how to define dynamic array
*solution is to use arraylist : not good for key value pair and O(1) search for key*
*or create an array of size 26 since it is the max number of alphabets - O(1) space solution
/*

class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        
        int[] endIndices = new int[26];
        
        //finding alphabet number : charC - 'a' is the alphabet number
        for(int i=0;i<S.length();i++){
            endIndices[S.charAt(i)-'a'] = i;
        }
        
        int partitionBeginIndex = 0;
        int tentativeParitionEndIndex = 0;
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<S.length();i++){   
            tentativeParitionEndIndex = Math.max(tentativeParitionEndIndex,endIndices[S.charAt(i)-'a']); 
            if(i==tentativeParitionEndIndex){
                result.add(i-partitionBeginIndex+1);
                partitionBeginIndex = i+1;
            }
        }
        
        return result;
    }
}
