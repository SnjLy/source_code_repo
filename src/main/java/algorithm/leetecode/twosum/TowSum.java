package algorithm.leetecode.twosum;

/**
 * @Package: algorithm.leetecode.twosum
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 19/03/2019.
 */
public class TowSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        twoSum(nums, target);
        nums = new int[]{2, 7, 11, 15};
        target = 9;
        twoSum(nums, target);
        nums = new int[]{-1,-2,-3,-4,-5};
        target = -8;
        twoSum(nums, target);
    }


    public static int[] twoSum(int[] nums, int target) {
        //Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (tmp == nums[j]) {
                    System.out.println(i + "& " + j);
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
