package Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


/**
 * Created by Karol on 13.08.2016.
 */
public class ScoreService {
    public final static String GAME_PREFS = "com.prefsfirstx.cos.pref";
    public final static String GAME_SCORE = "com.prefsfirstx.cos.pref.score";
    public final static String GAME_PASSIV_INCOME  = "com.prefsfirstx.cos.pref.passivincome";

    private Preferences prefs;
    private int points;
    private int passsivIncome;

    public ScoreService(){
        init();
    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
      loadPassieIncome();
    }

    private void loadPassieIncome() {
        passsivIncome = prefs.getInteger(GAME_PASSIV_INCOME);
    }

    private void loadScore() {
        points = prefs.getInteger(GAME_SCORE);
    }


    public void addPoints(int pointsToAdd) {
        points += pointsToAdd;
        updateScoreAndPassiveIncomeInPrefs();
    }

    public void addPoint() {
        points++;
        updateScoreAndPassiveIncomeInPrefs();
    }


    public void restGameScore() {
        points = 0;
        passsivIncome = 0;
        updateScoreAndPassiveIncomeInPrefs();
    }

    private void updateScoreAndPassiveIncomeInPrefs() {
        prefs.putInteger(GAME_SCORE, points);
        prefs.putInteger(GAME_PASSIV_INCOME, passsivIncome);
        prefs.flush();
    }

    public void addPassiveIncome() {
        passsivIncome++;
        updateScoreAndPassiveIncomeInPrefs();
    }
    public int getPoints() {
        return points;
    }
}
