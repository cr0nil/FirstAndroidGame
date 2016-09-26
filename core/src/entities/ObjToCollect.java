package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.firstx.cos.Piersi;

import Service.ScoreService;

/**
 * Created by Karol on 18.09.2016.
 */
public class ObjToCollect extends Image {
private Texture obj;
   public int a =0;
    //size
    private final static int WIDHT = 100;
    private final static int HEIGHT = 120;
    //position
    private int STARTING_X = MathUtils.random(0,400);
    private final static int STARTING_Y = 600;
    //movement
    private int x;
    private Rectangle bounds;

    public ObjToCollect() {
        //obj = new Texture("12.png");
        super(new Texture("dick.png"));
        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
        bounds = new Rectangle(STARTING_X,STARTING_Y,WIDHT,HEIGHT);
    }

public  Piersi game;

    public void gravity() {
        bounds.setPosition(getX(),getY());
        if (getX() < 60 || getX() > 400) {
            x = 55;
        } else if (getX() < 120 || getX() > 340) {
            x = 35;
        } else x = 20;
        if (getX() < 0) {
            setPosition(0, getY());
        }
        if (getX() > Piersi.WIDTH - 90) {
            setPosition(Piersi.WIDTH - 90, getY());
        }
        if (getY() < 0) {
            setPosition(getX(), 0);
        }
        Action back = Actions.parallel(
                Actions.moveBy(0, -5, 0.5f)
        );
        this.addAction(back);
        if(getY()==0){
            remove();
        }

    }

    public void reposition(){
        setPosition(getX(),getY());

    }
    public int ups(){
        a++;
        return a;
    }

    public boolean collidse(Rectangle player){
        return player.overlaps(bounds);

    }

}
