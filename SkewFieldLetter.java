
public class SkewFieldLetter implements Comparable<SkewFieldLetter>{

	private int type;
	private int subscript;
	public SkewFieldLetter(int t,int s){
		type = t;
		subscript = s;
	}
	
	public int getType(){
		return type;
	}
	
	public int getSubscript(){
		return subscript;
	}
	
	public boolean equals(Object o){
		if(o instanceof SkewFieldLetter){
			SkewFieldLetter otherletter = (SkewFieldLetter) o;
			return ((type == otherletter.getType()) &&(subscript == otherletter.getSubscript()));
		}
		else{
			return this == o;
		}
	}
	
	public int hashCode(){
		return type*1000+subscript;
	}
	
	public SkewFieldLetter changeSub(int d){
		return new SkewFieldLetter(type, subscript + d);
	}
	
	public String toString(){
		return (((char)(type+97)) + "_" + subscript);
	}
	
	public int compareTo(SkewFieldLetter other){
		if (type != other.getType()){
			return type - other.getType();
		}
		else{
			return subscript - other.getSubscript();
		}
	}
}