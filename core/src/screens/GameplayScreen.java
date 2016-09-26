package screens;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
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
import entities.ObjToCollect;

/**
 * Created by Karol on 28.07.2016.
 */
public class GameplayScreen extends AbstractScreen {

    private Image bgImg;
    private Jumper jumper;
    private ObjToCollect objToCollect;
    private PlayerButton playerButton;
    private PlayerButtonRight playerButtonRight;
    private RestScoreButton resetScoreButton;
    private PointsLabel pointsLabel;
    private FlyingObjController flyObj;
    private PassiveIncomeService passiveIncomeService;
    private BasicDialog dialog;
    private RandomEventController eventController;
    private Array<ObjToCollect> objToCollects;
    public int spawnTime;
    public int licz = 1;

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
        initObjToCollect();
        initAddObjToCollect();
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    @Override
    public void pause() {
        super.pause();
        game.getScoreService().saveCurrentGameState();
    }

    private void initAddObjToCollect() {

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        randomizeSpawnTime();
                        objToCollect = new ObjToCollect();
                        // System.out.println("dodano "+licz);
                        stage.addActor(objToCollect);
                        //  licz++;
                    }


                }, spawnTime);
            }
        }, 2, 7);
    }

    private void randomizeSpawnTime() {
        spawnTime = MathUtils.random(5, 9);
        // spawnTime1 = MathUtils.random(3,6);
    }


    private void initRandomEventController() {
        eventController = new RandomEventController(game, stage);
    }

    public void update() {
        pointsLabel.setText("Score :" + game.getScoreService().getPoints());
        if (objToCollect.collidse(jumper.getBoudns())) {

if(objToCollect.ups()==1){
    game.getScoreService().addPoints(-500);
}
            objToCollect.remove();
        }
        stage.act();
        jumper.gravity();
        objToCollect.gravity();
        objToCollect.reposition();
    }

    private void initPassivIncomeService() {
        passiveIncomeService = new PassiveIncomeService(game.getScoreService());
        passiveIncomeService.start();

    }

    private void initPassivIncomeInfoDialog() {
        if (passiveIncomeService.getPointsToAdd() > 0) {
            dialog = new BasicDialog();
            dialog.getLabel().setFontScale(1.45f);
            if (passiveIncomeService.getPointsToAdd() > 1000)
                dialog.getLabel().setFontScale(1.38f);
            if (passiveIncomeService.getPointsToAdd() > 10000)
                dialog.getLabel().setFontScale(1.275f);

            dialog.showDialog(stage, " passive income goined: \r\n         " + passiveIncomeService.getPointsToAdd());
        }
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

    private void
    initObjToCollect() {
        objToCollect = new ObjToCollect();

        // stage.addActor(objToCollect);
    }


}
