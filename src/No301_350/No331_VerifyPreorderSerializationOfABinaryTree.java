package No301_350;

public class No331_VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        String[] split = preorder.split(",");
        int diff = 1;
        for (String s : split) {
            diff--;
            if(diff < 0){
                return false;
            }
            if (s.equals("#")) {
                continue;
            } else {
                diff += 2;
            }
        }
        return diff == 0;
    }


//    public boolean isValidSerialization(String preorder) {
//        Deque<String> stack = new ArrayDeque<>();
//        //String[] s = preorder.split(',');
//        for(String ch : preorder.split(",")){
//            //if(ch == ',')   continue;
//            if(ch.equals("#")){
//                while(!stack.isEmpty() && stack.getLast().equals("#")){
//                    stack.removeLast();
//                    if(stack.isEmpty()) return false;
//                    stack.removeLast();
//                }
//            }
//            stack.addLast(ch);
//        }
//        return stack.size() == 1 && stack.getLast().equals("#")
//                ? true : false;
//    }
}
