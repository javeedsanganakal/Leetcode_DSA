//Approach - 1: DFS, Set, max
//Time Complexity : 
//Space Complexity : 

//Notes
class Solution {
    List<String> result;
    Set<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        set = new HashSet<>();
        if(s == null || s.length()  == 0) return result;
        max = 0;
        
        dfs(s);
        return result;
    }
    
    private void dfs(String str){
        //base 
        if(str.length() < max) return;
        if(isValid(str)){
            if(str.length() > max){
                result = new ArrayList<>();
                max = str.length();
            }
            result.add(str);
            return;
        }
        //logic
        
        //add
        if(isValid(str)){
            result.add(str);
        }
        set.add(str);

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isLetter(c)) continue;
            String child = str.substring(0,i) + str.substring(i+1);
            if(!set.contains(child)){
                set.add(child);
                dfs(child);
            }
        }
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