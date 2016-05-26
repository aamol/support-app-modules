/**
 * 
 */
package com.sapient.transformer.csvtojson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.integration.annotation.Transformer;

/**
 * @author aamol
 *
 */
public class CsvToJsonTransformer {

	String fieldNames;

	public CsvToJsonTransformer(String fieldNames) {
		this.fieldNames = fieldNames;
	}

	@Transformer
	public Object transform(String payload) {

		List<String> fields = Arrays.asList(fieldNames.split(","));

		Scanner scanner = new Scanner(payload);
		scanner.useDelimiter(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String fieldName : fields) {
			map.put(fieldName, scanner.next());
		}
		scanner.close();
		return map;

	}

}
