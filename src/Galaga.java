import Sounds.SoundEffect;

import javax.swing.JFrame;
import java.awt.Component;

public class Galaga extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Galaga()
	{
		super("Galaga");
		setSize(WIDTH,HEIGHT);

		OuterSpace theGame = new OuterSpace(WIDTH,HEIGHT);
		((Component)theGame).setFocusable(true);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public int getWidth() {return WIDTH;}
	public int getHeight() {return HEIGHT;}

	public static void main(String[] args) { Galaga run = new Galaga(); }
}