import java.awt.*;
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
    private Ship ship;
    private Alien alienOne;
    private Alien alienTwo;
    private int width, height;

    private Stopwatch stopwatch;

    private Random random = new Random();

    private ArrayList<Ammo> bullets;
    private ArrayList<Alien> aliens;
   
    private boolean[] keys;
    private BufferedImage back;

    public OuterSpace(int WIDTH, int HEIGHT)
    {

        bullets = new ArrayList<>();
        aliens = new ArrayList<>();

        setBackground(Color.black);
        
        keys = new boolean[5];
        width = WIDTH;
        height= HEIGHT;

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
        Graphics2D twoDGraph = (Graphics2D) window;

        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        Graphics graphToBack = back.createGraphics();

        graphToBack.setColor(Color.BLACK);
        graphToBack.fillRect(0, 0, width, height);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("StarFighter ", 25, 50);

        if (aliens.size() == 0 && this.stopwatch == null)
        {
            this.stopwatch = new Stopwatch();
        }
        if (this.stopwatch != null)
        {
            graphToBack.setColor(Color.RED);
            graphToBack.setFont(new Font("TimesRoman", Font.ITALIC, 50));
            graphToBack.drawString("You win! ",300, 400);

            if (this.stopwatch.elapsedTime() > 3) System.exit(0);
        }

	if (keys[0])
	{
	    if (ship.getSpeed() > 0)
	        ship.setSpeed(ship.getSpeed() * -1);

	    ship.move("LEFT");
	}
	if (keys[1])
    {
        if (ship.getSpeed() < 0)
            ship.setSpeed(ship.getSpeed() * -1);

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
        if (ship.canShoot())
            bullets.add(new Ammo(ship.getX() + 25, ship.getY(), ship.getSpeed() * 5));
    }
        ship.draw(graphToBack);

        for (Alien alien: aliens)
        {
            alien.move();
            alien.draw(graphToBack);
        }

		for (int index = 0; index < bullets.size(); index++)
        {
            Ammo bullet = bullets.get(index);

            int x = bullet.getX();
            int y = bullet.getY();

            for (int j =0; j < aliens.size(); j++)
            {
                Alien alien = aliens.get(j);
                if (x <= (alien.getX() + 40) && x >= alien.getX() && y >= alien.getY() && y <= (alien.getY() + 40) || alien.getY() > 1000)
                {
                    bullets.remove(bullet);
                    aliens.remove(alien);
                    if (aliens.size() < 5 && random.nextInt(2) == 0) aliens.add(new Alien(random.nextInt(800), random.nextInt(100), 5));
                }
            }
            bullet.doMove();
            bullet.draw(graphToBack);
        }

        twoDGraph.drawImage(back, null, 0, 0);

    }

    public void keyPressed(KeyEvent e)
    {
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
    }

    public void run()
    {
        try {
            while (true) {
                repaint();
            }
        } catch (Exception e) {
        }
    }
}

