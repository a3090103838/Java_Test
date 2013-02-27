package com.wtj.oo;

class Father{
	static int i =1;
	static
	{
		System.out.print("父类静态初始化快");
	}
	
	{
		System.out.print("父类实例初始化快");
	}
}

@SuppressWarnings("static-access")
public class Test extends Father{
	static int i = 2;
	
	static
	{
		System.out.print("子类静态初始化快");
	}
	
	{
		System.out.print(super.i);
		System.out.print(i);
	}

    public static void main(String [] args)
    {
    	//String [] a = {"","","123"};
    	//int [] b = {1,2,3};
    	//System.out.print(b);
    	//System.out.print(a);
    	//new Test();
 
    }
}