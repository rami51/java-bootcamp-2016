package com.bootcamp.topic2.recentFileList;

import java.util.LinkedList;

public class FileList {
 private LinkedList<File> list;
 public final int MAX_FILES_NUM = 15;
 
 
 public FileList(){
	 list = new LinkedList<File>();
 }

public void add(File f){
	if(f.isOpen()){
		/*if(list.contains(f)){
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).equals(f)){
					list.remove(i);
					break;
				}
			}
		}*/
	list.remove(f);    //this is like the comment above.
	list.addFirst(f);
	sizeCorrection();
	}
}

private void sizeCorrection (){
	if(list.size()> MAX_FILES_NUM) list.removeLast();
}

public File get(int index){
	return list.get(index);
}

public File getFirst(){
	return list.getFirst();
}
public void clear(){
	list.clear();
}
public int size(){
	return list.size();
}
}
