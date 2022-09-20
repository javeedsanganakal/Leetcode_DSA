//Approach - 1: Linear and Sort
//Time Complexity : O(nlogn)
//Space Complexity : O(1)



//notes
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        //Sort if its not sorted
        Arrays.sort(citations);
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