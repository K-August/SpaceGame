import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Alien extends MovingThing implements Locatable
{
	private int x, y, s;
	private Image image;

	public Alien(int x, int y, int s)
	{
		super(x, y);

		this.x = x;
		this.y = y;
		this.s = s;

		try
		{
			image = ImageIO.read(new File("src\\Images\\plankton.png"));
		}
		catch(Exception e)
		{
		}
	}

	@Override
	public void setSpeed(int s) {
		this.s = s;
	}

	@Override
	public int getSpeed() {
		return Math.abs(this.s);
	}

	public void draw(Graphics window )
	{
   	window.drawImage(image, getX(), getY(),80,80,null);
	}

	public void move()
	{
		if (this.x + this.s > 720 || this.x + this.s < 0)
		{
			this.s *= -1;
		}
		if (this.s > 0) this.move("RIGHT");
		else this.move("LEFT");
	}

	@Override
	public void setPos(int x, int y)
	{
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
	public int getY()
	{
		return this.y;
	}
}
