import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Locatable
{
	//add state variables here
	private int x;
	private int y;

	public MovingThing(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	//leave setSpeed, getSpeed & draw as abstract
	public abstract void setSpeed(int s);
	public abstract int getSpeed();
	public abstract void draw(Graphics window);

	public void move(String direction)
	{
		switch (direction)
		{
			case "LEFT":
				if (canMove(direction))
					setX(getX() - getSpeed());
				break;
			case "RIGHT":
				if (canMove(direction))
					setX(getX() + getSpeed());
				break;
			case "UP":
				if (canMove(direction))
					setY(getY() - getSpeed());
				break;
			case "DOWN":
				if (canMove(direction))
					setY(getY() + getSpeed());
				break;
		}
	}

	private boolean canMove(String direction)
	{
		switch (direction)
		{
			case "LEFT":
				if (getX() - getSpeed() < -20)
					return false;
				break;
			case "RIGHT":
				
				if (getX() + getSpeed() > 725)
					return false;
				break;
			case "UP":
				
				if (getY() - getSpeed() < -15)
					return false;
				break;
			case "DOWN":
				
				if (getY() + getSpeed() > 500)
					return false;
				break;
		}
		return true;
	}
}