class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->a-b );
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        
        q.add(intervals[0][1]);
        
  
            for(int i=1; i<intervals.length; i++){  
                //endtime
                int peekEle = q.peek();
                //end > start
                if(peekEle > intervals[i][0]){
                    q.add(intervals[i][1]);
                }
                else{
                    q.poll();
                    q.add(intervals[i][1]);
                }
            }

        return q.size();
        
    }
}