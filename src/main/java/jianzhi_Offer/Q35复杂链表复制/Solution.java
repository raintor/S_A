package jianzhi_Offer.Q35复杂链表复制;

/**
 * @author: raintor
 * @Date: 2019/9/18 21:18
 * @Description:
 */
public class Solution {
    public ComplexListNode Clone(ComplexListNode pHead){
        if(pHead == null){
            return null;
        }
        ComplexListNode node = pHead;
        while (node!=null){
            ComplexListNode temp = new ComplexListNode(node.val);
            ComplexListNode next = node.next;
            node.next = temp;
            temp.next = next;
            node = next;
        }
        ComplexListNode randomNode = pHead;
        while (randomNode!=null){
            if(randomNode.random!=null){
                ComplexListNode next = randomNode.next;
                next.random = randomNode.random.next;
                randomNode = next.next;
            }
        }
        //分割
        //奇偶拆分

        return node;
    }
}

/**
 * 定义复杂链表的节点
 */
class ComplexListNode{
    int val;
    ComplexListNode next;
    ComplexListNode random;

    public ComplexListNode(int val) {
        this.val = val;
    }
}