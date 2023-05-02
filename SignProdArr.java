public class SignProdArr{
    // Sign of product of array
    public static int arraySign(int[] nums) {
        var sign = 1;

        for (var n : nums) {
        if (n == 0) 
            return 0;
            // using ternary operator
            sign *= n > 0 ? 1 : -1;
        }
        return sign;
    }
    public static void main(String args[]){
        int nums[] = {-1,-2,-3,-4,3,2,1};
        System.out.println(arraySign(nums));
    }
}

/* There is a function signFunc(x) that returns:

1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).

Time complexity: O(n)
Space complexity: O(1)
 
*/