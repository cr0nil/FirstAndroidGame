package Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Karol on 12.08.2016.
 */
public class SoundService {
    private Sound boobsSound;
    private Music music;
    public SoundService() {
        init();

    }

    private void init() {
        boobsSound = Gdx.audio.newSound(Gdx.files.internal("sound/yeah.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("sound/hymn.mp3"));
    }

    public void playBoobsSound(){
        boobsSound.play();
    }

    public void startPlayingMusic(boolean looped) {
        music.setVolume(0.1f);
     music.play();
        music.setLooping(looped);
    }
}
