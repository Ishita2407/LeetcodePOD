/* A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. 
The frog can jump on a stone, but it must not jump into the water.
Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last
stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward 
direction.

Example 1:
Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
*/

import java.util.*;
public class FrogJump{
    // Hashmap to store the stone positions and their indices
    HashMap<Integer, Integer> map = new HashMap<>();
    int dp[][];

    // i -> current index , k -> jump size , stones[] -> contains stone positions
    boolean solve(int i, int k, int stones[]){
        if(i == stones.length) return true;

        // if the result of the current state(i,k) is already calculated return 1
        if(dp[i][k] != -1) return dp[i][k] == 1;

        boolean k0 = false, km1 = false, kp1 = false;
        if(map.containsKey(stones[i] + k)){
            k0 = solve(map.get(stones[i] + k), k, stones);
        }

        if(k > 0 && map.containsKey(stones[i] + k - 1)){
            km1 = solve(map.get(stones[i] + k -1), k-1, stones);
        }

        if(map.containsKey(stones[i] + k + 1)){
            kp1 = solve(map.get(stones[i] + k +1), k+1, stones);
        }

        dp[i][k] = (k0 || kp1 || km1) ? 1 : 0;
        return dp[i][k] == 1;
    }

    public boolean canCross(int stones[]){
        if(stones[1] - stones[0] != 1){
            return false;
        }

        for(int i=0; i<stones.length; i++){
            map.put(stones[i], i);
        }

        dp = new int[stones.length][stones.length];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return solve(1,1,stones);
    }
}