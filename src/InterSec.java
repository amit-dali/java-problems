import java.util.Arrays;

public class InterSec {

	public static void main(String[] args) {
		String[] words = { "Apple", "Melon", "Orange", "Watermelon" };
		String[] parts = { "a", "mel", "lon", "el", "An" };
		System.out.println(Arrays.toString(findSubstrings(words, parts)));
	}

	private static String[] findSubstrings(String[] words, String[] parts) {
		String[] returnVal = new String[words.length];
		Object[] soartedParts = Arrays.stream(parts).sorted((part1, part2) -> {
			return part2.length() - part1.length();
		}).toArray();
		int index = 0;
		for (String word : words) {
			for (Object part : soartedParts) {
				if (word.contains(part.toString())) {
					returnVal[index] = word.replace(part.toString(), "[" + part.toString() + "]");
					break;
				}
			}
			returnVal[index] = returnVal[index] == null ? word : returnVal[index];
			index++;
		}
		return returnVal;
	}

}
