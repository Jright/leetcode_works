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
}
