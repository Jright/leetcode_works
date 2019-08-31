package No51_100;

// Copied answer: https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation
public class No67_AddBinary {

    public String addBinary(String a, String b) {

        // Starts from two String's last index
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;

        // carry digit, if any.
        int carry = 0;

        // reverse it before return.
        StringBuilder sb = new StringBuilder();

        while (l1 >= 0 || l2 >= 0) {

            // get the last carry digit
            int sum = carry;

            if(l1 >= 0){
                // notice this tirck, ASCII.
                sum += a.charAt(l1) - '0';
                l1--;
            }

            if(l2 >= 0){
                sum += b.charAt(l2) - '0';
                l2--;
            }

            // mod, there are 3 cases for sum: 2, 1, 0.
            sb.append(sum % 2);

            // here we handle the case when sum is 2.
            carry = sum / 2;
        }

        // the leftover carry digit (in the most left side).
        if(carry != 0){
            sb.append(carry);
        }

        // reverse this left-right built string builder.
        return sb.reverse().toString();


    }
}
