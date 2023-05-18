import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
public class SkewFieldTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<SkewFieldLetter,Integer> list1 = new HashMap<SkewFieldLetter,Integer>();
		HashMap<SkewFieldWord,Integer> wlist1 = new HashMap<SkewFieldWord,Integer>();

		SkewFieldWord w1;
		
		Random generator = new Random();
		for (int j = 1; j < 2; j++){
			for (int i = 1; i < 2; i++){
				list1.put(new SkewFieldLetter(generator.nextInt(10),generator.nextInt(20)), generator.nextInt(20));
			}
			w1 = new SkewFieldWord(list1);
			wlist1.put(w1, generator.nextInt(20));
		}
		
		SkewFieldSentence s1 = new SkewFieldSentence(wlist1);
//		System.out.println(s1);
		
		HashMap<SkewFieldLetter,Integer> list2 = new HashMap<SkewFieldLetter,Integer>();
		HashMap<SkewFieldWord,Integer> wlist2 = new HashMap<SkewFieldWord,Integer>();

		SkewFieldWord w2;
		
		for (int j = 1; j < 2; j++){
			for (int i = 1; i < 2; i++){
				list2.put(new SkewFieldLetter(generator.nextInt(10),generator.nextInt(20)), generator.nextInt(20));
			}
			w2 = new SkewFieldWord(list1);
			wlist2.put(w2, generator.nextInt(20));
		}
		
		SkewFieldSentence s2 = new SkewFieldSentence(wlist2);
		
		
		final long startime = System.currentTimeMillis();
		long endtime;
		try{
			s1.times(s2);
		} finally{
			endtime = System.currentTimeMillis();
		}
		//System.out.println(endtime-startime);
		HashMap<SkewFieldSentence,Integer> h1 = new HashMap<SkewFieldSentence,Integer>();
		h1.put(s1, 1);
		h1.put(s2, 1);
		h1.put(s1.times(s2), 1);
		SkewFieldPolynomial p1 = new SkewFieldPolynomial(h1);
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(p1.toString());
		System.out.println(p1.getMap().values().toString());
		p1.simplify();
		
		System.out.println(p1.toString());
	//	System.out.println(s2);
		// TODO Auto-generated method stub
		/*HashMap<SkewFieldLetter,Integer> list1 = new HashMap<SkewFieldLetter,Integer>();
		HashMap<SkewFieldLetter,Integer> list2 = new HashMap<SkewFieldLetter,Integer>();
		HashMap<SkewFieldLetter,Integer> list3 = new HashMap<SkewFieldLetter,Integer>();
		HashMap<SkewFieldLetter,Integer> list4 = new HashMap<SkewFieldLetter,Integer>();

		SkewFieldWord w1;
		
		for (int i = 0; i < 2; i++){
			list1.put(new SkewFieldLetter(i,i),new Integer(2));
		}
		
		w1 = new SkewFieldWord(list1);
		
		SkewFieldWord w2;
		
		for (int i = 0; i < 2; i++){
			list2.put(new SkewFieldLetter(i,i),new Integer(3));
		}
		
		w2 = new SkewFieldWord(list2);
		
		SkewFieldWord w3;
		
		for (int i = 0; i < 2; i++){
			list3.put(new SkewFieldLetter(i+1,i-1),new Integer(2));
		}
		
		w3 = new SkewFieldWord(list3);
		
		SkewFieldWord w4;
		
		for (int i = 0; i < 2; i++){
			list4.put(new SkewFieldLetter(i+1,i-1),new Integer(3));
		}
		
		w4 = new SkewFieldWord(list4);
		
		
	/*	SkewFieldLetter nl = new SkewFieldLetter(5,5);
		w1.addletter(nl,5);
		Iterator it = w1.getMap().keySet().iterator(); */
		/*while (it.hasNext()){
			System.out.println(it.next().equals(new SkewFieldLetter(5,5)));
		}*/
		//System.out.println(w1.getMap().containsKey(new SkewFieldLetter(5,5)));
		//System.out.println(w1.getMap().keySet().);
		//System.out.println(w1.getMap().containsKey(new SkewFieldLetter(5,5)));

	/*	
		System.out.println(w1);
		System.out.println(w2);
		System.out.println(w3);
		System.out.println(w4);

		HashMap<SkewFieldWord,Integer> wlist1 = new HashMap<SkewFieldWord,Integer>();
		wlist1.put(w1, new Integer(2));
		wlist1.put(w2, new Integer(3));
		SkewFieldSentence s1 = new SkewFieldSentence(wlist1);
		System.out.println(s1);
		
		HashMap<SkewFieldWord,Integer> wlist2 = new HashMap<SkewFieldWord,Integer>();
		wlist2.put(w3, new Integer(4));
		wlist2.put(w4, new Integer(5));
		SkewFieldSentence s2 = new SkewFieldSentence(wlist2);
		System.out.println(s2);
		
		SkewFieldSentence s3 = s2.times(s1);
		System.out.println("product: " + s3); */
	}

}
