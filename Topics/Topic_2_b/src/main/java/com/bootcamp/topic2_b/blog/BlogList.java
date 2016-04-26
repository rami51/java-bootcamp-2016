package com.bootcamp.topic2_b.blog;

import java.util.Iterator;

public class BlogList implements Iterable<Entry> {

	public static final int ARRAY_FIRST_SIZE = 10;
	private final int ARRAY_SLOTS_ADD_NUMBER = 6;
	
	private Entry[] array;
	private int nextIndex;
	
	public BlogList(){
		array = new Entry[ARRAY_FIRST_SIZE];
		nextIndex=0;
	}
	public void post(Entry entry){
		if(this.isFull())
			expandLenght();
		array[nextIndex]=entry;
		nextIndex++;
	}
	private void expandLenght() {
		Entry [] newArray = new Entry[array.length + ARRAY_SLOTS_ADD_NUMBER];
		for (int i = 0; i < array.length; i++) {
			newArray[i]=array[i];
		}
		array = newArray;		
	}
	public void delete(int idEntry){
		for (int i = 0; i < nextIndex; i++) {
			if(array[i].getId()==idEntry){
				for (int j = Integer.valueOf(i); j < nextIndex; j++) {
					array[j]=array[j+1];
				}
				nextIndex--;
				array[nextIndex]=null;
				break;
			}
		}
	}
	public Entry get(int index){
		return array[index];
	}
	public BlogList getFirstTen(){
		BlogList firstTen = new BlogList();
		for (int i = 0; i < 10; i++) {
			firstTen.post(array[i]);
		}
		return firstTen;
	}
	private boolean isFull(){  		
		return (array.length == nextIndex);
	}
	public int size(){
		return nextIndex;
	}
	public Iterator<Entry> iterator() {
		Iterator<Entry> it = new MyEntryIterator();
		return it;
	}
	public Entry getLast() {
		return array[nextIndex-1];
	}
	
	public class MyEntryIterator implements Iterator<Entry> {
		private int currentEntryIndex;
		protected MyEntryIterator(){
			currentEntryIndex = 0;
		}		
		public boolean hasNext() {
			return (currentEntryIndex < array.length);
		}

		public Entry next() {
			currentEntryIndex++;
			return array[currentEntryIndex-1];
		}

	}
}
