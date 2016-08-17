package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import UserInterface_UI.PlayerButton;

/**
 * Created by Karol on 17.07.2016.
 */
public class Jumper extends Image {

    private final static int WIDHT = 100;
    private final static int HEIGHT = 120;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 100;

    public Jumper() {
        super(new Texture("12.png"));

        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
    }


    public void reactiOnClick() {

       // int los = MathUtils.random(-60, 0);
        Action moveAction = Actions.sequence(
                Actions.moveBy(-20, 15, 0, Interpolation.bounce),
                Actions.moveBy(0, 0, 1)
        );
        Action rotationAction = Actions.sequence(
                Actions.rotateBy(70, 0.2f),
                Actions.rotateBy(-140, 0.2f),
                Actions.rotateBy(70, 0.2f));

        this.addAction(rotationAction);
        this.addAction(moveAction);

    }

    public void reactiOnClickRight() {

        int los2 = MathUtils.random(0, 60);
        Action moveAction1 = Actions.sequence(
                Actions.moveBy(los2, 15, 0, Interpolation.bounce),
                Actions.moveBy(-los2, -15, 1, Interpolation.circle));
        Action rotationAction1 = Actions.sequence(
                Actions.rotateBy(70, 0.2f),
                Actions.rotateBy(-140, 0.2f),
                Actions.rotateBy(70, 0.2f));

        this.addAction(rotationAction1);
        this.addAction(moveAction1);
    }

    public void reactionBack() {

        Action backToStartPosition = Actions.parallel(
                Actions.moveTo(STARTING_X, STARTING_Y, 2)
        );
        this.addAction(backToStartPosition);
    }
}
