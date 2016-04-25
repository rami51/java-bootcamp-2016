package com.bootcamp.topic2.recentFileListTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.topic2.recentFileList.File;
import com.bootcamp.topic2.recentFileList.FileList;

public class FileListTest {
	FileList list;
	
	@Before
	public void setUp() throws Exception {
		list = new FileList();
	}

	@Test
	public void FirstTimeTest() {
		assertEquals(0, list.size());
	}
	
	@Test
	public void WhenNumberOfFilesIsMinorThanMaxFilesNumberAddTest(){
		list.clear();
		fillList();
		for(int i = list.MAX_FILES_NUM - 1; i>=0; i--){
			assertEquals("File"+i , list.get(list.MAX_FILES_NUM - i - 1).getName());
		}
	}
	
	@Test
	public void WhenNumberOfFilesIsHigherThanMaxFilesNumberAddTest(){
		list.clear();
		fillList();
		File f = new File();
		f.setName("File-A");
		f.open();
		list.add(f);
		assertEquals("File-A", list.getFirst().getName());
	}

	@Test
	public void WhenNumberOfFilesIsHigherThanMaxFilesNumberAndFileIsInListAddTest(){
		list.clear();
		fillList();
		File f = list.get(9); //File5
		f.open();
		list.add(f);
		assertEquals("File5", list.getFirst().getName());
		for (int i = 1; i < list.size(); i++) {
			assertTrue(!list.get(i).getName().equals("File5"));
		}
	}
	
	private void fillList(){
		for (int i = 0; i < list.MAX_FILES_NUM ; i++) {
			File f = new File();
			f.setName("File"+Integer.toString(i));
			f.open();
			list.add(f);
		}
	}
}
