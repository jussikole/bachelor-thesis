package item.set;

import io.file.AbstractFileReader;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import sport.item.Item;


public interface ItemSet<T extends Item> extends Iterable<T>  {
	public void add(T item);
	public Iterator<T> iterator();
	public T get(int id);
	public void save();
}
