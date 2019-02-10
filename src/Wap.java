import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Wap {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 3 };
		int[] B = { 2, 3, 3, 4 };
		int[] C = { 1, 2, 2, 2 };
		int target = 7;
		Set<int[]> result = new HashSet<>();
		Arrays.stream(A).forEach(a -> {
			Arrays.stream(B).forEach(b -> {
				Arrays.stream(C).forEach(c -> {
					if (a <= target && b <= target && c <= target && a + b + c == target) {
						int[] temp = { a, b, c };
						result.add(temp);
					}
				});
			});
		});
		result.stream().map(el -> Arrays.toString(el)).forEach(System.out::println);
	}

}
