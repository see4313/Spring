package com.yedam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.jupiter.api.Test;

public class FileTest {
	
	@Test
	public void list() {
		
		File file = new File("C:\\temp");
		String[] list = file.list();
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}

	// 파일 이름 바꾸기 
//	@Test
	public void rename() {
		File file = new File("c:/temp/writer.txt");
		file.renameTo(new File("c:/temp/original_writer.txt"));
	}
	
	// 파일 복사
//	@Test
	public void copy() throws Exception {
		FileInputStream fi = new FileInputStream(new File("c:/temp", "origin.png"));
		FileOutputStream fo = new FileOutputStream(new File("c:/temp", "복사연습.png"));
		
		int temp;
		while( (temp = fi.read() ) != -1) {
			fo.write(temp);
		}
		fi.close();
		fo.close();
	}
	

}
