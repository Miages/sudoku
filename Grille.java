package sudoku;

public interface Grille {
	static final char EMPTY = '@';
	static final char[] possible = new char[] {'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f'};
    public int getDimension();
    public void setvalue(int x, int y, char value) throws IllegalArgumentException;
    public int getvalue(int x, int y) throws IllegalArgumentException;
    public boolean complete();
    public boolean possible(int x, int y, char value) throws IllegalArgumentException;
}
