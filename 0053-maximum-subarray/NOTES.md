//here we use kadanes algorithm
int current_sum=0;
int max_sum = nums[0];
for(int i=0;i<nums.length;i++){
current_sum += nums[i];
if(current_sum>max_sum) max_sum=current_sum;
if(current_sum<0) current_sum=0;
}
return max_sum;