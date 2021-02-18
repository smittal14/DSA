/*
https://leetcode.com/problems/sort-colors/

Using : Dutch National Flag Algorithm OR 3-way Partitioning
*/
class SortColors {
    public void sortColors(int[] nums) {
        
        int zeroIndex = 0;
        int twoIndex = nums.length-1;
        int currentIndex = 0;
        
        while(currentIndex<=twoIndex){
            
            if(nums[currentIndex]==0){
                swapIndexes(nums,currentIndex,zeroIndex);
                zeroIndex++;
                currentIndex++;
            }
            else if(nums[currentIndex]==2){
                swapIndexes(nums,currentIndex,twoIndex);
                twoIndex--;
            }            
            else if(nums[currentIndex]==1)
                currentIndex++;
            
        }
    }
    
    private void swapIndexes(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        return;
    }
}
