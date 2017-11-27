package commands;

import levels.MovableItem;
import levels.Position;

/**
 * General Policy Interface.
 * @author ����
 *
 */
public interface Policy {
	public boolean canMove(MovableItem mi, Position p);
}
