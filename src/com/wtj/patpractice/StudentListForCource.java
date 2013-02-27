package com.wtj.patpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentListForCource {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfS = in.nextInt();
		int numOfC = in.nextInt();
		List<String>[] courceList = new List[numOfC];
		int courceNo;
		
		for(int i = 0;i<numOfC;i++){
			courceList[i] = new ArrayList<String>();
		}
		for(int i =0;i<numOfS;i++){
			String name = in.next();
			while(in.hasNextInt()){
				courceNo = in.nextInt();
				courceList[courceNo-1].add(name);
			}
		}
		
		for(int i=0;i<numOfC;i++){
			List<String> list = courceList[i];
			System.out.println((i+1)+" "+list.size());
			Collections.sort(list);
			for(String name:list){
				System.out.println(name);
			}
		}
	}

}
