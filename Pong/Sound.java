import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("bloop_x.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("cheering.wav"));
	public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("exit_cue_y.wav"));
}