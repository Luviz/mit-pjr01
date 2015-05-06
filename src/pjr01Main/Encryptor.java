package pjr01Main;

import java.util.ArrayList;
import java.util.Random;

/**
 * I have had this laying around for a while. for something like this!
 * 
 * @author Bardia
 *
 */
public class Encryptor {
	private ArrayList<Integer> alf = new ArrayList<Integer>();

	public Encryptor() {
		setAlf("0");
	}

	/**
	 * setAlf(@param seed);
	 */
	public Encryptor(String seed) {
		setAlf(seed);
	}

	/**
	 * Sums up the (int)char and set as seed
	 * 
	 * @param seed
	 */

	public void setAlf(String seed) {
		int iSeed = 0;
		char cSeed[] = seed.toCharArray();
		for (char cs : cSeed) {
			iSeed += (int) cs;
		}
		// System.out.println("iSeed: "+ iSeed); //debug

		alf.clear();
		alf.add(0, 0);
		Random random = new Random(iSeed);
		int rand = 0;
		// System.out.println("start");
		for (int i = 1; i < 95; i++) {
			while (alf.contains(new Integer(rand))) {
				rand = random.nextInt(94) + 1;
			}
			alf.add(rand);
			// System.out.print("_");//debug
		}
	}

	public String encrypt(String in) {
		char a[] = in.toCharArray();
		int j = 0;
		int pos;
		for (char i : a) {
			// System.out.println((int)i);
			if ((int) i > 32) {
				pos = (int) i - 32;
				// System.out.println((int)i-32+"\t"+i+"\t"+(char)(alf.get(pos).intValue()+32));
				// //debug
				a[j++] = (char) (alf.get(pos).intValue() + 32);
			} else {
				// System.out.println("else");
				a[j++] = i;
			}
		}

		String out = new String(a);
		return out;
	}

	public String decrypt(String in) {
		char a[] = in.toCharArray();
		int j = 0, pos;
		for (char i : a) {
			if ((int) i > 32) {
				pos = (int) i - 32;
				a[j++] = (char) (alf.indexOf(pos) + 32);
			} else {
				a[j++] = i;
			}
		}

		String out = new String(a);
		return out;
	}

	public void debugdisp() {
		int i = 0;
		for (int a : alf) {
			System.out.println(i++ + "\t" + (char) (a + 32) + "\t"
					+ (char) (i + 31) + "\t|");

		}
		System.out.println("\n");
	}

}
