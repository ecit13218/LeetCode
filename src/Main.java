import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(arrayBubble(nums)));

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0, j = nums.length; i < j; i = i + 2) {
            count += nums[i];
        }
        return count;
    }
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }


    public static int[] arrayBubble(int[] nums) {
        int ex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1-i; j++) {
                if (nums[j] > nums[j + 1]) {
                    ex = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = ex;
                }
            }
        }
        return nums;
    }

}
