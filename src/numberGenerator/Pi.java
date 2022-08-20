package numberGenerator;

import java.math.BigInteger ;

public class Pi {
  protected BigInteger TWO; 
  protected BigInteger THREE;
  protected BigInteger FOUR;
  protected BigInteger SEVEN;
  
  public Pi() {
	  TWO = BigInteger.valueOf(2) ;
	  THREE = BigInteger.valueOf(3) ;
	  FOUR = BigInteger.valueOf(4) ;
	  SEVEN = BigInteger.valueOf(7) ;
  }
 
  public void calcPiDigits(){
	  BigInteger q = BigInteger.ONE ;
	  BigInteger r = BigInteger.ZERO ;
	  BigInteger t = BigInteger.ONE ;
	  BigInteger k = BigInteger.ONE ;
	  BigInteger n = BigInteger.valueOf(3) ;
	  BigInteger l = BigInteger.valueOf(3) ;
	  
	  BigInteger nn, nr ;
	  boolean first = true ;
	  while(true){
		  if(FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1){
			  System.out.print(n) ;
			  if(first){System.out.print(".") ; first = false ;}
	          nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t))) ;
	          n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n)) ;
	          q = q.multiply(BigInteger.TEN) ;
	          r = nr ;
	          System.out.flush() ;
	        }else{
	          nr = TWO.multiply(q).add(r).multiply(l) ;
	          nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l)) ;
	          q = q.multiply(k) ;
	          t = t.multiply(l) ;
	          l = l.add(TWO) ;
	          k = k.add(BigInteger.ONE) ;
	          n = nn ;
	          r = nr ;
	        }
	    }
	  }
	 
	  public static void main(String[] args) {
	    Pi p = new Pi() ;
	    p.calcPiDigits() ;
	  }
}
