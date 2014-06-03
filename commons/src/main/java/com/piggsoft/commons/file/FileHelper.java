package com.piggsoft.commons.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.piggsoft.commons.file.callback.FileReadCallback;

/**
 * 
 * @author piggsoft@163.com
 * @version 1.0.0
 * @since 2014/2/20
 */
public class FileHelper {
	
	public static void readeFile(String fileName, String encoding, FileReadCallback callback) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), 
				"UTF-8"));
		String s = null;
		while((s = reader.readLine()) != null) {
			callback.process(s);
		}
		reader.close();
	}
	
}
