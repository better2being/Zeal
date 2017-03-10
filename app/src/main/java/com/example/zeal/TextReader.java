package com.example.zeal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/*
 * 2016/2/25
 * text读取内容工具
 */

public class TextReader {

	/*
	 * 通过一个InputStream获取内容
	 */
	public static List<String> getString(InputStream inputStream) {
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(inputStream, "gbk");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(inputStreamReader);
		List<String> textList = new ArrayList<>();
		String line;
		try {
			while((line = reader.readLine()) != null) {
				textList.add(line);
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return textList;
	}
	
	/*
	 * 通过txt文件的路径获取其内容
	 */
	public static List<String> getString(String filePath) {
		File file = new File(filePath);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return getString(fileInputStream);
	}
}
