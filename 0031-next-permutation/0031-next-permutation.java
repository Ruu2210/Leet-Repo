class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverse(0,n-1,nums);
        }
        else{
            for(int i=n-1;i>index;i--){
            if(nums[i]>nums[index]){
                swap(index,i,nums);
                break;
            }
        }
             reverse(index+1,n-1,nums);
        }

    }

    public void swap(int num1,int num2,int []nums){
        int temp=nums[num1];
        nums[num1]=nums[num2];
        nums[num2]=temp;;
    }
     public void reverse(int start,int end,int []nums){
        while(start<=end){
            swap(start,end,nums);
            start++;
            end--;
        }
    }
}