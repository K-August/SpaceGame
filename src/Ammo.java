
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Timer;
import javax.imageio.ImageIO;

public class Ammo implements Locatable
{
	private Image image;
	private int x, y, s;

	public Ammo(int x, int y, int s)
	{
		this.x = x;
		this.y = y;
		this.s = s;

		try
		{
			image = ImageIO.read(new File("bullet.png"));
		}
		catch(Exception e)
		{
			System.out.println("Frick homie we got " + e.getMessage());
		}
	}

	public void draw( Graphics window )
	{
		window.drawImage(image, getX(), getY(), 100 , 100, null);
	}


  	public void doMove()
	{
		if (this.y + this.s < 0 || this.y + this.s > 600)
			return;

		this.y -= Math.abs(this.s);
	}

	@Override
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setX(int x)
	{
		this.x = x;
	}

	@Override
	public void setY(int y)
	{
		this.y = y;
	}

	@Override
	public int getX()
	{
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
}
