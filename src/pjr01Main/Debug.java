package pjr01Main;

import java.util.ArrayList;
import java.util.Random;

public class Debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> test = new ArrayList<>();
		ArrayList<Integer> todisp = new ArrayList<>();
		
		Random r = new Random();
		
		for (int i = 0; i < 10; i++) {
			test.add(new Integer(i));
		}
		System.out.println(test);
		int lim = test.size();
		for (int i =0; i < lim; i++){
			todisp.add(test.remove(r.nextInt(test.size())));
		}
		System.out.println("--");
		System.out.println("test:	" +test);
		System.out.println("todisp: " +todisp);
	}

}
