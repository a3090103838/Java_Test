package com.wtj.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileStream {

	public static void main(String[] args) {
		
		Map <String , Integer> map = new HashMap<String, Integer>();
		
		try {
			@SuppressWarnings("resource")
			FileWriter out = new FileWriter("test.data");
			out.append("aaa aaa bb bbb bb ccc ccc");
			out.flush();
			Scanner in = new Scanner(new FileReader("test.data"));
			while(in.hasNextLine())
			{
				String line = in.nextLine();
				String[] words = line.split("\\s");
				for(int i = 0;i<words.length;i++)
				{
					if(map.containsKey(words[i]))
						map.put(words[i], map.get(words[i])+1);
					else
						map.put(words[i], 1);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String key:map.keySet())
		{
			System.out.println(key+":"+map.get(key));
		}
	}

}
