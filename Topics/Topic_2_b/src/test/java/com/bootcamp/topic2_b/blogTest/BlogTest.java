package com.bootcamp.topic2_b.blogTest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.topic2_b.blog.Blog;
import com.bootcamp.topic2_b.blog.Entry;

public class BlogTest {
Blog blog;
	
	@Before
	public void setUp() throws Exception {
		blog = new Blog();
		Entry entry1 = new Entry(Date.valueOf("2016-04-25"), "Sun and sand", "Me", "Sun"
				+ " and sand always can be found in the beach.");
		Entry entry2 = new Entry(Date.valueOf("2016-04-23"), "Soccer match", "Me, again...", "A soccer match always is"
				+ " played in a soccer field, which has two goal sides.");
		Entry entry3 = new Entry(Date.valueOf("2016-04-22"), "Study engineering", "Me, once again!", "Study engineering is"
				+ " a really hard task...");
		blog.addEntry(entry1);
		blog.addEntry(entry2);
		blog.addEntry(entry3);
	}

	@Test
	public void addTest() {
		Entry entry = new Entry(Date.valueOf("2016-04-27"), "Title", "Author", "This is the entry's body.");
		blog.addEntry(entry);
		assertEquals(entry, blog.getMostRecent());
	}
	
	@Test
	public void showTenMostRecentTest(){
		for (int i = 0; i < 10 ; i++) {
			Entry entry = new Entry(Date.valueOf("2016-04-19"), "Title "+i, "Author "+i, "This is the "+i+" entry's body.");
			blog.addEntry(entry);
		}
		Blog tenMostRecent = blog.getRecentPosts(10);
		tenMostRecent.print();					//Shows the ten most recent posts on console.
		assertEquals(10, tenMostRecent.size());
	}
	
	@Test
	public void removeEntryAndGetEntryTest(){
		Entry entry = new Entry(Date.valueOf("2016-04-19"), "Title", "Author", "This is the entry's body.");
		blog.addEntry(entry);
		blog.removeEntry(entry.getId());
		assertTrue(blog.getEntry(entry.getId()) == null);
	}
	
	@Test
	public void updateTest(){
		Entry entry = blog.getMostRecent();
		entry.setTitle("Lalala");
		blog.updateEntry(entry);
		assertEquals("Lalala", blog.getEntry(entry.getId()).getTitle());
	}

}
