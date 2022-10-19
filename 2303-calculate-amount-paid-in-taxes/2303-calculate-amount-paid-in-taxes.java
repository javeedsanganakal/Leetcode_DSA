//Approach - 1: 
//Time Complexity : o(1)
//Space Complexity : O(1)

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int i = 0;
        double tax = 0;
        int prev = 0;
        
        while(income > 0){
            int [] bracket = brackets[i];
            
            int curr = bracket[0];
            int per = bracket[1];
            
            if(i == brackets.length-1){
                tax = tax + income * (per/100.0);
                return tax;
            }
            
            int taxable = Math.min(curr-prev, income);
            tax = tax + taxable * (per/100.0);
            prev = curr;
            income = income - taxable;
            i++;
        }
        return tax;
    }
}