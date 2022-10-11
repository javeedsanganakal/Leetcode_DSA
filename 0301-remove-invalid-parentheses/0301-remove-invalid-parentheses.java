//Approach - 1: BSF, Set
//Time Complexity : 
//Space Complexity : 

//Notes
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length()  == 0) return result;
        
        boolean flag = false;
        
        Queue<String> q = new LinkedList<>();
        q.add(s);
        
        HashSet<String>  set = new HashSet<>();
        set.add(s);
        
        while(!q.isEmpty()){
            
            //g=Going through all strings in that level 
            int size = q.size();
            
            for(int i=0; i<size; i++){
                String curr = q.poll();
                
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }
                else{
                    if(!flag){
                        for(int j=0; j<curr.length(); j++){
                            //remove one brace and add it to set
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String child = curr.substring(0,j) + curr.substring(j+1);
                            if(!set.contains(child)){
                                q.add(child);
                                set.add(child);
                            }
                        }
                    }
                }
                
            }
            
        }
        return result;
    }
    
    private boolean isValid(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}