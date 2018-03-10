package jianzhi;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintList {
    /**
     * 思路就是递归，控制好递归条件就行
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode temp = listNode;
        ArrayList<Integer> result = null;
        if(temp != null) {
            result = printListFromTailToHead(temp.next);
            result.add(temp.val);
            return result;
        }
        else
            return new ArrayList<>();
    }

    public static void main(String[] args){
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        System.out.println(new PrintList().printListFromTailToHead(test));
    }
}
