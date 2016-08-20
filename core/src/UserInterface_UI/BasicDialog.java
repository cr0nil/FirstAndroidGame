package UserInterface_UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Karol on 20.08.2016.
 */
public class BasicDialog extends Image {
    private PointsLabel label;
    private final static int WIDHT = 320;
    private final static int HEIGHT = 240;

    public BasicDialog() {
        super(new Texture("dialog.png"));

        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);
        this.setPosition(60, 200);
        label= new PointsLabel();
        label.setPosition(100,400);
        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fadeOutDialog();

                return super.touchDown(event, x, y, pointer, button);
            }


        });
    }
    public void initContent(String text){
        label.setText(text);
        this.getStage().addActor(label);
    }
    private void fadeOutDialog() {
        SequenceAction action = Actions.sequence();
        action.addAction(Actions.fadeOut(1.5f));
        action.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                BasicDialog.this.remove();
                label.remove();
                return false;
            }
        });
        this.addAction(action);
        label.addAction(Actions.fadeOut(1.5f));

    }
}