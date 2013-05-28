package com.wtj.SimpleTest;

import java.util.Date;

public class SimpleTest {

	public static void main(String[] args) throws InterruptedException {
		

		System.out.print(new Date().getTime());
		Thread.sleep(1000);
		System.out.print(new Date().getTime());
	}

}
