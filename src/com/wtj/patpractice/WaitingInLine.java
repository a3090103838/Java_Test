package com.wtj.patpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Custom
{
	public int waitingTime;
	public int selfTime;
	public int num;
	
	public Custom(int selfTime,int num)
	{
		this.selfTime = selfTime;
		this.num = num;
	}
}

public class WaitingInLine {
	
	public static void printQueue(List<Custom> list)
	{
		for(int i = 0;i<list.size();i++)
			System.out.print(list.get(i).selfTime+",");
		System.out.println();
	}
	
	public static void printTime(int time)
	{
		if(time>540)
			System.out.println("Sorry");
		else{
			printNum(8+time/60);
			System.out.print(":");
			printNum(time%60);
		}
		System.out.println();
	}
	
	public static void printNum(int num)
	{
		if(num<10)
			System.out.print("0");
		System.out.print(num);
	}

	public static void main(String[] args) {
		int totalTime = 0;
		int N,M,K,Q;
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		Q = in.nextInt();
		
		Map<Integer,Custom> map = new HashMap<Integer, Custom>();
		int[]query = new int[Q];
		ArrayList<LinkedList<Custom>> queueList = new ArrayList<LinkedList<Custom>>();
		Queue<Custom> waitingList = new LinkedList<Custom>();
		
		for(int i =0;i<K;i++)
		{
			int selfTime = in.nextInt();
			map.put(i, new Custom(selfTime,i));
		}
		
		for(int i = 0;i<Q;i++)
		{
			query[i] = in.nextInt();
		}
		
		for(int i =0;i<N;i++)
			queueList.add(new LinkedList<Custom>());
		
		int i = 0;
		for(i = 0;i<K&&i<M*N;i++){
			Custom custom = map.get(i);
			queueList.get(i%N).add(custom);
		}
		
		for(;i<K;i++)
		{
			waitingList.add(map.get(i));
		}
		
		for(int j = 0;j<K;j++){
			
			int minSize = 50;
			int minSizeIndex = 0;
			int minHead = 1000;
			int minHeadIndex = 0;
			for(int k = 0;k<N;k++)
			{
				Queue<Custom> queue = queueList.get(k);

				if(queue.peek()!=null&&queue.peek().selfTime<minHead){
					minHeadIndex = k;
					minHead = queue.peek().selfTime;
				}
			}
			
			int minTime = queueList.get(minHeadIndex).peek().selfTime;
			
			for(int k = 0;k<N;k++)
			{
				Queue<Custom> queue = (Queue<Custom>) queueList.get(k);
				if(k==minHeadIndex){
					totalTime = totalTime+minTime;
					queue.poll().waitingTime = totalTime;
				}
				else{
					Custom custom = queue.peek();
					if(custom!=null)
						custom.selfTime -= minTime;
				}
			
			}
			
			for(int k = 0;k<N;k++)
			{	
				Queue<Custom> queue = (Queue<Custom>) queueList.get(k);
				if(queue.size()<minSize){
					minSizeIndex = k;
					minSize = queue.size();
				}
			}
			
			if(waitingList.size()>=1)
			{
				Custom custom = waitingList.poll();
				queueList.get(minSizeIndex).add(custom);
			}
		}
		
		for(int j =0;j<Q;j++)
		{
			printTime(map.get(query[j]-1).waitingTime);
		}
	}

}
