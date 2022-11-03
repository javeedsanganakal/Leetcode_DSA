/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//Approach - 2: Linear
//Time Complexity : O(n^2)
//Space Complexity : O(1)
public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int celeb = 0;
        
        for(int i=1; i<n; i++){
            //celeb knows i th person, then i is the celeb
            if(knows(celeb,i)){
                celeb = i;
            }
        }

        //Potential celeb
        for(int i=0; i<n; i++) {
               if(celeb != i){
                   //celeb knows i th person or 
                   // i th person dont know the celeb
                   if(knows(celeb, i) || !knows(i, celeb)) return -1;
               }
        }
        return celeb;
    }
}