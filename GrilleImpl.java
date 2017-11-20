package sudoku;

import java.util.Arrays;

public abstract class GrilleImpl implements Grille {
	public int getDimension() {
		int largeur = 500;
		int  hauteur = 100;
		return largeur / hauteur;
	}
	 public  void setvalue(final int x, final int y, final char value) {
	    	int [][] grille = new int[9][9];
			char[] possible = new char[] {'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f'};
			if (x <= 8 && y <= 8){
	    	for (int i=0; i< grille.length; i++) {
	    		for (int j=0; j< grille[i].length; j++) 
	    		if (Arrays.binarySearch(possible, value) >= 0 ) {
	    		grille[x][y] = value;
	    		}else {
	    			throw new IllegalArgumentException("Value n'est pas un caractère autorisé");
	    		}
	    		System.out.println();
	    	}
			}else {
				
				throw new IllegalArgumentException("x ou y n'est pas compris dans la borne 0-8 ");
			}
	    }
	 public final int getvalue(int x, int y){
	    	int [][] grille = new int[9][9];
	    	int value = 0;
			if (x <= 8 && y <= 8){
	    	for (int i=0; i< grille.length; i++) {
	    		for (int j=0; j< grille[i].length; j++) 
	    		value = grille[x][y] ;	
	    	}
	    	}else {
				throw new IllegalArgumentException("x ou y n'est pas compris dans la borne 0-8 ");
			}
			return value;
	    }
		
		public static boolean complete(int x, int y){
		      if(y == 8 ) 
		    	{ x = x + 1; y=0;
		    	} else {  y = y  + 1; }
		    	if (x == 9) { 
		    		return true; 
		    	}
		    	return true;
			}
		public  boolean possible(int x, int y, char value) {
			int [][] grille = new int[9][9];
			char[] possible = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};
			if (x <= 8 && y <= 8) {
		      if (Arrays.binarySearch(possible, value) >= 0){
				  if (grille[x][y] == value) {
				    	 return true;
				  }
			   } else {
	    			throw new IllegalArgumentException("Value n'est pas un caractère autorisé");
	    		}
	    	} else {
			       throw new IllegalArgumentException("x ou y n'est pas compris dans la borne 0-8 "); 
			       }
			 return false;
		}
}
