package mainHanShu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args){
		/*
		 *  temp is used to temporarily store read eachline input 
		 */
		String temp = null;
		
		/*
		 *  To read input
		 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			 temp = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * get the number of all data centers
		 */
		int num = Integer.parseInt(temp);
		/*
		 * A list to store current situation of all data centers
		 */
		ArrayList<ArrayList<Integer>> allDC = new ArrayList<ArrayList<Integer>>();
		/*
		 * To store different types of data, and keep record where they are 
		 */
		HashMap<Integer, Integer> alldata = new HashMap<Integer,Integer>();
		
		/*
		 * begin to read every line information and store them into hashMap and list
		 */
		for(int i = 0 ; i<num ;i++){
			try {
				temp = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			StringTokenizer st = new StringTokenizer(temp);
			ArrayList<Integer> dc = new ArrayList<Integer>();
			
			/*
			 * Because the first num of each is not the real data, it is the number of data this center has;
			 * It is useless, so we should use this boolean var to filter this number
			 */
			boolean isfirstone = true;
			
			while(st.hasMoreElements()){
				int data = Integer.parseInt(st.nextToken());
				/*
				 * filter the first number
				 */
				if(!isfirstone){
					dc.add(data);
					alldata.put(data, i+1);
				}
				isfirstone = false;
			}
			allDC.add(dc);
		}
		/*
		 * Now we have all data in hashMap and all current situation in list, 
		 * what we need to do is to compare each data center with hashMap, find the absence one and add it.
		 */
		for(int i = 0 ; i < allDC.size(); i++){
			Iterator<Entry<Integer, Integer>> it = alldata.entrySet().iterator();
			while(it.hasNext()){
				Entry<Integer, Integer> entry = it.next();
				if(isAbsence(entry.getKey(),allDC.get(i)))	
					System.out.println(entry.getKey() + " " + entry.getValue() + " "+ (i+1));
			}
		}
		
		System.out.println("done");
	}
	/**
	 * this function is used to check whether x is in list or not
	 * @param x is the integer needs to be checked
	 * @param list is the ArrayList contains mutiple integer
	 * @return true says x is not in list; false says x is in list
	 */
	private static boolean isAbsence(int x, ArrayList<Integer> list){
		
		for(int i = 0; i<list.size(); i++){
			if(list.get(i) == x)
				return false;
		}
		return true;
	}
}
