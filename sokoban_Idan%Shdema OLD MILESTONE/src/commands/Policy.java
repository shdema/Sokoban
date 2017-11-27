package commands;

import levels.MovableItem;
import levels.Position;

/**
 * General Policy Interface.
 * @author שדמה
 *
 */
public interface Policy {
	public boolean canMove(MovableItem mi, Position p);
}
