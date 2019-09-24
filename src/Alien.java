import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Alien implements Locatable
{
	private int x, y, s;
	private Image image;

	public Alien(int x, int y, int s)
	{
		this.x = x;
		this.y = y;
		this.s = s;

		try
		{
			image = ImageIO.read(new File("alien.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image, getX(), getY(),40,40,null);
	}
	public void doMove()
	{
		while (this != null)
		{
			
		}
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
