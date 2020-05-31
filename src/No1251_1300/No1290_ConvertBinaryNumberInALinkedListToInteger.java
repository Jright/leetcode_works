package No1251_1300;

import Data_Structures.ListNode;

public class No1290_ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head != null){
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }

}
