package tools;

import java.util.Arrays;
import java.util.HashSet;

public class StringTools {
	public static String combine(char delimiter, String...words) {
		String result = words[0].toString();
		for (int i=1; i<words.length; i++) {
			result += delimiter + words[i].toString();
		}
		return result;
	}
	
	public static String combine(char delimiter, String[]...words) {
		int total = 0;
		for (String[] w : words) {
			total += w.length;
		}
		String[] result = new String[total];
		int pos = 0;
		for (int i=0; i<words.length; i++) {
			for (int j=0; j<words[i].length; j++) {
				result[pos++] = words[i][j];
			}
		}
		return combine(delimiter, result);
	}
	
	public static boolean contains(String[] array, String key) {
		return new HashSet<String>(Arrays.asList(array)).contains(key);
	}
	
	public static void main(String[] args) {
		System.out.println(combine('/', new String[]{"nlle", "puh"}, new String[]{"asd", "das"}));
	}
}
