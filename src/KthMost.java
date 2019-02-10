import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KthMost {
	public static void main(String[] args) {
		Integer[] num = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5 };
		int k = 1;
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int n : num) {
			countMap.compute(n, (key, val) -> countMap.containsKey(key) ? val + 1 : 1);
		}
		Map<Integer, Integer> resMap = countMap.entrySet().stream()
				.sorted((key1, key2) -> key2.getValue().compareTo(key1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		int index = 1;
		System.out.println(resMap);
		for(Map.Entry<Integer,Integer> entry : resMap.entrySet()) {
			if (index == k) {
				System.out.println(entry.getKey());
				return;
			}
			index++;
		}
	}

}
