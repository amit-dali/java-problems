public class ReverseWords {
	public static void main(String[] args) {
		ReverseWords r = new ReverseWords();
		System.out.println(r.reverseWords("   a   b "));
	}

	public String reverseWords(String s) {
		String[] words = s.trim().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			String word = words[i].trim();
			if (!word.isBlank() && !word.isEmpty()) {
				sb.append(words[i].trim());
				if (i != 0) {
					sb.append(" ");
				}
			}
		}
		return sb.toString().trim();
	}

}
