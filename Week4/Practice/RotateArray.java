public class RotateArray {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        System.out.print("Rotated Array: ");

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}