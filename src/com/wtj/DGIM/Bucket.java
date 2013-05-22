package com.wtj.DGIM;

public class Bucket {
	
	private int time;
	private int size;
	
	public Bucket(int time, int size) {
		this.time = time;
		this.size = size;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Bucket:time:"+this.getTime()+",size:"+this.getSize();
	}

}
