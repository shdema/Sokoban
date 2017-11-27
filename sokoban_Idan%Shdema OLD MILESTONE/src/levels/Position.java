package levels;

import java.io.Serializable;

/**
 * Holds x,y coordinates.
 * @author שדמה
 *
 */
public class Position implements Serializable{

		private int x;
		private int y;
		
		public Position() {
			x=-1;
			y=-1;
		}
		public Position(int x,int y){
			this.x=x;
			this.y=y;
		}
		public Position(Position p){
			this.x=p.x;
			this.y=p.y;
		}
		
		//oper override
		public boolean equals(Position p)
		{
			return (this.getX()==p.getX() && this.getY()==p.getY());
		}
		
		//gets and sets
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
}
