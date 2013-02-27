package com.wtj.io;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileSystem {

	
	public static void main(String[] args) {
		List<File> list = new LinkedList<File>();
		File file = new File("D:\\");
		list.add(file);
		
		while(!list.isEmpty())
		{
			File current = list.remove(0);
			if(current.isFile())
				System.out.println("file:"+current.getAbsolutePath());
			else if(current.isDirectory())
			{
				File[] files = current.listFiles();
				if(files!=null)
					for(int i = 0;i<files.length;i++)
						list.add(files[i]);
				System.out.println("directory:"+current.getAbsolutePath());
			}
		}

	}

}
