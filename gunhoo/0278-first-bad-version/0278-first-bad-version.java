/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Binary Search using while loop
        if(n==1) return 1;
        int start = 1, end = n, mid = 0;
        while(start < end){
            mid = start + (end-start)/2;
            if(isBadVersion(mid)){
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return end;
    }
}