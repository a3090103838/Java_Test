package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
		List<TreeNode> cur = new ArrayList<TreeNode>();
		List<TreeNode> other = new ArrayList<TreeNode>();
		
		cur.add(root);
		while(!cur.isEmpty()){
		    if(isAllNull(cur)) return true;
			if(!isSymmetric(cur)) return false;
			for(TreeNode item: cur){
				if(item.left!=null) 
				    other.add(item.left);
				else
				    other.add(new TreeNode(-1));
                if(item.right!=null) 
                    other.add(item.right);
                else
                    other.add(new TreeNode(-1));
			}
			cur.clear();
			
			List<TreeNode> tmp = cur;
			cur = other;
			other = tmp;
		}		
		return true;
    }
    	
	private boolean isAllNull(List<TreeNode> cur) {
        for(TreeNode tn: cur)
            if(tn.val!=-1)
                return false;
        return true;
    }

    private boolean isSymmetric(List<TreeNode> cur) {
		int start = 0;
		int end = cur.size()-1;
		while(start < end){
			if(cur.get(start++).val!=cur.get(end--).val)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
	    SymmetricTree st = new SymmetricTree();
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(1);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(1);
	    root.right.right = new TreeNode(1);
	    System.out.println(st.isSymmetric(root));
	}

}
