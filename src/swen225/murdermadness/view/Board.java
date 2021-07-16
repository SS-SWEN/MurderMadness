package swen225.murdermadness.view;


public class Board {
	
	public static String layout =
	        ". . . . . . . . . . . . . . . . . . . . . . . ." + // 00
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 01
			". . H H H H H . . . . . . . . . . M M M M M . ." + // 02
			". . H o o o o . . . . . . . . . . M o o o M . ." + // 03
			". . H o o o H . . . . . . . . . . M o o o M . ." + // 04
			". . H o o o H . . . . G G . . . . o o o o M . ." + // 05
			". . H H H o H . . . . G G . . . . M M M o M . ." + // 06
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 07
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 08
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 09
			". . . . . . . . . V V o V V V . . . . . . . . ." + // 10
			". . . . . G G . . o o o o o o . . G G . . . . ." + // 11
			". . . . . G G . . V o o o o V . . G G . . . . ." + // 12
			". . . . . . . . . V V o V V V . . . . . . . . ." + // 13
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 14
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 15
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 16
			". . C o C C C . . . . G G . . . . P o P P P . ." + // 17
			". . C o o o o . . . . G G . . . . P o o o P . ." + // 18
			". . C o o o C . . . . . . . . . . P o o o P . ." + // 19
			". . C o o o C . . . . . . . . . . o o o o P . ." + // 20
			". . C C C C C . . . . . . . . . . P P P P P . ." + // 21
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 22
			". . . . . . . . . . . . . . . . . . . . . . . ." ; // 23
   


	public void show() {
		layout = layout.replaceAll(" ", "");
		layout = layout.replaceAll("o", " ");
		int counter = 0;
		
		for(int i =0; i < 24; i++) {
		    for (int j = 0 ;j < 24 ; j++) {
		        System.out.print(layout.charAt(counter));   
		        counter++;
		    }
		    System.out.println ();
		}
	}
}
