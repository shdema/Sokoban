package levels;

import java.io.Serializable;
import java.util.*;

import levels.Character;

/**
 * Level class, has a board that is array list of array lists, array list of chars and array list of boxes.
 * @author שדמה
 *
 */
public class Level implements Serializable{
	
	//data members
	private ArrayList<ArrayList<Item>> board;
	private ArrayList<Character> chars;
	private ArrayList<Box> boxes;
	
	private int boundRow;//number of columns
	private int boundCol;//number of rows
	
	private Clock timer = new Clock();
	private int steps;
	private int numOfStars;//counts the number of uncovered stars
	
	//c'tors
	public Level()
	{
		board = new ArrayList<ArrayList<Item>>();
		chars = new ArrayList<Character>();
		boxes = new ArrayList<Box>();
		timer = new Clock();
		steps = 0;
		boundRow = 0;
		boundCol = 0;
		numOfStars=0;
		
	}
	
	public Level(Level l) //copy c'tor
	{
		this.board = l.board;
		this.chars = l.chars;
		this.boxes = l.boxes;
		this.timer = l.timer;
		this.steps = l.steps;
		this.boundRow = l.boundRow;
		this.boundCol = l.boundCol;
		this.numOfStars = l.numOfStars;
	}
	

	//gets and sets
	public ArrayList<ArrayList<Item>> getBoard() {
		return board;
	}

	//not for use - just for serial
	public void setBoard(ArrayList<ArrayList<Item>> board) {
		this.board = board;
	}

	public ArrayList<Character> getChars() {
		return chars;
	}

	public void setChars(ArrayList<Character> chars) {
		this.chars = chars;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}

	public Clock getTimer() {
		return timer;
	}

	public void setTimer(Clock timer) {
		this.timer = timer;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}
	
	public int getBoundRow() {
		return boundRow;
	}

	public void setBoundRow(int boundRow) {
		this.boundRow = boundRow;
	}

	public int getBoundCol() {
		return boundCol;
	}

	public void setBoundCol(int boundCol) {
		this.boundCol = boundCol;
	}
	
	public int getNumOfStars() {
		return numOfStars;
	}

	public void setNumOfStars(int numOfStars) {
		this.numOfStars = numOfStars;
	}


	//create a 2d array with object signs and return it
	public char[][] signBoardMaker(){
		
		char signBoard[][] = new char[this.boundCol][this.boundRow];
		for (int i=0;i<this.boundCol;i++)
			for (int j=0;j<this.boundRow;j++)
				signBoard[i][j]=' ';

		//add to the signboard only the walls and stars from board
		ListIterator<ArrayList<Item>> iterCol = this.board.listIterator();

		while (iterCol.hasNext())
		{		
			ListIterator<Item> iterLine = iterCol.next().listIterator();
			while (iterLine.hasNext())
			{
				Item temp = iterLine.next();
				if (temp.getName().equals("Wall"))
					signBoard[temp.getPosition().getX()][temp.getPosition().getY()]='#';
				else if (temp.getName().equals("Star"))
					signBoard[temp.getPosition().getX()][temp.getPosition().getY()]='o';
			}
		}
		
		//add to the signboard only characters and characters on stars
		ListIterator<Character> iterChars = this.chars.listIterator();
		
		while (iterChars.hasNext())
		{
			Character temp = iterChars.next();
			if (signBoard[temp.getPosition().getX()][temp.getPosition().getY()]=='o')//star
				signBoard[temp.getPosition().getX()][temp.getPosition().getY()]='$';//char on star
			else
				signBoard[temp.getPosition().getX()][temp.getPosition().getY()]='A';//char
		}
		
		//add to the signboard only boxes and boxes on stars
		ListIterator<Box> iterBoxes = this.boxes.listIterator();
		
		while (iterBoxes.hasNext())
		{
			Box temp = iterBoxes.next();
			if (signBoard[temp.getPosition().getX()][temp.getPosition().getY()]=='o')//star
				signBoard[temp.getPosition().getX()][temp.getPosition().getY()]='%';//box on star
			else
				signBoard[temp.getPosition().getX()][temp.getPosition().getY()]='@';//box
		}
		
		return signBoard;
	}
	
}
