
//Mlogn
class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (n2 > n1) return intersect(nums2, nums1);

        List < Integer > result = new ArrayList <> ();

        int low = 0;
        
        for (int i = 0; i < n1; i++) {

            int high = n2 - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;
                 
                
                if (nums2[mid] == nums1[i]) {


                    if (low < mid && nums2[mid] == nums2[mid - 1]) {
                        high = mid - 1;
                    } else {
                        result.add(nums2[mid]);
                        low = mid + 1;
                        break;
                    }
                } else if (nums2[mid] > nums1[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } // while

        } //for


        System.out.println(result);
        int[] arrayResult = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            arrayResult[k] = result.get(k);
        }
        return arrayResult;

    }
}