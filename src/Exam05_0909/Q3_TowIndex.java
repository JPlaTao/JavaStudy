package Exam05_0909;

public class Q3_TowIndex {
    public static void main(String[] args) {
//        //测试用例 1
//        int[] nums = {1,2,3,1};
//        int k = 3;

        //测试用例 2
//        int[] nums = {1, 0, 1, 1};
//        int k = 1;

        //测试用例 3
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;


        System.out.println(abs(nums, k));
    }

    public static boolean abs(int[] nums, int k) {
//        int i = 0;
//        int j = nums.length - 1;
//        while (i <= j) {
//            if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
//                return true;
//            }
//            i++;
//            j--;
//        }

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (i != j && nums[i] == nums[j] && Math.abs(i - j) <= k) {
//                    return true;
//                }
//            }
//        }
//        return false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] &&
                        (Math.abs(i - j) <= k | Math.abs(j - i) <= k)) {
                    return true;
                }
            }
        }
        return false;
    }
}
