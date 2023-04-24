package numberGenerator;

import java.math.BigInteger;

public class PiNumber {
    protected static BigInteger TWO;
    protected static BigInteger THREE;
    protected static BigInteger FOUR;
    protected static BigInteger SEVEN;
    
    private static int currentIndex = 0;
    private static int currentLimit = 0;
    private static String piDigits = null;

    public PiNumber() {
        TWO = BigInteger.valueOf(2);
        THREE = BigInteger.valueOf(3);
        FOUR = BigInteger.valueOf(4);
        SEVEN = BigInteger.valueOf(7);
    }
    
    public static String getPiDigits(int startIndex, int limit) {
        // If we have already computed piDigits up to the currentLimit, we can reuse the existing value
        if (startIndex == currentIndex && limit == currentLimit && piDigits != null) {
            return piDigits;
        }
    	
        BigInteger q = BigInteger.ONE;
        BigInteger r = BigInteger.ZERO;
        BigInteger t = BigInteger.ONE;
        BigInteger k = BigInteger.ONE;
        BigInteger n = BigInteger.valueOf(3);
        BigInteger l = BigInteger.valueOf(3);

        StringBuilder sb = new StringBuilder();
        BigInteger nn, nr;
        int i = 0;

        while (sb.length() < limit) {
            if (FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1) {
                if (i >= startIndex) {
                    sb.append(n);
                }
                nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t)));
                n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n));
                q = q.multiply(BigInteger.TEN);
                r = nr;

                i++;
            } else {
                nr = TWO.multiply(q).add(r).multiply(l);
                nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l));
                q = q.multiply(k);
                t = t.multiply(l);
                l = l.add(TWO);
                k = k.add(BigInteger.ONE);
                n = nn;
                r = nr;
            }
        }
        
        // Update the current index, limit, and piDigits variables
        currentIndex = startIndex;
        currentLimit = limit;
        piDigits = sb.toString();
        
        return piDigits;
    }
}
