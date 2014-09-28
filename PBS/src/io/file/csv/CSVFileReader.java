package io.file.csv;

import io.file.AbstractFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;



public class CSVFileReader extends AbstractFileReader {

	private CSVReader reader;
	
	public CSVFileReader(File file) {
		super(file);
	}

	@Override
	public void open() throws FileNotFoundException {
		this.reader = new CSVReader(new FileReader(this.getFile()));
	}

	@Override
	public void close() throws IOException {
		this.reader.close();
	}

	@Override
	public String[] next() throws IOException {
		return this.reader.readNext();
	}
}
