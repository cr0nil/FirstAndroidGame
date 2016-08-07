package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.firstx.cos.Piersi;


/**
 * Created by Karol on 07.08.2016.
 */
public class FlyingObject extends Image {

    public enum FlyingObjectType {
        MONEY, PASSIVE
    }

    public final static String MONEY = "tits.png";

    private final static int WIDHT = 100;
    private final static int HEIGHT = 100;

    private final static int STARTING_X = 1;
    private final static int STARTING_Y = -100;

    private Piersi game;
    private FlyingObjectType type;

    public FlyingObject(FlyingObjectType type, Piersi game) {
        super(new Texture(getTextureString(type)));
        this.type = type;
        this.game = game;

        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                reactOnClick();


                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void reactOnClick() {
        if (FlyingObjectType.MONEY.equals(type)) {
            game.addPoints(50);
//        } else if (FlyingObjectType.PASSIVE.equals(type)) {
//            game.addPassiveIncome();
        }
        FlyingObject.this.remove();
    }

    private static String getTextureString(FlyingObjectType type) {
        if (FlyingObjectType.MONEY.equals(type)) {
            return MONEY;
        }
        // else if (FlyingObjectType.PASSIVE.equals(type)){
        //   return BOOKS;
        //}

        return "";
    }


    public void fly() {
        Action a = Actions.parallel(
                Actions.moveBy(300, 200, 5),
                Actions.rotateBy(360, 5)
        );
        Action c = Actions.run(new Runnable() {
            @Override
            public void run() {
                FlyingObject.this.remove();
            }
        });
        this.addAction(Actions.sequence(a, c));
    }
}