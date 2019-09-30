import javafx.application.Platform;
import javafx.scene.paint.Stop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.TimerTask;

import static java.lang.System.out;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	private int x, y;
	private Stopwatch stopwatch;

	public Ship(int x, int y, int s)
	{
		super(x, y);

		speed = s;
		this.x = x;
		this.y = y;

		this.stopwatch = new Stopwatch();

		try
		{
			image = ImageIO.read(new File("ship.jpg"));
		}
		catch(Exception e)
		{
			out.println("Frick homie we got " + e.getMessage());
		}
	}

	public boolean canShoot()
	{
		if (this.stopwatch.elapsedTime() > .75)
		{
			this.onShoot();
			return true;
		}

		return false;
	}

	public void onShoot()
	{
		this.stopwatch.start();
	}

	@Override
	public void setSpeed(int s)
	{
		this.speed = s;
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
