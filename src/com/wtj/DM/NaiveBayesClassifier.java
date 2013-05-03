package com.wtj.DM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveBayesClassifier {
	
	//样本数量
	private Integer count = 0;
	//存储 类别=>类别对应数量
	private Map<String,Integer> totalCount = new HashMap<String,Integer>();
	//存储 类别 => map<属性名=>数量> 
	private Map<String, HashMap<String, Integer>> attrCount = new HashMap<String,HashMap<String,Integer>>();
	
	public void train(String type,List<String> attrs){
		this.count++;
		int count = 0;
		if(totalCount.get(type)!=null){
			count = totalCount.get(type);
		}
		count++;
		totalCount.put(type, count);
		
		HashMap<String,Integer> map = null;
		if(attrCount.get(type)!=null){
			map = attrCount.get(type);
		}
		else{
			map = new HashMap<String,Integer>();
		}
			
		for(String attr:attrs){
			if(map.get(attr)!=null)
				map.put(attr, map.get(attr)+1);
			else
				map.put(attr, 1);
		}
		attrCount.put(type, map);
	}
	
	public void printClassifier(){
		for(Map.Entry<String,HashMap<String,Integer> > entry:attrCount.entrySet()){
			String key = entry.getKey();
			System.out.println("type:"+key);
			Map<String,Integer> map = entry.getValue();
			for(Map.Entry<String, Integer> subentry:map.entrySet()){
				System.out.println("attr:"+subentry.getKey()+" count:"+subentry.getValue());
			}
		}
	}
	
	public String classify(List<String>list){	
		double max = 0;
		String ans = null;
		for(String type:totalCount.keySet()){
			double base = 1;
			int typecount = totalCount.get(type);
			base*= typecount;
			for(String attr:list){
				base*=(double)(attrCount.get(type).get(attr))/(double)typecount;
			}
			if(base>=max){
				max = base;
				ans = type;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		NaiveBayesClassifier classifier = new NaiveBayesClassifier();
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("S");
		classifier.train("-1", list);
		list.clear();
		list.add("1");
		list.add("M");
		classifier.train("-1", list);
		list.clear();
		list.add("1");
		list.add("M");
		classifier.train("1", list);
		list.clear();
		list.add("1");
		list.add("S");
		classifier.train("1", list);
		list.clear();
		list.add("1");
		list.add("S");
		classifier.train("-1", list);
		list.clear();
		list.add("2");
		list.add("S");
		classifier.train("-1", list);
		list.clear();
		list.add("2");
		list.add("M");
		classifier.train("-1", list);
		list.clear();
		list.add("2");
		list.add("M");
		classifier.train("1", list);
		list.clear();
		list.add("2");
		list.add("L");
		classifier.train("1", list);
		list.clear();
		list.add("2");
		list.add("L");
		classifier.train("1", list);
		list.clear();
		list.add("3");
		list.add("L");
		classifier.train("1", list);
		list.clear();
		list.add("3");
		list.add("M");
		classifier.train("1", list);
		list.clear();
		list.add("3");
		list.add("M");
		classifier.train("1", list);
		list.clear();
		list.add("3");
		list.add("L");
		classifier.train("1", list);
		list.clear();
		list.add("3");
		list.add("L");
		classifier.train("-1", list);
		//classifier.printClassifier();
		
		list.clear();
		list.add("1");
		list.add("S");
		System.out.println("the classify answer is:"+classifier.classify(list));
	}
}
