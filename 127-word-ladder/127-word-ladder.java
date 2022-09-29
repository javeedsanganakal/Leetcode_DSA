//Approach - 1: BFS
//TTime Complexity:O(M2×N), where MM is the length of each word and NN is the total number of words in the input word list.
//Space Complexity : O(M2×N)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //add all words in the list set
        HashSet<String> set = new HashSet(wordList);
        
        //if list doesn't contain endWord
        if(!set.contains(endWord)) return 0;
        
        //for BFS use Queue
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
            
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0 ; i < size ; i++){
                //poll the word
                String currentWord = queue.poll();
                
                char currArray []= currentWord.toCharArray();
                
                for(int j = 0 ; j < currArray.length ; j++){
                    char originalChar = currArray[j];
                    for(char c = 'a' ; c <= 'z' ; c++){
                        if(currArray[j] == c) continue;
                        currArray[j] = c;
                        String newString = String.valueOf(currArray);
                        //System.out.println(newString);
                        if(newString.equals(endWord)) return level + 1;
                        if(set.contains(newString)){
                            queue.offer(newString);
                            set.remove(newString);
                        }
                    }
                    currArray[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}