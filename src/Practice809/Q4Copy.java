package Practice809;

public class Q4Copy {
    public static void main(String[] args) {
        int[] nums = {2,11,33,44,55,66,277};

        int[] newNums = new int[nums.length-1];


//        //(1)
//        for (int i = 0,j= 0; j < nums.length; i++,j++) {
//            if (nums[i] == 33){
//                newNums[i] = nums[++j];
//            }else newNums[i] = nums[j];
//        }


        System.arraycopy(nums,0,newNums,0,2);
        System.arraycopy(nums,3,newNums,2,4);


        for (int i : newNums) {
            System.out.print(i + " ");
        }
    }
}
