package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import UserInterface_UI.PlayerButton;

/**
 * Created by Karol on 17.07.2016.
 */
public class Jumper  {
//size
    private final static int WIDHT = 100;
    private final static int HEIGHT = 120;
//position
    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 100;
//movement
    private Vector3 velocity;
    private Vector3 position;
    private static final int GRAVITY = -15;

    public Jumper() {
        super(new Texture("12.png"));

        position= new Vector3(WIDHT, HEIGHT,0);
        velocity=new Vector3(0,0,0);
    }


    public void reactiOnClick() {

       velocity.add(0,GRAVITY,0);//change to (-displacement to left)
        velocity.scl(1);
        velocity.add(velocity.x,velocity.y,0);
        velocity.scl(1/2);

    }

//    public void reactiOnClickRight() {
//
//        int los2 = MathUtils.random(0, 60);
//        Action moveAction1 = Actions.sequence(
//                Actions.moveBy(los2, 15, 0, Interpolation.bounce),
//                Actions.moveBy(-los2, -15, 1, Interpolation.circle));
//        Action rotationAction1 = Actions.sequence(
//                Actions.rotateBy(70, 0.2f),
//                Actions.rotateBy(-140, 0.2f),
//                Actions.rotateBy(70, 0.2f));
//
//        this.addAction(rotationAction1);
//        this.addAction(moveAction1);
//    }


}
