public class No21_MergeTwoSortedLists {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        int first;
        ListNode resultNode;

        if(l1 != null && l2 != null){
            if(l1.val > l2.val){
                first = l2.val;
                l2 = l2.next;
            }else{
                first = l1.val;
                l1 = l1.next;
            }

            resultNode = new ListNode(first);
        }else if(l1 == null && l2 != null){
            resultNode = new ListNode(l2.val);
            l2 = l2.next;
        }else if(l1 != null && l2 == null){
            resultNode = new ListNode(l1.val);
            l1 = l1.next;
        }else{
            return null;
        }

        recursionMerge(resultNode, l1, l2);

        return resultNode;
    }

    public ListNode recursionMerge(ListNode resultNode, ListNode l1, ListNode l2){

        if(l1 == null && l2 != null){
            resultNode.next = new ListNode(l2.val);
            l2 = l2.next;
        }else if(l1 != null && l2 == null){
            resultNode.next = new ListNode(l1.val);
            l1 = l1.next;
        }else if(l1 != null && l2 != null){
            if(l1.val > l2.val){
                resultNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                resultNode.next = new ListNode(l1.val);
                l1 = l1.next;
            }
        }else if(l1 == null && l2 == null){
            return null;
        }

        recursionMerge(resultNode.next, l1, l2);

        return resultNode;

        //Much simpler and quicker way
//        ListNode dummy = new ListNode(-1);
//    ListNode head = dummy;
//        while(l1 != null && l2 != null){
//        if(l1.val < l2.val){
//            head.next = l1;
//            l1 = l1.next;
//        }else{
//            head.next = l2;
//            l2 = l2.next;
//        }
//        head = head.next;
//    }
//        if(l1 != null){
//        head.next = l1;
//    }
//        if(l2 != null){
//        head.next = l2;
//    }
//        return dummy.next;
    }


//

}
