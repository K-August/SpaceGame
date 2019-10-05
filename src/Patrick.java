import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Patrick extends MovingThing
{
    private int x, y, s;
    private Image image;

    public Patrick(int x, int y) {
        super(x, y);

        this.x = x;
        this.y = y;
        this.s = 1;

        try
        {
            image = ImageIO.read(new File("src\\Images\\patrick.png"));
        }
        catch(Exception ignored)
        {
        }
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }

    private boolean isUsable = true;

    @Override
    public void setSpeed(int s) {
        this.s = s;
    }

    @Override
    public int getSpeed() {
        return this.s;
    }

    @Override
    public void draw(Graphics window) {
        window.drawImage(image, getX(), getY(),200,200,null);
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
