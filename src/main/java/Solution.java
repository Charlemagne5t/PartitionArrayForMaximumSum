public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[][] memo = new Integer[arr.length + 1][k + 1];
        return dfs(arr, k, 0, 0, 0, memo);
    }
    private int  dfs(int[] arr, int k, int i, int curLength, int curMax, Integer[][] memo){
        if(i == arr.length){
            return curLength * curMax;
        }
        if(memo[i][curLength] != null){
            return memo[i][curLength];
        }
        int result = 0;
        int take = 0;
        int startNew = 0;
        if(curLength < k){
            take = dfs(arr, k, i + 1, curLength + 1, Math.max(curMax, arr[i]), memo);
        }

        startNew = curMax * curLength + dfs(arr, k, i + 1, 1, arr[i], memo);
        result =  Math.max(take, startNew);
        memo[i][curLength] = result;
        return result;
    }
}
