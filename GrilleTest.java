package sudoku;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class GrilleTest {
	/**
	 * @retourne largeur/hauteur de la grille
	 */
    public  int getDimension(int Largeur, int Hauteur) {
    return Largeur/Hauteur;
    }
	@Test
	public void testGetDimension() {
		assertEquals(5,getDimension(500,100));
	}
	/**
     * Affecte une valeur dans la grille
     * 
     * @param x       position x dans la grille
     * @param y       position y dans la grille
     * @param value   valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si la valeur est interdite aux vues des autres valeurs de la grille
     * @throw IllegalArgumentException si value n'est pas un caractere autorise ('1',...,'9')
     * 
     */
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
    			throw new IllegalArgumentException("Value n'est pas un caract�re autoris�");
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
	/**
     * Recupere une valeur de la grille 
     * 
     * @param x position x dans la grille
     * @param y position y dans la grille 
     * @return valeur dans la case x,y
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     */
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
	/**
     * Test si une grille est termin�e
     * 
     * @return true si la grille est complete
     */
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
	 /**
     * Test si une valeur est possible dans la grille par rapport a ce qu'elle contient d�j� 
     *
     * @param x position x dans la grille 
     * @param y position y dans la grille
     * @param value valeur a mettre dans la case
     * @Throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @Throw IllegalArgumentException si value n'est pas un caract�re autorise ('1',...,'9',...)
     */
	public static boolean possible(int x, int y, char value) {
		int [][] grille = new int[9][9];
		char[] possible = new char[] {'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f'};
		if (x <= 8 && y <= 8){
	      if (Arrays.binarySearch(possible, value) >= 0 ) {
			  if(grille[x][y] == value) {
			    	 return true;
			  }
		   }else {
    			throw new IllegalArgumentException("Value n'est pas un caract�re autoris�");
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
