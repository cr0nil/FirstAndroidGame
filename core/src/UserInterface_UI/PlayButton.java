package UserInterface_UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.firstx.cos.Piersi;

/**
 * Created by Karol on 22.08.2016.
 */
public class PlayButton extends Button {
    public PlayButton(final IClickCallback callback) {
        super(preparePlayButtonstyle1());
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(80);
        this.setHeight(80);
        this.setX(Piersi.WIDTH/2);
        this.setY(Piersi.HEIGHT/2);
        // this.setDebug(true);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
    public static ButtonStyle preparePlayButtonstyle1(){
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("ui-blue.atlas"));
        Skin skin = new Skin(atlas);
        ButtonStyle buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable("icon_play");

        return buttonStyle;
    }
}
