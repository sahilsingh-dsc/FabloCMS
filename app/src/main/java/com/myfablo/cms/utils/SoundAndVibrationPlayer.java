package com.myfablo.cms.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;

import com.myfablo.cms.R;

public class SoundAndVibrationPlayer {

    private MediaPlayer mediaPlayer;
    private Vibrator vibrator;
    private Context context;

    public SoundAndVibrationPlayer(Context context) {
        this.context = context;
        this.vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void playSoundWithPulseVibration() {
        // Initialize MediaPlayer with a sound from the raw folder
        mediaPlayer = MediaPlayer.create(context, R.raw.echo_sound);

        // Vibration pattern (1 second on, 0.5 seconds off)
        long[] vibrationPattern = {0, 1000, 500};

        // Start vibration with the defined pattern
        vibrator.vibrate(vibrationPattern, 0);

        // Start playing the sound
        if (mediaPlayer != null) {
            mediaPlayer.start();

            // Listener to stop vibration when sound playback is complete
            mediaPlayer.setOnCompletionListener(mp -> {
                // Stop the vibration
                vibrator.cancel();

                // Release the MediaPlayer resource
                mediaPlayer.release();
                mediaPlayer = null;
            });
        }
    }
}