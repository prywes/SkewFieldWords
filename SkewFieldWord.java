import java.util.HashMap;
import java.util.Map;

public class SkewFieldWord {
	public HashMap<SkewFieldLetter, Integer> getMap()
	{
		return word;
	}
	
	private HashMap<SkewFieldLetter,Integer> word;
	public SkewFieldWord(HashMap<SkewFieldLetter,Integer> h){
		word = h;
		//System.out.println(h);
	}
	
	
	public void addletter(SkewFieldLetter l1, int power){	//for testing purposes
		word.put(l1,new Integer(power));
	}
	
	public SkewFieldWord times(SkewFieldWord other){
		Map<SkewFieldLetter,Integer> product = new HashMap<SkewFieldLetter,Integer>();
		product.putAll(word);
		HashMap<SkewFieldLetter,Integer> othermap = other.getMap();
		Object[] letterlist = othermap.keySet().toArray();
		for(int i = 0; i < letterlist.length; i++){
			if (product.containsKey((SkewFieldLetter)letterlist[i])){
				if((product.get(letterlist[i]).intValue()+ othermap.get(letterlist[i]).intValue()) == 0){
					product.remove(letterlist[i]);
				}
				else{
					product.put((SkewFieldLetter)letterlist[i],product.get(letterlist[i]).intValue()+ othermap.get(letterlist[i]).intValue());
				}
			}
			else{
				product.put((SkewFieldLetter)letterlist[i], othermap.get(letterlist[i]));
			}
		}
		if( product.isEmpty()){
			product.put(new SkewFieldLetter(0,0), new Integer(0));
		}
		return new SkewFieldWord((HashMap<SkewFieldLetter, Integer>)product);
	}
	
	public String toString(){
		String result = "";
		Object[] letterlist = word.keySet().toArray();
		for (int i = 0; i < letterlist.length; i++){
			result += ((SkewFieldLetter)letterlist[i]).toString(); //do we have to cast here?
			result += "^";
			result += word.get((SkewFieldLetter)letterlist[i]).toString();
			if(i != letterlist.length-1){
				result += "*";
			}
		}
		return result;
	}
	

}	
//----------------OLD CODE---------------------
/*	SkewFieldLetter[] word;
	int[] powers;
	
	public SkewFieldWord(SkewFieldLetter[] w, int[] p){
		word = w;
		powers = p;
	}
	
	public SkewFieldLetter[] getWord(){
		return word;
	}
	
	public SkewFieldWord wordTimes(SkewFieldWord w){
		
		SkewFieldLetter[] product = new SkewFieldLetter[w.getWord().length+this.getWord().length];
		int[] productpow = new int[product.length];
		for(int i = 0; i<this.getWord().length; i++){
			product[i] = this.getWord()[i];
			
		}
		for(int j = 0; j<w.getWord().length; j++){
			product[this.getWord().length+j] = w.getWord()[j];
		}
		return new SkewFieldWord(product,length);
	}
	
	public String toString(){
		String out = "";
		for(int i = 0; i<word.length; i++){
			out += word[i].toString();
			out += "^";
			out += powers[i];
			if(i < word.length -1){
				out += "*";
			}
		}
		return out;
	}
*/

