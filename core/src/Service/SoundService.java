package Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Karol on 12.08.2016.
 */
public class SoundService {
    private Sound boobsSound;
    private Sound welcomeSound;
    private Music music;
    private Music welcomeMusic;
    public SoundService() {
        init();

    }

    private void init() {
        boobsSound = Gdx.audio.newSound(Gdx.files.internal("sound/oh.ogg"));
        music = Gdx.audio.newMusic(Gdx.files.internal("sound/cdw.mp3"));
        welcomeSound =  Gdx.audio.newSound(Gdx.files.internal("sound/EA.wav"));
        welcomeMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/pragne.mp3"));
    }

    public void playBoobsSound(){
        boobsSound.play();
    }
    public void playWelcomeSound(){
        welcomeSound.play();
    }

    public void startPlayingMusic(boolean looped) {
        music.setVolume(0.3f);
     music.play();
        music.setLooping(looped);
    }
    public void PlayMusicWelcome(){
welcomeMusic.play();
    }
}
