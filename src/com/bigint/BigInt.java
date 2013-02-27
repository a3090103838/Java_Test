package com.bigint;

import java.text.DecimalFormat;
import java.util.ArrayList;

//实现大数加法，4字节int最大表示2的32次方，所以每个单位最多九位数，可以保证加和不溢出
public class BigInt {
	//一个string的arraylist存储大数
	private ArrayList<String>data;
	
	//空构造函数
	public BigInt(){
		data=new ArrayList<String>();
	}
	
	//构造函数，根据一个string的数组初始化一个大数（可加对string长度，内容的限制判断）
	public BigInt(String[] datas){
		data=new ArrayList<String>();
		for(int i=0;i<datas.length;i++)
			data.add(datas[i]);
	}
	
	//返回大数data数组的大小
	public int getSize(){
		return data.size();
	}
	
	//返回指定index的string,(可加边界判断)
	public String get(int i){
		return data.get(i);
	}
	
	//向arraylist增加一个string
	public void appendData(String newdata){
		data.add(newdata);
	}
	
	public void print(){
		DecimalFormat df=new DecimalFormat("000000000"); 
		for(int i=data.size()-1;i>-1;i--){
			System.out.print(df.format(Integer.valueOf(data.get(i))));
		}
		System.out.println();
	}
	
	//加法函数，返回结果大数
	public BigInt add(BigInt addnum){
		BigInt result = new BigInt();
		int addition = 0;
		int i=0;
		for(;i<data.size();i++){
			if(i>=addnum.getSize())
				break;
			int a = Integer.valueOf(data.get(i));
			int b = Integer.valueOf(addnum.get(i));
			if((a+b+addition)>=1000000000){
				result.appendData(new Integer(a+b+addition-1000000000).toString());
				addition = 1;
			}
			else{
				result.appendData(new Integer(a+b+addition).toString());
				addition = 0;
			}			
		}
		
		//将addnum中的剩余项加到result中（getSize()可以提取出来）
		for(;i<addnum.getSize();i++){
			if(addition==1){
				String newstr = String.valueOf( Integer.valueOf(addnum.get(i))+1 );
				addition = 0;
				result.appendData(newstr);
			}
			else
				result.appendData(addnum.get(i));
		}
		
		//将本身的剩余项加到result中（this.getSize()可以提取出来）
		for(;i<this.getSize();i++){
			if(addition==1){
				String newstr = String.valueOf( Integer.valueOf(this.get(i))+1 );
				addition = 0;
				result.appendData(newstr);
			}
			else
				result.appendData(this.get(i));
		}
		if(addition==1)
			result.appendData(new String("1"));
			
		return result;
	}

	public static void main(String[] args) {
		String [] data1 = {"511111111","511111111"};
		String [] data2 = {"987654321","123456789"};
		BigInt a = new BigInt(data1);
		BigInt b = new BigInt(data2);
		a.print();
		b.print();
		BigInt result = a.add(a);
		result.print();
		//System.out.println(1111111111+1111111111);
	}

}
