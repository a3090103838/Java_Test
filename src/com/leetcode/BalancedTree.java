package com.leetcode;

public class BalancedTree {
	class Tag{
		public Tag(Boolean tag) {
			super();
			this.tag = tag;
		}

		Boolean tag;

		public Boolean getTag() {
			return tag;
		}

		public void setTag(Boolean tag) {
			this.tag = tag;
		}
	}

    public boolean isBalanced(TreeNode root) {
    	Tag tag = new Tag(true);
    	height(root, tag);
		return tag.getTag();       
    }
    
    public int height(TreeNode root, Tag tag){
    	if(root==null) return 0;
    	return max(height(root.left, tag), height(root.right, tag), tag) + 1;
    }
	
	private int max(int height1, int height2, Tag tag) {
		if(Math.abs(height2-height1)>1) tag.setTag(false);
		return height1>height2?height1:height2;
	}

	public static void main(String[] args) {
		BalancedTree bt = new BalancedTree();
		TreeNode root = new TreeNode(1);
		//root.left = new TreeNode(1);
		//root.left.left = new TreeNode(1);
		System.out.print(bt.isBalanced(root));
	}

}
