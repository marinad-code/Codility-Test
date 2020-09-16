package mytests;

import java.util.Scanner;
import java.util.Vector;

public class Test6_Vector {

	public static void main(String[] args) {
		String s = "tekarch";
		Vector<Character> v = new Vector<Character>(s.length());
		
		for(int i = 0; i<s.length();i++)
		{
			v.add(i,s.charAt(i));
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the positive integer number " );
		int num = Integer.parseInt(sc.nextLine());
		Vector <Character> v1 = new Vector<Character>(num);
		if(num  >= 0) {
			int to = 3 + num;
			int to_remove = 5 + num;
			for (int i= 3 ; i< to ; i++) {
				v.add(i,'z');
			}
		
			System.out.println("original vector " + v);
			for (int i= 5 ; i<= to_remove ; i++) {
				char tmp = v.get(i);
				v1.add(tmp);
				
			}
			
			//System.out.println(v1);
		}
		for(int i=0; i<v1.size(); i++)
		{
			v.removeElement(v1.get(i));
		}
		System.out.println("Vector after add and remove  " + v);
		sc.close();
	}

}
