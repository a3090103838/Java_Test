package com.leetcode;

import java.util.List;

public class MergeKSortedList {
    
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null || lists.size()==0) return null;
        if(lists.size()==1) return lists.get(0);
        ListNode res = lists.get(0);
        for(int i=1;i<lists.size();i++){
            res = mergeTwoLists(res, lists.get(i));
        }
        
        return res;
    }
    
    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        
        while(first!=null && second!=null){
            if(first.val<=second.val){
                cur.next = first;
                first = first.next;
                cur = cur.next;
            }
            else{
                cur.next = second;
                second = second.next;
                cur = cur.next;
            }
        }
        
        while(first!=null){
            cur.next = first;
            first = first.next;
            cur = cur.next;
        }
        
        while(second!=null){
            cur.next = second;
            second = second.next;
            cur = cur.next;
        }
        
        return res.next;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
