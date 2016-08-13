package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
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
        TITS, PASSIVE
    }

    public final static String TITS = "tits.png";
    public final static String MOON = "moon.png";

    private final static int WIDHT = 100;
    private final static int HEIGHT = 100;

    private final static int STARTING_X_1 = 0;
    private final static int STARTING_X_2 = Piersi.WIDTH;
    private final static int STARTING_Y = 800;
    private int startingX;

    private Piersi game;
    private FlyingObjectType type;

    public FlyingObject(FlyingObjectType type, Piersi game) {
        super(new Texture(getTextureString(type)));
        this.type = type;
        this.game = game;
        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);
        playSpawnSound();
//
        startingX = MathUtils.randomBoolean() ? STARTING_X_1 : STARTING_X_2;
        this.setPosition(startingX, STARTING_Y);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                reactOnClick();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void playSpawnSound() {
        if (FlyingObjectType.TITS.equals(type)){
        game.getSoundService().playBoobsSound();
        }    // wprzypadku kolizji
    }

    private void reactOnClick() {
        if (FlyingObjectType.TITS.equals(type)) {
            game.getScoreService().addPoints(50);
        } else if (FlyingObjectType.PASSIVE.equals(type)) {
            game.getScoreService().addPassiveIncome();
        }
        FlyingObject.this.remove();
    }

    private static String getTextureString(FlyingObjectType type) {
        if (FlyingObjectType.TITS.equals(type)) {
            return TITS;
        } else if (FlyingObjectType.PASSIVE.equals(type)) {
            return MOON;
        }
        return "";
    }

    public void fly() {

        int xSing = 0;
        int randomYef = MathUtils.random(-200, 100);
        float time1 = MathUtils.random(1.7f, 4.5f);
        float time2 = MathUtils.random(0.2f, 1);
        float time3 = MathUtils.random(1.7f, 5);


        if (startingX == STARTING_X_1) {
            xSing = 1;
        } else {
            xSing = -1;
        }
        Action a = Actions.parallel(
                Actions.moveBy(300 * xSing + MathUtils.random(-170, 170), -400 + randomYef, time1),
                Actions.rotateBy(360, time1)
        );
        Action b = MathUtils.randomBoolean() ? Actions.parallel() : Actions.parallel(
                Actions.moveBy(-100 * xSing + MathUtils.random(-70, 70), 70, time2),
                Actions.rotateBy(360, time2)
        );
        Action c = Actions.parallel(
                Actions.moveBy(-250 * xSing + MathUtils.random(-100, 100), -1000, time3),
                Actions.rotateBy(360, time3)
        );
        Action d = Actions.run(new Runnable() {
            @Override
            public void run() {
                FlyingObject.this.remove();
            }
        });
        this.addAction(Actions.sequence(a, b, c, d));
    }
}
