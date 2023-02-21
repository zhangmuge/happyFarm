package com.zqsoft.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 文件读写操作
public class FileUtils {
	
	public static List<String> readFile(String fileName){
		List<String> list=new ArrayList<String>();
		File f=new File(fileName);
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			String str;
			while((str=br.readLine())!=null) {
				list.add(str);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public static void writeFile(String fileName,String str) {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(fileName));
			bw.write(str);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public static void clearFile(String fileName)
    {
        File file=new File(fileName);
        try {
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
