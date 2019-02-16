import java.util.Arrays;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		MaximumProductSubarray m = new MaximumProductSubarray();
		System.out.println(m.maxProduct(new int[] { 2, 3, -2, 4 }));
	}

	private int getProductOfSubArr(int[] subArr) {
		return Arrays.stream(subArr).parallel().reduce((num1, num2) -> num1 * num2).orElse(0);
	}

	public int maxProduct(int[] nums) {
		int max = 0;
		for (int index = 0; index < nums.length; index++) {
			for (int j = 0; j <= index; j++) {
				int productFromStart = getProductOfSubArr(Arrays.copyOfRange(nums, j, index));
				int productFromEnd = getProductOfSubArr(Arrays.copyOfRange(nums, j, nums.length));
				if (productFromStart > max) {
					max = productFromStart;
				}
				if (productFromEnd > max) {
					max = productFromEnd;
				}
			}
		}
		return max;
	}

}
