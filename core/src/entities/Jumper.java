package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Karol on 17.07.2016.
 */
public class Jumper extends Image {

    private final static int WIDHT = 100;
    private final static int HEIGHT = 120;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 200;

    public Jumper() {
        super(new Texture("12.png"));

        this.setOrigin(WIDHT/2,HEIGHT/2);
        this.setSize(WIDHT,HEIGHT);
        this.setPosition(STARTING_X,STARTING_Y);
    }


    public void reactiOnClick() {

        int los = MathUtils.random(-60,60);
        Action moveAction = Actions.sequence(
                Actions.moveBy(los,10,0, Interpolation.bounce),
                Actions.moveBy(-los,-10,2,Interpolation.circle) );
        Action rotationAction= Actions.sequence(
                Actions.rotateBy(70,0.2f),
                Actions.rotateBy(-140,0.2f),
                Actions.rotateBy(70,0.2f));

        this.addAction(rotationAction);
        this.addAction(moveAction);
    }
}
