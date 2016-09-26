package UserInterface_UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import Service.PassiveIncomeService;
import Service.ScoreService;

/**
 * Created by Karol on 20.08.2016.
 */
public class BasicDialog extends Image {
    private PointsLabel label;
    private PassiveIncomeService passiveIncomeService;
    private final static int WIDHT = 280;
    private final static int HEIGHT = 200;

    public PointsLabel getLabel() {
        return label;
    }

    public BasicDialog() {
        super(new Texture("dialog.png"));

        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);
        this.setPosition(90, 250);
        label = new PointsLabel();
        label.setPosition(115, 370);
      fadeOutDialog();
    }


    public void showDialog(Stage stage, String text) {
        stage.addActor(this);
        label.setText(text);
        this.getStage().addActor(label);

    }

    private void fadeOutDialog() {
        SequenceAction action = Actions.sequence();
        action.addAction(Actions.fadeOut(2));
        action.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                BasicDialog.this.remove();
                label.remove();
                return false;
            }
        });
        this.addAction(action);
        label.addAction(Actions.fadeOut(2));

    }
}