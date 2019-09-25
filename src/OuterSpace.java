import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OuterSpace extends JPanel implements KeyListener, ActionListener
{

    //NOTICE THESE ARE DECLARATIONS ONLY!!!! Dont forget to initalize....
    private Ship ship;
    private Alien alienOne;
    private Alien alienTwo;
    private int width, height;

    private ArrayList<Ammo> bullets;
    private ArrayList<Alien> aliens;
    //STUDENTS - you will need to add Arraylist for Alien
   //STUDENTS - you will need to add Arraylist for Ammo
   
    private boolean[] keys;
    private BufferedImage back;

    public OuterSpace(int WIDTH, int HEIGHT)
    {
        Random random = new Random();
        bullets = new ArrayList<>();

        setBackground(Color.black);
        
        keys = new boolean[5];
        width = WIDTH;
        height= HEIGHT;
        //STUDENTS  - initialize your state variables here
        //like ship, aliens, ammo , etc.
        ship = new Ship(width / 4, height / 4, 3);

        aliens.add(new Alien(random.nextInt(800), random.nextInt(100), 5));
        aliens.add(new Alien(random.nextInt(800), random.nextInt(100), 5));
        
        this.addKeyListener(this);

        Timer timer = new Timer(1000 / 60, this);
        timer.start();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        //NO TOUCHING
        step();
    }

    public void step()
    {
        //NO TOUCHING
        repaint();
    }

    public void paintComponent(Graphics window)
    {
        int i = 0;
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        graphToBack.setColor(Color.BLACK);
        graphToBack.fillRect(0, 0, width, height);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("StarFighter ", 25, 50);

        
        //STUDENTS ADD CODE TO MAKE SHIP MOVE RIGHT, UP, DOWN
	if (keys[0])
	{
	    ship.move("LEFT");
	}
	if (keys[1])
    {
        ship.move("RIGHT");
    }
	if (keys[2])
	{
	    ship.move("UP");
	}
	if (keys[3])
	{
	    ship.move("DOWN");
	}
	if (keys[4])
    {
        bullets.add(new Ammo(ship.getX(), ship.getY(), ship.getSpeed() * 5));
    }


	//STUDENTS ADD CODE TO MAKE ALIENS MOVE

	//STUDENTS ADD CODE TO MAKE SHIP SHOOT
	
        
        //STUDENTS ADD CODE TO DRAW STUFF  - use graphToBack as the Graphics parameter
        ship.draw(graphToBack);

	    for (Alien alien: aliens)
        {
            alien.doMove();
            alien.draw(graphToBack);
        }

		for (Ammo bullet: bullets)
        {
            for (Alien alien: aliens)
            {
                int max = (alien.getX() + 40);
                int min = alien.getX();
            }
            bullet.doMove();
            bullet.draw(graphToBack);
        }

        //STUDENTS ADD CODE for collision detection



        twoDGraph.drawImage(back, null, 0, 0);

     
    }

    public void keyPressed(KeyEvent e)
    {
        //NO TOUCHING - SERIOUSLY DONT CHANGE THIS CODE
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e)
    {
        //NO TOUCHING
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e)
    {
//NO TOUCHING
    }

    public void run()
    {
        //NO TOUCHING
        try {
            while (true) {
                repaint();
                //Thread.currentThread().sleep(1);
            }
        } catch (Exception e) {
        }
    }
}

