if(n==0) return true;
int count=0;
for(int i=0;i<flowerbed.length;i++){
// Check if the current position is empty and its neighboring positions are also empty
if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) &&  (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
flowerbed[i] = 1; // plant a flower at this position
count++; // increment the count of planted flowers
}
if (count >= n) {
return true;
}
}
return false;