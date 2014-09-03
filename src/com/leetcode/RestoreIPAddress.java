package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress {
	public void helper(String s, List<String> preRes, int leftNum, List<String> res){
		if(leftNum==0) {
			res.add(makeIp(preRes));
			return;
		}
		
		int length = s.length();
		if(length>=1*leftNum && length<=3*leftNum){
			for(int i=1;i<=3&&i<=s.length();i++){
				String strNum = s.substring(0, i);
				String strLeft = s.substring(i);
				int num = Integer.valueOf(strNum);
				if(num>=0 && num<=255){
					preRes.add(strNum);
					helper(strLeft, preRes, leftNum-1, res);
					preRes.remove(strNum);
				}
			}
		}
	}
	
    private String makeIp(List<String> preRes) {
    	StringBuilder sb = new StringBuilder();
    	
    	for(String item: preRes)
    		sb.append(item+".");
    	String res = sb.toString();
		return res.substring(0, res.length()-1);
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new LinkedList<String>();
		List<String> filteredRes = new LinkedList<String>();
		List<String> preRes = new LinkedList<String>();
		
		helper(s, preRes, 4, res);
		for(String item: res){
			if(item.length()==s.length()+3)
				filteredRes.add(item);
		}
		return  filteredRes;        
    }
	
	public static void main(String[] args) {
		RestoreIPAddress ri = new RestoreIPAddress();
		System.out.println(ri.restoreIpAddresses("25525511135"));
	}

}
