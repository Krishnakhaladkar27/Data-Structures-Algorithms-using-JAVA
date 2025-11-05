class Solution {
    public static double power(double b, int e) {
        long exp = e; // Use long to safely handle -2^31
        if (exp == 0) return 1.0;

        double base = b;
        if (exp < 0) {
            base = 1 / base;
            exp = -exp;
        }

        double result = 1.0;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            }
            base *= base;
            exp >>= 1; // Divide exponent by 2
        }

        return result;
    }
}
