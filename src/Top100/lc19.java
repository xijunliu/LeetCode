package Top100;

public class lc19 {
    class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 //更好的办法是，用两个指针先往前遍历n个，判断是不是到头了，没到头，在和从头开始的指针一起往前走，知道先开始的指针走到头，就发现第一个指针的下一个节点就是待删除的节点

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode node = head;
        int l = 0;
        while(node != null){
            l++;
            node = node.next;
        }
        if(l < n) return null;
        if(l == n) return head.next;
        int sub = l - n ;
        node = head;
        while(sub != 1){
            node = node.next;
            sub--;
        }
        node.next = node.next.next;
        return head;
    }
}
