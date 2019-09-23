import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship(int x, int y, int s)
	{
		super(x, y);

		speed = s;

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
		return 0;
	}

	public void draw(Graphics window)
	{
   		window.drawImage(image,getX(),getY(),80,80,null);
	}

	@Override
	public void setPos(int x, int y) {

	}

	@Override
	public void setX(int x) {

	}

	@Override
	public void setY(int y) {

	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}
}
