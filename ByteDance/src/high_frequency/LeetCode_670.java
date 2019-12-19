package high_frequency;

public class LeetCode_670 {
    static class Solution {
        public int maximumSwap(int num) {
            // 贪心算法，相当有难度，不过这是你要拿offer必须优化
            // 首先，将num 转换成数组，这样才可以操作swap
            // 这里贪心思想的体现就是；我们将数组的每个下标，使用一个map[].用来映射数字的下标。map[i] = index. 这里i就是0 - 9个数字，index就是他在num中的下标。
            // 这样我们遍历数组num, 从第一个位置开始，只要，可以找到也出现在数组中的数字d(要求数字d要比当前这个下标出现的数字大。d > nums[i] - '0'),那么比较d出现的下标要大于当前下标。last[d] > i.换句话说，就是找到一个数字，他也是在这个数组中的而且他出现的位置比当前这个比他小的数字出现在后面。所以要交换位置。
            // 贪心算法，相当有难度，不过这是你要拿offer必须优化
            // 首先，将num 转换成数组，这样才可以操作swap
            // 这里贪心思想的体现就是；我们将数组的每个下标，使用一个map[].用来映射数字的下标。map[i] = index. 这里i就是0 - 9个数字，index就是他在num中的下标。
            // 这样我们遍历数组num, 从第一个位置开始，只要，可以找到也出现在数组中的数字d(要求数字d要比当前这个下标出现的数字大。d > nums[i] - '0'),那么比较d出现的下标要大于当前下标。last[d] > i.换句话说，就是找到一个数字，他也是在这个数组中的而且他出现的位置比当前这个比他小的数字出现在后面。所以要交换位置。
            //     char[] charNums = String.valueOf(num).toCharArray();
            //     // Comparator<cahr> cmp = new Comparator<Integer>(){
            //     //     @Override
            //     //     public int compare(Integer a, Integer b) {
            //     //         return b - a;
            //     //     }
            //     // };
            //     Arrays.sort(charNums);
            //     // for (int i = 0; i < charNums.length / 2; i++) {
            //     //     swap(charNums, i, charNums.length - 1 - i);
            //     // }
            //     return Integer.parseInt(new String(charNums));
            // }
            char[] charNums = String.valueOf(num).toCharArray();
            int[] indexMap = new int[10];
            for (int i = 0; i < charNums.length; i++) {
                indexMap[charNums[i] - '0'] = i;
            }
            for (int i = 0; i < charNums.length; i++) {
                // this loop is very trick. because the main function of the method is to find the next index which represent bigger digit to the current one. we use extra map which could help us to record the last appearance of each digit[0 - 9] in array charNums. So once we could find the biggest digit in the relatively last index. It is the best result.i.e. [2, 7 , 3, 6 ,7] -> indexMap[,,0,2,,,3,4,0,0] By here. we could know the idea behind the charNums. index 1 of 7 is replaced by the index 4 of 7. Because it could construct the big number.
                for (int lastIndex = 9; lastIndex > charNums[i] - '0'; lastIndex--) {
                    if (indexMap[lastIndex] > i) {
                        swap(charNums, indexMap[lastIndex], i);
                        return Integer.parseInt(new String(charNums));
                    }
                }
            }
            return num;
        }
        public void swap(char[] nums, int i, int j) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
//            char[] nums = String.valueOf(num).toCharArray();
//            int[] last = new int[10];
//            for (int i = 0; i < nums.length; i++) {
//                last[nums[i] - '0'] = i;
//            }
//
//            for (int i = 0; i < nums.length; i++) {
//                for (int d = 9; d > nums[i] - '0'; d--) {
//                    if (last[d] > i) {
//                        char temp = nums[i];
//                        nums[i] = nums[last[d]];
//                        nums[last[d]] = temp;
//                        return Integer.valueOf(new String(nums));
//                    }
//                }
//            }
//            return num;
//        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maximumSwap(2736));
//        System.out.println(solution.maximumSwap(9936));
        System.out.println(solution.maximumSwap(21));
    }
}
