package com.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

	public void helper(List<Interval> intervals, int start){
		if(start==intervals.size()-1) return;
		
		Interval cur = intervals.get(start);
		Interval next = intervals.get(start+1);
		if(next.start>cur.end)
			helper(intervals, start+1);
		else{
			intervals.remove(start+1);
			cur.end = cur.end>=next.end?cur.end:next.end;
			helper(intervals, start);
		}
	}
	
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals==null) return intervals;
    	helper(intervals, 0);
		return intervals;      
    }
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	intervals.add(newInterval);
    	Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
        return merge(intervals);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
