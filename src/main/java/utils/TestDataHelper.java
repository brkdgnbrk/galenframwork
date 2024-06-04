package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class TestDataHelper {

	public static Map<String, String> readTestData(String filename) {
		Map<String, String> testData = new HashMap<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("=");
				testData.put(parts[0], parts[1]);
			}
			reader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}

}
