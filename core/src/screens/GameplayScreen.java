package screens;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.firstx.cos.Piersi;

import UserInterface_UI.IClickCallback;
import UserInterface_UI.PlayerButton;
import UserInterface_UI.PointsLabel;
import UserInterface_UI.RestScoreButton;
import entities.FlyingObject;
import entities.Jumper;

/**
 * Created by Karol on 28.07.2016.
 */
public class GameplayScreen extends AbstractScreen {

    private Image bgImg;
    private Jumper jumper;
    private PlayerButton playerButton;
    private RestScoreButton resetScoreButton;
    private PointsLabel pointsLabel;
    private FlyingObject flyObj;

    public GameplayScreen(Piersi game) {
        super(game);
    }

    @Override
    protected void init() {

        initBgImg();
        initJumper();
        initPlayerButton();
        initPointsLabel();
        initRestScoreButton();
        initFlyObj();

    }

    private void initFlyObj() {
        flyObj = new FlyingObject(FlyingObject.TITS);
        stage.addActor(flyObj);
        flyObj.fly();
    }

    private void initBgImg() {
        bgImg = new Image(new Texture("1222.gif"));
        stage.addActor(bgImg);
    }

    private void initRestScoreButton() {
        resetScoreButton = new RestScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.restGameScore();
            }
        });
        stage.addActor(resetScoreButton);


    }


    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                jumper.reactiOnClick();

                game.addPoint();// zmienic na dodwanie w przypadku kolizji
            }
        });
        stage.addActor(playerButton);


    }


    private void initPointsLabel() {
        pointsLabel = new PointsLabel();
        stage.addActor(pointsLabel);
    }

    private void initJumper() {
        jumper = new Jumper();
        stage.addActor(jumper);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();


        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        pointsLabel.setText("Score :" + game.getPoints());
        stage.act();
    }
}
