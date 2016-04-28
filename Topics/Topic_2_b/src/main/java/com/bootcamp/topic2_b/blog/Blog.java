package com.bootcamp.topic2_b.blog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Blog {
	private List<Entry> postsList;
	
	public Blog(ArrayList<Entry> postsList){
		this.postsList = postsList;
	}
	
	public Blog(){
		postsList = new ArrayList<Entry>();
	}
	
	public Entry getEntry(int idEntry){
		for (Entry entry : postsList) {
			if(entry.getId()==idEntry)
				return entry;
		}
		return null;
	}
	
	public void removeEntry(int idEntry){
		for (Entry entry : postsList) {
			if(entry.getId()==idEntry){
				postsList.remove(entry);
				break;
			}
		}
	}
	
	public void addEntry(Entry entry){
		postsList.add(entry);
		this.sortPostsList();
	}
	
	public void updateEntry(Entry entry){ 			
		boolean needToBeSorted = false;				//This works only if the Entry object
		for (Entry iEntry : postsList) {			// of the parameter has the same id
			if(entry.getId()==iEntry.getId()){		// of the object in postsList.
				needToBeSorted = !(entry.getDate().equals(iEntry.getDate()));
				iEntry = entry;
			}
		}
		if(needToBeSorted) 
			this.sortPostsList();
	}
	
	public Blog getRecentPosts(int numberOfPosts){
		if(numberOfPosts>=postsList.size()){
			return this;
		}
		else {
			ArrayList<Entry> recents = new ArrayList<Entry>();
			for (int i = this.size()-1; i > this.size()-numberOfPosts-1; i--) {
				recents.add(postsList.get(i));
			}
			return new Blog(recents);
		}
	}
	private void sortPostsList(){
		Collections.sort(postsList, new Comparator<Entry>(){	//Ordered from oldest to most recent.
			public int compare(Entry e1, Entry e2) {
				return e1.getDate().compareTo(e2.getDate());
			}
		});
	}

	public Entry getMostRecent() {
		return postsList.get(postsList.size()-1);
	}

	public void print() {
		for (Entry entry : postsList) {
			System.out.println(entry.toString());
		}
		
	}

	public int size() {
		return postsList.size();
	}
}
