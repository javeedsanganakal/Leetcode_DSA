//Approach - 1: Linear
//Time Complexity : O(n)
//Space Complexity : O(1)


//Notes

class Solution {
    public int hIndex(int[] citations) {
         if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        for(int i=0; i<n; i++){
            int diff = n-i;
            if(diff<=citations[i]){
                return diff;
            }
        }
        //[0,0,0,0] == [4,3,2,1] no diff<=citations[i] will match
        return 0;
    }
}
