import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SkewFieldPolynomial {
	private HashMap<SkewFieldSentence, Integer> polynomial;
	
	public SkewFieldPolynomial(HashMap<SkewFieldSentence, Integer> m){
		polynomial = m;
	}
	
	public HashMap<SkewFieldSentence, Integer> getMap()
	{
		return polynomial;
	}
	
	public String toString(){
		String out = "";
		SkewFieldSentence val;
		Iterator itr = polynomial.keySet().iterator();
		while(itr.hasNext()){
			val = (SkewFieldSentence)itr.next();
			out += "(";
			out += val;
			out += ")*t^";
			out += polynomial.get(val);
			if (itr.hasNext()){
				out += "+";
			}
			
		}
		return out;
	}
	
	public void simplify(){
		Object[] s = polynomial.keySet().toArray();
		for(int i = 0; i < s.length; i++){
			int power = polynomial.get(s[i]);
			for(int j = i+1; j < s.length; j++){
				if(power == polynomial.get(s[j])){
					SkewFieldSentence sum = ((SkewFieldSentence) s[i]).plus((SkewFieldSentence) s[j]);
					polynomial.remove(s[i]);
					polynomial.remove(s[j]);
					polynomial.put(sum, power);
					s = polynomial.keySet().toArray();
					j = s.length;
					i = i-1;
				}
			}
		}
	}
	
	public SkewFieldPolynomial plus(SkewFieldPolynomial other){			
		HashMap<SkewFieldSentence,Integer> newpolynomial = new HashMap<SkewFieldSentence,Integer>();
		newpolynomial.putAll(polynomial);
		newpolynomial.putAll(other.getMap());
		SkewFieldPolynomial sum = new SkewFieldPolynomial(newpolynomial);
		sum.simplify();
		return sum;
	}
	
	public SkewFieldPolynomial times(SkewFieldPolynomial other){	
		Iterator it1 = polynomial.keySet().iterator();
		Iterator it2;
		HashMap<SkewFieldSentence,Integer> result = new HashMap<SkewFieldSentence,Integer>();
		while(it1.hasNext()){
			SkewFieldSentence val1 = (SkewFieldSentence)it1.next();
			it2 = other.getMap().keySet().iterator();
			while (it2.hasNext()){
				SkewFieldSentence val2 = (SkewFieldSentence)it2.next();
				result.put(val1.times(val2), polynomial.get(val1).intValue()+other.getMap().get(val2).intValue());
			}
		}
		SkewFieldPolynomial product = new SkewFieldPolynomial(result);
		product.simplify();
		return product;
	}
	
}
