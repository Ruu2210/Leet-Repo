​
​
char ch=letters[0];
​
for(int i=0;i<letters.size();i++){
if(letters[i]>target)return letters[i];
}
return ch;
b)
class Solution {
public char nextGreatestLetter(char[] letters, char target) {
int start=0;
int end= letters.length-1;
while(start<end){
int mid = start+(end-start)/2;
if(target>letters[mid]) start=mid+1;
else if(target<letters[mid]) end=mid-1;
}
return letters[start%letters.length];
//if while condition voilated :- start => end+1 => start==Length of array N we can return S%N;
}
}