package UserInterface_UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Karol on 03.08.2016.
 */
public class PlayerButton extends Button {
    public PlayerButton(final IClickCallback callback) {
        super(new ButtonStyle());
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(480);
        this.setHeight(700);
        this.setX(0);
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

