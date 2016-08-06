package UserInterface_UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
/**
 * Created by Karol on 05.08.2016.
 */
public class RestScoreButton extends Button {
    public RestScoreButton(final IClickCallback callback) {
        super(prepareRestButtonstyle());
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(80);
        this.setHeight(80);
        this.setX(0);
        this.setY(620);
       // this.setDebug(true);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
    public static ButtonStyle prepareRestButtonstyle(){
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("ui-blue.atlas"));
        Skin skin = new Skin(atlas);
        ButtonStyle buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable("button_02");
        buttonStyle.down = skin.getDrawable("button_03");

        return buttonStyle;
    }

}
