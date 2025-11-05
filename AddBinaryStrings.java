class Solution {
    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        // Process bits from right to left safely
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += s1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += s2.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);   // current bit
            carry = sum / 2;      // update carry
        }

        // reverse result
        sb.reverse();

        // remove leading zeros
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') {
            k++;
        }

        return sb.substring(k);
    }
}
