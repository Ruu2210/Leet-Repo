/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findpeak(mountainArr);
        int firstTry = orderAgnosticBinarySearch(mountainArr, target, 0, peak);
        if (firstTry != -1) {
            // if we find out target at first half which is in ascending order part, return
            // index and their is no need to find at second half
            return firstTry;
        }

        return orderAgnosticBinarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1);

    }

    public int findpeak(MountainArray mountainArr) {
        // 1,2,3,4,6,8,2,3,5
        // here 8 is the peak index
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // you are in acsending part of the array
                // bcoz we know mid+1>mid ,we ignore mid and make start=mid+1
                start = mid + 1;
            } else {
                // here mid>mid+1,so we are in descending part of array
                // maybe mid is the answer,but look at the left
                // thats why here end!=mid-1;
                end = mid;
            }
        }
        // in the end start==end,both pointing to the largest element of array bcoz of
        // above 2 checks
        // at every point start and end have best possible answer
        // but if only one item is left at that time only we can say this is the answer
        return start; // or return end; bcoz start==end
    }

    public int orderAgnosticBinarySearch(MountainArray mountainArr, int target, int start, int end) {
        boolean isAscending = mountainArr.get(start) < mountainArr.get(end);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (isAscending) {
                // if we are in ascending part
                if (target < mountainArr.get(mid))
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                // if we are in descending part
                if (target > mountainArr.get(mid))
                    end = mid - 1;
                else
                    start = mid + 1;
            }

        }
        return -1; // if no element found
    }

}
