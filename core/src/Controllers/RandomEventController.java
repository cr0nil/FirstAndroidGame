package Controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.firstx.cos.Piersi;

import Service.PassiveIncomeService;
import UserInterface_UI.BasicDialog;

/**
 * Created by Karol on 21.08.2016.
 */
public class RandomEventController {

    private static final int RANDOM_TICK_INTERVAL = 5;
    private Piersi game;
    private Stage stage;
    public RandomEventController(Piersi game, Stage stage) {
        this.game = game;
        this.stage = stage;
        init();
    }

    private void init() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if (MathUtils.randomBoolean()) {
                    triggerRandomEvent();
                }
            }


        }, RANDOM_TICK_INTERVAL, RANDOM_TICK_INTERVAL);
    }

    private void triggerRandomEvent() {
        int randomNumber = MathUtils.random(1, 2);
        switch (randomNumber) {
            case 1:
                moneyEvent();
                break;
            case 2:
                loseMoneyEvent();
                break;
            case 3:
                gainPassiveIncome();
                break;
            default:
                break;
        }
    }

    private void tiggerDialog(String text){
        BasicDialog basicDialog = new BasicDialog();
        basicDialog.getLabel().setFontScale(1.75f);
        basicDialog.showDialog(stage,text);
    }
    private void gainPassiveIncome() {
        game.getScoreService().getPasssivIncome();
        tiggerDialog(" You gained passive income");
    }

    private void loseMoneyEvent() {
        int x = MathUtils.random(20,120);
        game.getScoreService().addPoints(-x);
        tiggerDialog(" You lose points \n"+"          "+x);
    }

    private void moneyEvent() {
        int x = MathUtils.random(20,120);
        game.getScoreService().addPoints(x);
        tiggerDialog("   FREE points");
    }

}
