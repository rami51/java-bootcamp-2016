package com.bootcamp.topic2_b.blogTest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.topic2_b.blog.BlogList;
import com.bootcamp.topic2_b.blog.Entry;

public class BlogListTest {
	BlogList entryList;
	@Before
	public void setUp() throws Exception {
		entryList = new BlogList();
		Entry entry1 = new Entry(Date.valueOf("2016-04-25"), "Sun and sand", "Me", "Sun"
				+ " and sand always can be found in the beach.");
		Entry entry2 = new Entry(Date.valueOf("2016-04-23"), "Soccer match", "Me, again...", "A soccer match always is"
				+ " played in a soccer field, which has two goal sides.");
		Entry entry3 = new Entry(Date.valueOf("2016-04-22"), "Study engineering", "Me, once again!", "Study engineering is"
				+ " a really hard task...");
		entryList.post(entry1);
		entryList.post(entry2);
		entryList.post(entry3);		
	}

	@Test
	public void postTest() {
		Entry entry = new Entry(Date.valueOf("2016-04-19"), "Title", "Author", "This is the entry's body.");
		entryList.post(entry);
		assertEquals(entry, entryList.getLast());
	}
	
	@Test
	public void deleteAndSizeTest(){
		assertEquals(3, entryList.size());
		for (Entry entry : entryList) {
			if(entry.getAuthor().equals("Me"))
				entryList.delete(entry.getId());
			break;
		}
		assertEquals(2, entryList.size());
	}
	
	@Test
	public void getTest(){
		Entry entry = new Entry(Date.valueOf("2016-04-19"), "Title", "Author", "This is the entry's body.");
		entryList.post(entry);
		assertEquals(entry, entryList.get(3));
	}
	
	@Test
	public void whenBlogListHasIncreasedSizeTest(){
		for (int i = 0; i < BlogList.ARRAY_FIRST_SIZE ; i++) {
			Entry entry = new Entry(Date.valueOf("2016-04-19"), "Title "+i, "Author "+i, "This is the "+i+" entry's body.");
			entryList.post(entry);
		}
		assertEquals(13, entryList.size());
	}
	
	@Test
	public void getLastTest(){
		Entry entry = new Entry(Date.valueOf("2016-04-19"), "Title", "Author", "This is the entry's body.");
		entryList.post(entry);
		assertEquals(entry, entryList.getLast());
	}

	@Test
	public void getFirstTenTest(){
		for (int i = 0; i < BlogList.ARRAY_FIRST_SIZE ; i++) {
			Entry entry = new Entry(Date.valueOf("2016-04-19"), "Title "+i, "Author "+i, "This is the "+i+" entry's body.");
			entryList.post(entry);
		}
		assertEquals(10, entryList.getFirstTen().size());
		
	}
}
