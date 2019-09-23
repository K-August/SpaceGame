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
				setX(getX()-getSpeed());
				break;
			case "RIGHT":
				setX(getX() + getSpeed());
				break;
			case "UP":
				setY(getY() + getSpeed());
				break;
			case "DOWN":
				setY(getY() - getSpeed());
				break;
		}
	}
}