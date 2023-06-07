class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
       // if(flowerbed.length<n) return false;
        int count=0;
        
        for(int i=0;i<flowerbed.length;i++){
            
            //check current and neighbouring positions are empty or not
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1|| flowerbed[i+1]==0)){
                flowerbed[i]=1; //important to make it 1 so that we can check for next condition
                count++;
            }
        }
        
               if(count>=n) return true;
              
        return false;

        }
    }
