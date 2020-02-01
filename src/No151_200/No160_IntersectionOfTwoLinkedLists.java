package No151_200;

import Data_Structures.ListNode;

import java.util.HashMap;

public class No160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        while (headA != null) {

            hashMap.put(headA.val, headA.toString());
            headA = headA.next;

        }

        while(headB != null){

            String s = hashMap.get(headB.val);
            if(s != null && s.equals(headB.toString())){
                return new ListNode(headB.val);
            }else{
                headB = headB.next;
            }
        }

        return null;
    }



}
