class Solution {
    public int maxArea(int[] height) {
        
int max =0;
int n = height.length;
        int low = 0;
        int high = n-1;
        while(low < high){
            if(height[low] < height[high]){
                
                //area =h* w
                    //h = min(height[low], height[hight])
                    //w = diff between index => high - low
                max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
                low++;
            }
            else
            {
                max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
                high--;
            }
        }
        return max;
        
    }
}