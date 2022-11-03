/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//Approach - 1: indegrees
//Time Complexity : O(n^2)
//Space Complexity : O(n)
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int [] indegrees = new int[n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                //if A knows B
                //B is Celeb
                if(i!=j){
                    if(knows(i,j)){
                        indegrees[i]--;
                        indegrees[j]++;   
                    }
                }
            }
        }
        
        System.out.println(indegrees);
        for(int i=0; i<n; i++) {
               if(indegrees[i] == n-1){
                   return i;
               }
        }
        
        return -1;
    }
}