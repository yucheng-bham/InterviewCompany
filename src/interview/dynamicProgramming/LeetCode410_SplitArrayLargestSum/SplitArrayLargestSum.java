package interview.dynamicProgramming.LeetCode410_SplitArrayLargestSum;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/3 20:09
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {7,2,5,10,8};
        int[] arr = {1,2,3,4,5};
        int splitArray = solution.splitArray(arr, 3);
        System.out.println(splitArray);
    }
}
//
//
//// 二分法：速度比较快，而且开拓思路
//
//class Solution {
//    /**
//     *  这个数肯定介于最大的那一个单值和所有元素只和的中间
//     * */
//    public int splitArray(int[] nums, int m) {
//        long sum = 0;
//        int max = 0;
//        for(int num: nums){
//            max = Math.max(max, num);
//            sum += num;
//        }
//        return (int)binarySearch(nums, m, sum, max);
//    }
//    //二分查找
//    private long binarySearch(int[] nums, int m, long high, long low){
//        long mid = 0;
//        while(low < high){
//            mid = (high + low)/2;
//            //验证是否满足,也就是这么大的值不有可能出现
//            if(valid(nums, m, mid)){
//                high = mid;
//            }else{
//                low = mid + 1;
//            }
//        }
//        return high;
//    }
//
//    *//**
//            * 验证这个值是否合法
//     * *//*
//    private boolean valid(int[] nums, int m, long max){
//        int cur = 0;
//        int count = 1;
//        //是否有多于m个片段or区间，大于给定值的max的，如果有了，那么就不合法了，因为这样划分就不止m个，即max太小
//        for(int num: nums){
//            cur += num;
//            if(cur > max){
//                cur = num;
//                count++;
//                if(count > m){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}

// dp : 比较慢
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}
