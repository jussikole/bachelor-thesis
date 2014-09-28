package io.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import tools.FileTools;

public abstract class AbstractFileReader {
	private File file;
	
	public AbstractFileReader(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public abstract void open() throws FileNotFoundException;
	public abstract void close() throws IOException;
	public abstract String[] next() throws IOException;
	
	public static AbstractFileReader getReader(File file) {
		String extension = FileTools.getExtension(file);
		if (extension.equals("csv")) {
			//return new CSVFileReader(file);
		}
		return null;
	}
}
