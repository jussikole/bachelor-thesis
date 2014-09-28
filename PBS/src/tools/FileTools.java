package tools;

import java.io.File;


public class FileTools {
	public static String getExtension(File file) {
		return FileTools.getExtension(file.getPath());
	}
	
	public static String getExtension(String path) {
		return path.substring(path.lastIndexOf(".") + 1);
	}
	
	public static File combine(File base, String...path) {
		File current = base;
		for (String folder : path) {
			current = new File(current, folder);
		}
		return current;
	}
	
	public static String addExtension(String filename, String extension) {
		return filename + "." + extension;
	}
	
	public static String removeExtension(File file) {
		String name = file.getName();
		return name.substring(0, name.lastIndexOf('.'));
	}
	
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\kolehju\\workspace\\PBS\\resources\\England\\Premier_league\\2010.csv");
		System.out.println(removeExtension(file));
	}
	
	
}
