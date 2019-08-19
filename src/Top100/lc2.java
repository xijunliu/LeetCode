package Top100;

import java.util.LinkedList;
import java.util.Stack;

public class lc2 {
    public class ListNode {
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode node1 = l1;
        while (node1 != null){
            stack1.add(node1.val);
            node1 = node1.next;
        }
        ListNode node2 = l2;
        while (node2 != null){
            stack2.add(node2.val);
            node2 = node2.next;
        }
        int len = stack1.size() > stack2.size() ? stack2.size():stack1.size();
        int j = 0;
        int k = 0;
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = 0; i < len; i++){
            k = (stack1.peek() + stack2.peek() + j) % 10;
            j = (stack1.pop() + stack2.pop()) / 10;
            res.addFirst(k);
        }
        while (!stack1.isEmpty()){
            k = (stack1.peek()  + j) % 10;
            j = stack1.pop() / 10;
            res.addFirst(k);
        }
        while (!stack2.isEmpty()){
            k = (stack2.peek()  + j) % 10;
            j = stack2.pop() / 10;
            res.addFirst(k);
        }
        ListNode head  = new ListNode(res.pollLast());
        ListNode node = head;
        while (!res.isEmpty()){
            node.next = new ListNode(res.pollLast());
            node = node.next;
        }
        return head;
    }
}
