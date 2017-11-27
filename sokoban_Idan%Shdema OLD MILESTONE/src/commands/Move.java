package commands;

import java.util.ListIterator;

import levels.Box;
import levels.Character;
import levels.Level;
import levels.MovableItem;
import levels.Position;

/**
 * The move command, uses Policy to check for valid move, then moves the Char or Char pushing Box.
 * @author שדמה
 *
 */
public class Move implements Command {

	private String dir;
	private Level l;
	private MovableItem mi;
	private char[][] signBoard;
	
	public Move(String dir, Level l, MovableItem mi)
	{
		this.dir = dir;
		this.l = l;
		this.mi = mi;
		signBoard = l.signBoardMaker();
	}
	
	private Position moveTo(MovableItem mi, String dir)
	{
		
		Position p=new Position(mi.getPosition().getX(),mi.getPosition().getY());
		if (dir.equals("down"))
		{
			p.setX(mi.getPosition().getX()+1);
		}
		else if (dir.equals("up"))
		{
			p.setX(mi.getPosition().getX()-1);
		}
		else if (dir.equals("left"))
		{
			p.setY(mi.getPosition().getY()-1);
		}
		else if (dir.equals("right"))
		{
			p.setY(mi.getPosition().getY()+1);
		}
		
		return p;
	}
	
	@Override
	public void execute() {
		
			l.setSteps(l.getSteps()+1);
			
			ListIterator<Character> iterChars = l.getChars().listIterator();
			Character currentChar = iterChars.next(); //the only character for now
			
			ListIterator<Box> iterBoxes = l.getBoxes().listIterator(); 
			boolean found = false; //is there a box to the right from the character
			while (iterBoxes.hasNext() && !found)
			{
				Box temp = iterBoxes.next();
				if (moveTo(currentChar, dir).equals(temp.getPosition()))
						{
							int add = 0;
							found = true;
							MySokobanPolicy msp = new MySokobanPolicy(l);
							if(msp.canMove(temp, moveTo(temp, dir))) //check policy on the box
							{
								if (signBoard[temp.getPosition().getX()][temp.getPosition().getY()]=='%') //box on star
								{
							
									if (signBoard[msp.getP().getX()][msp.getP().getY()]=='o') //box to star
									{}
									else
										add+=1;
									}
								else
								{
									if (signBoard[msp.getP().getX()][msp.getP().getY()]=='o') //box to star
										add-=1;
								}
								
								temp.move(dir);
								l.setNumOfStars(l.getNumOfStars()+add);
								currentChar.move(dir);
							}
						}
			}
			if (!found)
			{
				if (new MySokobanPolicy(l).canMove(currentChar,moveTo(currentChar, dir))) //check policy on character
				{
					currentChar.move(dir);
				}
			}
			
			signBoard = l.signBoardMaker();
		
			if (l.getNumOfStars()==0)
			{
				l.getTimer().stop();
				l.getTimer().getTime();
				l.getTimer().printTime();	
				System.out.println("YOU WON! Congratulations");
			}
		}
	
	//sets and gets

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}

	public MovableItem getMi() {
		return mi;
	}

	public void setMi(MovableItem mi) {
		this.mi = mi;
	}

	public char[][] getSignBoard() {
		return signBoard;
	}

	public void setSignBoard(char[][] signBoard) {
		this.signBoard = signBoard;
	}
	

}
