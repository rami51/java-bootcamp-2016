package com.bootcamp.topic2_b.blogTest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.topic2_b.blog.Entry;

public class EntryTest {
	private Entry entry1;
	
	@Before
	public void setUp() throws Exception {
		entry1 = new Entry(Date.valueOf("2016-04-26"), "Title", "Author", "Body");
	}

	@Test
	public void whenIdIncreasesTest() {
		Entry entry2 = new Entry(Date.valueOf("2016-04-27"), "Title2", "Author2", "Body2");
		assertEquals(entry1.getId()+1, entry2.getId());
	}

}
