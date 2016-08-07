package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.StreamUtils;

/**
 * Created by Karol on 07.08.2016.
 */
public class FlyingObject extends Image {

    public final static String TITS = "tits.png";
    private final static int WIDHT = 100;
    private final static int HEIGHT = 100;

    private final static int STARTING_X = 0;
    private final static int STARTING_Y = 800;

    public FlyingObject(String texture) {
        super(new Texture(texture));
        this.setOrigin(WIDHT/2,HEIGHT/2);
        this.setSize(WIDHT,HEIGHT);
        this.setPosition(STARTING_X,STARTING_Y);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("nsdnisd");
                FlyingObject.this.remove();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
    public void fly(){
        Action a = Actions.parallel(
                Actions.moveBy(300,-400,5),
                Actions.rotateBy(360,5)
        );
        Action c = Actions.run(new Runnable() {
            @Override
            public void run() {
                FlyingObject.this.remove();
            }
        });
        this.addAction(Actions.sequence(a,c));
    }
}
