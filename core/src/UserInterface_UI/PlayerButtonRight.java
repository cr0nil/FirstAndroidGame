package UserInterface_UI;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Karol on 10.08.2016.
 */
public class PlayerButtonRight extends Button {
    public PlayerButtonRight(final IClickCallback callback) {
        super(new ButtonStyle());
        init(callback);
    }


    private void init(final IClickCallback callback) {
        this.setWidth(240);
        this.setHeight(700);
        this.setX(240);
        this.setY(0);
        this.setDebug(false);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }

        } );
    }
}
