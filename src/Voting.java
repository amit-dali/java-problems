package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Voting {
	public static void main(String[] args) {
		Map<Long, Long> resultMap = getVotingDetails();
		LinkedHashMap<Long, Long> votingResult = new LinkedHashMap<>();
		for (Map.Entry<Long, Long> entry : resultMap.entrySet()) {
			votingResult.compute(entry.getValue(),
					(key, val) -> votingResult.containsKey(entry.getValue()) ? votingResult.get(key) + 1 : 1);
		}
		Map<Object, Object> votingResultSorted = votingResult.entrySet().stream()
				.sorted((key1, key2) -> key2.getValue().compareTo(key1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.print("And the Result is =" + votingResultSorted);
	}

	private static Map<Long, Long> getVotingDetails() {
		Map<Long, Long> resultMap = new HashMap<>();
		List<Long> frdVoterIds = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get("d:\\voting.txt"))) {
			lines.forEach(line -> {
				String[] result = line.split(",");
				if (resultMap.containsKey(Long.valueOf(result[1]))) {
					resultMap.remove(Long.valueOf(result[1]));
					frdVoterIds.add(Long.valueOf(result[1]));
				} else {
					resultMap.put(Long.valueOf(result[1]), Long.valueOf(result[0]));
				}
			});
		} catch (IOException ioe) {
			System.err.print(ioe.getMessage());
		}
		System.out.println("ID's of fraud voters are = " + frdVoterIds);
		return resultMap;
	}
}

/**
 * Contents of voting.txt
1,123
2,444
5,333
7,222
8,000
3,124
9,999
5,111
1,456
2,987
1,678
1,056
3,111
3,234
2,08765
4,43256
3,0654
1,1234565
7,786
9,875
8,786
 * 
 * 
 * 
 * */
