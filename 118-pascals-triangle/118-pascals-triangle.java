class Solution {

    public List<List<Integer>> generate(int numRows) {

        
        //Result list[[]]
        List<List<Integer>> result = new ArrayList<>();

        //Base case
        if (numRows == 0) {

            return result;

        }
        //List []
        List<Integer> n = new ArrayList<Integer>();
        n.add(1);
        result.add(n);
        
        for(int i = 1; i<numRows; i++)
        {
            ArrayList<Integer> inside = new ArrayList<Integer>();
            inside.add(1);
            for(int j = 1;j<i;j++)
            {
                inside.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }   
            inside.add(1);
            result.add(inside);
        }
        return result;
    }

}