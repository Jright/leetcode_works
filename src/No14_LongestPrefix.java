public class No14_LongestPrefix {

    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"1221", "1267", "1259"});
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder resultBuilder = new StringBuilder();


        int pointer = 0;
        while (pointer < strs[0].length()) {
            for (int i = 1; i < strs.length; i++) {
                if (pointer >= strs[i].length()) {
                    return resultBuilder.toString();
                }

                if (strs[0].charAt(pointer) != strs[i].charAt(pointer)) {
                    return resultBuilder.toString();
                }
            }
            resultBuilder.append(strs[0].charAt(pointer));
            pointer++;
        }


        return resultBuilder.toString();
    }

    public static String quickerWay(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pre = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }

}
