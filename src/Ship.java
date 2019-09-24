import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	private int x, y;

	public Ship(int X, int Y, int s)
	{
		super(X, Y);

		speed = s;
		x = X;
		y = Y;

		try
		{
			image = ImageIO.read(new File("ship.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Frick homie we got " + e.getMessage());
		}
	}

	@Override
	public void setSpeed(int s) {

	}

	@Override
	public int getSpeed() {
		return speed;
	}

	public void draw(Graphics window)
	{
   		window.drawImage(image, getX(), getY(), 80, 80, null);
	}

	@Override
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
}
