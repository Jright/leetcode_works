package No151_200;

import Data_Structures.ListNode;

import java.util.HashMap;

public class No160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        ListNode countNodeA = headA;
        ListNode countNodeB = headB;

        while(countNodeA != null){
            lenA++;
            countNodeA = countNodeA.next;
        }

        while(countNodeB != null){
            lenB++;
            countNodeB = countNodeB.next;
        }

        int diff = Math.abs(lenA - lenB);

        if(lenA > lenB){
            while(diff > 0){
                headA = headA.next;
                diff--;
            }

            while(lenB > 0){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
                lenB--;
            }
        }else if(lenA < lenB){
            while(diff > 0){
                headB = headB.next;
                diff--;
            }

            while(lenB > 0){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
                lenB--;
            }
        }else{
            while(lenB > 0){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
                lenB--;
            }
        }
        return null;
    }
}
