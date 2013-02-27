package com.wtj.MultiThread;

class PrintNumRun implements Runnable
{
	static int count = 0;
	static Object obj = new Object();
	private int num;
	
	public PrintNumRun(int num)
	{
		this.num = num;
	}
	
	public void print()
	{
		synchronized (obj) {
			try {
				while((count%3)!=num){
					//System.out.print(count);
					obj.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print((char)('a'+num));	
			count++;
			obj.notifyAll();
		}
	}
	
	@Override
	public void run() {
		for(int i =0;i<10;i++)
				print();
	}
}

public class MultiThreadTest {

	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread(new PrintNumRun(0));
		Thread t2 = new Thread(new PrintNumRun(1));
		Thread t3 = new Thread(new PrintNumRun(2));
		t1.start();
		t2.start();
		t3.start();
	}
}
