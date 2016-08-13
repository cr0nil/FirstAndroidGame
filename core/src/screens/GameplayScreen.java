package screens;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.firstx.cos.Piersi;

import Controllers.FlyingObjController;
import UserInterface_UI.IClickCallback;
import UserInterface_UI.PlayerButton;
import UserInterface_UI.PlayerButtonRight;
import UserInterface_UI.PointsLabel;
import UserInterface_UI.RestScoreButton;
import entities.FlyingObject;
import entities.FlyingObject.FlyingObjectType;
import entities.Jumper;

/**
 * Created by Karol on 28.07.2016.
 */
public class GameplayScreen extends AbstractScreen {

    private Image bgImg;
    private Jumper jumper;
    private PlayerButton playerButton;
    private PlayerButtonRight playerButtonRight;
    private RestScoreButton resetScoreButton;
    private PointsLabel pointsLabel;
    private FlyingObjController flyObj;

    public GameplayScreen(Piersi game) {
        super(game);
    }

    @Override
    protected void init() {

        initBgImg();
        initJumper();
        initPlayerButton();
        initPlayerButtonRight();
        initPointsLabel();
        initRestScoreButton();
        initFlyObj();
        startTheMusic();
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
        pointsLabel.setText("Score :" + game.getScoreService().getPoints());
        stage.act();
    }

    private void startTheMusic() {
        game.getSoundService().startPlayingMusic(true);
    }

    private void initPlayerButtonRight() {
        playerButtonRight = new PlayerButtonRight(new IClickCallback() {
            @Override
            public void onClick() {
                jumper.reactiOnClickRight();

                game.getScoreService().addPoint();// zmienic na dodwanie w przypadku kolizji
            }
        });
        stage.addActor(playerButtonRight);
    }

    private void initFlyObj() {
        flyObj = new FlyingObjController(game, stage);
    }

    private void initBgImg() {
        bgImg = new Image(new Texture("1222.gif"));
        stage.addActor(bgImg);
    }

    private void initRestScoreButton() {
        resetScoreButton = new RestScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.getScoreService().restGameScore();
            }
        });
        stage.addActor(resetScoreButton);
    }

    private void initPointsLabel() {
        pointsLabel = new PointsLabel();
        stage.addActor(pointsLabel);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                jumper.reactiOnClick();

                game.getScoreService().addPoint();// zmienic na dodwanie w przypadku kolizji
            }
        });
        stage.addActor(playerButton);

    }

    private void initJumper() {
        jumper = new Jumper();
        stage.addActor(jumper);
    }

}
