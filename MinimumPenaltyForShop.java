/* You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
   if the ith character is 'Y', it means that customers come at the ith hour
    whereas 'N' indicates that no customers come at the ith hour.
    If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:

    For every hour when the shop is open and no customers come, the penalty increases by 1.
    For every hour when the shop is closed and customers come, the penalty increases by 1.
    Return the earliest hour at which the shop must be closed to incur a minimum penalty.

    Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
*/


// Time complexity - O(n)
// Space complexity - O(1)
import java.util.*;
public class MinimumPenaltyForShop{
    public static int bestClosingTime(String customers){
        int score = 0, max_score = 0, best_hour = -1;
        for(int i=0; i<customers.length(); i++){
            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            if(score > max_score){
                max_score = score;
                best_hour = i;
            }
        }
        return best_hour + 1;
    }


    // Time complexity - O(N)
    // Space complexity - O(N)
    // Prefix suffix
    public static int bestClosingTimeIntuitive(String customers){
        List<Integer> suffixY = new ArrayList<>();
        List<Integer> prefixN = new ArrayList<>();
        int n = customers.length();
        int cntY = 0, cntN = 0;

        prefixN.add(0);
        for(char c : customers.toCharArray()){
            cntN += (c == 'N') ? 1 : 0;
            prefixN.add(cntN);
        }

        suffixY.add(0);
        for(int i = n-1; i>=0; i--){
            char c = customers.charAt(i);
            cntY += (c == 'Y') ? 1 : 0;
            suffixY.add(cntY);
        }
        Collections.reverse(suffixY);

        int besthour = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<=n ; i++){
            int sum = prefixN.get(i) + suffixY.get(i);
            if(sum < minSum){
                minSum = sum;
                besthour = i;
            }
        }
        return besthour;
    }
}

/* Input: customers = "YYNY"
Output: 2
Explanation: 
- Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
- Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
- Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
- Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
- Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
  Closing the shop at 2nd or 4th hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.
 
 */