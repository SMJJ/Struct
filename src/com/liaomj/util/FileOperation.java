package com.liaomj.util;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
	public static boolean readFile(String filename,ArrayList<String> words) {
		if(filename == null || words == null) {
			System.out.println("filename is null or words is null");
			return false;
		}
		
		Scanner scanner = null;
		
		try {
			File file = new File(filename);
			if(file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
				scanner.useLocale(Locale.ENGLISH);
				}
			}
		catch (IOException e) {
			System.out.println("Cannot open " + filename);
			return false;
		}
		
		if(scanner.hasNextLine()) {
			String contents = scanner.useDelimiter("\\A").next();
			int start = firstCharacterIndex(contents,0);
			for(int i=start+1;i<contents.length();) {
				
			}
			
		}
		return false;
		
	}
	
	private static int firstCharacterIndex(String s,int start) {
		for(int i = start;i<s.length();i++)
			if(Character.isLetter(s.charAt(i)))
				return i;
		return s.length();
	}
}
