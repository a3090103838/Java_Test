package com.wtj.algorithm;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode
{
	public TreeNode left;
	public TreeNode right;
	private int value;
	private int level;
	
	public TreeNode(int value)
	{
		this.value = value;
		left = null;
		right = null;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}

public class Tree {
	public TreeNode root;
	
	public Tree()
	{
		root = null;
	}
	
	public Tree(TreeNode node)
	{
		root = node;
	}
	
	public Tree(int value)
	{
		root = new TreeNode(value);
	}
	
	public void insert(int value)
	{
		root = insertOnNode(value, root);
	}
	
	public TreeNode insertOnNode(int value,TreeNode node)
	{
		if(node == null ) 
			{
			node = new TreeNode(value);
			return node;
			}
		if(value==node.getValue())
			return node;
		else if(value<node.getValue())
			node.left = insertOnNode(value, node.left);
		else
			node.right = insertOnNode(value, node.right);
		return node;	
	}
	
	public void printTree()
	{
		if(root == null )
			return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		root.setLevel(0);
		int cur_lv = -1;
		q.offer(root);
		while(!q.isEmpty())
		{
			TreeNode current = q.poll();
			System.out.print(current.getValue()+",");
			if(cur_lv<current.getLevel()){
				System.out.println();
				cur_lv = current.getLevel();
			}
			if(current.left!=null){
				current.left.setLevel(current.getLevel()+1);
				q.offer(current.left);
			}
			if(current.right!=null){
				current.right.setLevel(current.getLevel()+1);
				q.offer(current.right);
			}
		}
		System.out.println();
	}
	
	public static void printArray(int[] a)
	{
		for(int i = 0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Tree tree = new Tree();
		int[] a = new int[5];
		for(int i = 0;i<5;i++)
		{
			int num = (int)(Math.random()*100);
			tree.insert(num);
			a[i] = num;
		}
		
		printArray(a);
		
		tree.printTree();

	}

}
