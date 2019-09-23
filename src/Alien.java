import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Alien implements Locatable
{
	private int speed;
	private Image image;

	public Alien(int x, int y, int s)
	{
		//add code

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
   	window.drawImage(image, getX(), getY(),80,80,null);
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
