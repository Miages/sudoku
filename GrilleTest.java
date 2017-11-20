package sudoku;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class GrilleTest {
    public  int getDimension(int Largeur, int Hauteur) {
    return Largeur/Hauteur;
    }
	@Test
	public void testGetDimension() {
		assertEquals(5,getDimension(500,100));
	}
    public  void setvalue(int x, int y, char value){
    	int [][] grille = new int[9][9];
		char[] possible = new char[] {'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f'};
		if (x <= 8 && y <= 8){
    	for (int i=0; i< grille.length; i++) {
    		for (int j=0; j< grille[i].length; j++) {
    			 //System.out.print(grille[i][j]+ " ");
    			} 
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
	
	@Test
	public  void testSetvalue() {
		setvalue(5,5,'5');
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
	@Test
	public final void testGetvalue() {
		getvalue(3,7);
	}
	public static boolean complete(int x, int y){
      if(y == 8 ) 
    	{ x = x+1; y=0;
    	} else{  y = y+1; }
    	if (x == 9) { 
    		return true; 
    	}
    	return true;
	}
	@Test
	public final void testComplete() {
		complete(8,9);
	}
	public static boolean possible(int x, int y, char value) {
		int [][] grille = new int[9][9];
		char[] possible = new char[] {'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f'};
		if (x <= 8 && y <= 8){
	      if (Arrays.binarySearch(possible, value) >= 0 ) {
			  if(grille[x][y] == value) {
			    	 return true;
			  }
		   }else {
    			throw new IllegalArgumentException("Value n'est pas un caractère autorisé");
    		}
    	}else {
		        throw new IllegalArgumentException("x ou y n'est pas compris dans la borne 0-8 ");
		}
		 return false;
	}
	@Test
	public final void testPossible() {
		possible(0,8,'2');
	}

}
