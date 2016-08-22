package screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.firstx.cos.Piersi;

import Controllers.FlyingObjController;
import Controllers.RandomEventController;
import Service.PassiveIncomeService;
import UserInterface_UI.BasicDialog;
import UserInterface_UI.IClickCallback;
import UserInterface_UI.PlayerButton;
import UserInterface_UI.PlayerButtonRight;
import UserInterface_UI.PointsLabel;
import UserInterface_UI.RestScoreButton;
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
    private PassiveIncomeService passiveIncomeService;
    private BasicDialog dialog;
    private RandomEventController eventController;

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
        initPassivIncomeService();
        initPassivIncomeInfoDialog();
        initRandomEventController();
    }

    @Override
    public void render(SpriteBatch sb) {
        update();

        this.sb.begin();
        stage.draw();
        this.sb.end();
    }

    @Override
    public void pause() {
        super.pause();
        game.getScoreService().saveCurrentGameState();
    }


    private void initRandomEventController() {
        eventController = new RandomEventController(game, stage);
    }

    @Override
    public void update(float dt) {
        pointsLabel.setText("Score :" + game.getScoreService().getPoints());
        stage.act();
    }

    private void initPassivIncomeService() {
        passiveIncomeService = new PassiveIncomeService(game.getScoreService());
        passiveIncomeService.start();

    }

    private void initPassivIncomeInfoDialog() {
        if (passiveIncomeService.getPointsToAdd() > 0) {
            dialog = new BasicDialog();
            dialog.getLabel().setFontScale(1.6f);
            if (passiveIncomeService.getPointsToAdd() > 1000)
                dialog.getLabel().setFontScale(1.5f);
            if (passiveIncomeService.getPointsToAdd() > 10000)
                dialog.getLabel().setFontScale(1.3f);

            dialog.showDialog(stage, "passive income goined: \r\n         " + passiveIncomeService.getPointsToAdd());
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        getCamera().update();
        this.sb.setProjectionMatrix(getCamera().combined);
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
                if (Gdx.input.isTouched() == false) {
                    jumper.reactionBack();
                }
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
