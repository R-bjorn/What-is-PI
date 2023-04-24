package numberGenerator;

import java.math.BigInteger;

public class PiNumber {
    protected BigInteger TWO;
    protected BigInteger THREE;
    protected BigInteger FOUR;
    protected BigInteger SEVEN;

    public PiNumber() {
        TWO = BigInteger.valueOf(2);
        THREE = BigInteger.valueOf(3);
        FOUR = BigInteger.valueOf(4);
        SEVEN = BigInteger.valueOf(7);
    }

    public String getPiDigits(int startIndex, int limit) {
        BigInteger q = BigInteger.ONE;
        BigInteger r = BigInteger.ZERO;
        BigInteger t = BigInteger.ONE;
        BigInteger k = BigInteger.ONE;
        BigInteger n = BigInteger.valueOf(3);
        BigInteger l = BigInteger.valueOf(3);

        StringBuilder sb = new StringBuilder();
        BigInteger nn, nr;
        int currentIndex = 0;

        while (sb.length() < limit + startIndex) {
            if (FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1) {
                if (currentIndex >= startIndex) {
                    sb.append(n);
                }
                nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t)));
                n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n));
                q = q.multiply(BigInteger.TEN);
                r = nr;

                currentIndex++;
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
        
        return sb.substring(0, limit-startIndex);
    }
}
