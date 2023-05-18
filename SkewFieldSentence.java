import java.util.HashMap;
import java.util.Iterator;
public class SkewFieldSentence {
	private HashMap<SkewFieldWord,Integer> sentence;
	public SkewFieldSentence(HashMap<SkewFieldWord,Integer> m ){
		sentence = m;
	}
	
	public HashMap<SkewFieldWord, Integer> getMap()
	{
		this.simplify();
		return sentence;
	}
	
	public String toString(){
		String out = "";
		SkewFieldWord val;
		Iterator itr = sentence.keySet().iterator();
		while (itr.hasNext()){
			val = (SkewFieldWord)itr.next();
			out += sentence.get(val);
			out += "*(";
			out += val;
			out += ")";
			if (itr.hasNext()){
				out += "+";
			}
		}
		return out;
	}
	
	private void simplify(){
		Object[] s = sentence.keySet().toArray();
		for(int i = 0; i < s.length; i++){
			if(sentence.get(s[i]) == 0)
				sentence.remove(s[i]);
		}
	}
	public SkewFieldSentence plus(SkewFieldSentence other){			//NOTE: haven't implemented case when two letters are equal yet.
		HashMap<SkewFieldWord,Integer> newsentence = new HashMap<SkewFieldWord,Integer>();
		newsentence.putAll(sentence);
		newsentence.putAll(other.getMap());
		SkewFieldSentence sum = new SkewFieldSentence(newsentence);
		sum.simplify();
		return sum;
	}
	
	public SkewFieldSentence times(SkewFieldSentence other){		//note: haven't implemented case with zero yet
		Iterator it1 = sentence.keySet().iterator();
		Iterator it2;
		HashMap<SkewFieldWord,Integer> result = new HashMap<SkewFieldWord,Integer>();
		while(it1.hasNext()){
			SkewFieldWord val1 = (SkewFieldWord)it1.next();
			it2 = other.getMap().keySet().iterator();
			while (it2.hasNext()){
				SkewFieldWord val2 = (SkewFieldWord)it2.next();
				result.put(val1.times(val2), sentence.get(val1).intValue()*other.getMap().get(val2).intValue());
			}
		}
		SkewFieldSentence product = new SkewFieldSentence(result);
		product.simplify();
		return product;
	}
}
