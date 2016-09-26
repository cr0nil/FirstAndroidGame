package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.firstx.cos.Piersi;


/**
 * Created by Karol on 17.07.2016.
 */
public class Jumper extends Image {
    //size
    private final static int WIDHT = 100;
    private final static int HEIGHT = 120;
    //position
    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 100;
    //movement
    private int x;
    private Rectangle boudns;

    public Jumper() {
        super(new Texture("kwach.png"));
        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
        boudns = new Rectangle(STARTING_X,STARTING_Y,WIDHT,HEIGHT);

    }

    public void reactiOnClick() {

        // int los1 = MathUtils.random(0, 60);
        Action moveAction = Actions.sequence(
                Actions.moveBy(-x, 105, 0, Interpolation.bounce));
        //  Actions.moveBy(los1, -15, 1, Interpolation.circle));
        Action rotationAction = Actions.sequence(
                Actions.rotateBy(70, 0.2f),
                Actions.rotateBy(-140, 0.2f),
                Actions.rotateBy(70, 0.2f));
        this.addAction(rotationAction);
        this.addAction(moveAction);
    }

    public void reactiOnClickRight() {

        //  int los2 = MathUtils.random(0, 60);

        Action moveAction1 = Actions.sequence(
                Actions.moveBy(x, 105, 0, Interpolation.bounce));
        //   Actions.moveBy(-los2, -15, 1, Interpolation.circle));
        Action rotationAction1 = Actions.sequence(
                Actions.rotateBy(70, 0.2f),
                Actions.rotateBy(-140, 0.2f),
                Actions.rotateBy(70, 0.2f));
        this.addAction(rotationAction1);
        this.addAction(moveAction1);
    }

    public void gravity() {
        boudns.setPosition(getX(),getY());
        if (getX() < 60 || getX() > 340) {
            x = 75;
        } else if (getX() < 110 || getX() > 240) {
            x = 55;
        } else x = 40;
        if(getY()>650){
            setPosition(getX(),600);
        }
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
    }
    public Rectangle getBoudns(){
        return boudns;
    }
}
