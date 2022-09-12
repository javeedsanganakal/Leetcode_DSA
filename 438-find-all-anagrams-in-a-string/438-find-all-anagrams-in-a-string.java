class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
 
        if(p.length() > s.length()) return result;
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        
        
        for(int i=0; i<p.length(); i++){
            char charP = p.charAt(i);
            char charS = s.charAt(i);
            pMap.put(charP, pMap.getOrDefault(charP, 0) +1);
            sMap.put(charS, sMap.getOrDefault(charS, 0) +1);
        }
        

        if(pMap.equals(sMap)) {
            
            result.add(0); // found at 0 index if both maps are equal
        } 
            
        int slow = 0;
        //Fast = j
        for(int j = p.length(); j < s.length(); j++){
            
            char fastChar = s.charAt(j);

            
            if(!sMap.containsKey(fastChar) ){
                sMap.put(fastChar, sMap.getOrDefault(fastChar, 0) +1);
            }
            else{
                sMap.put(fastChar, sMap.get(fastChar) +1);
            }
            
            
            char slowChar = s.charAt(slow);
            sMap.put(slowChar, sMap.get(slowChar) -1);
            
            if(sMap.get(slowChar) == 0){
                sMap.remove(slowChar);
            }
            
            slow++;
            
           
            System.out.println(sMap);
            if(pMap.equals(sMap)) result.add(slow);
            
        }
        return result;
    }
}