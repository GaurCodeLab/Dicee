package com.ankitgaur.dicee;

//import android.media.AudioManager;
import android.media.MediaPlayer;
//import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.Random;

import static com.ankitgaur.dicee.R.raw.roll_dice;

public class MainActivity extends AppCompatActivity {


        //int DiceSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mSoundpool;
        mSoundpool=  MediaPlayer.create(this,R.raw.roll_dice);


        Button rollButton;

        rollButton =  findViewById(R.id.rollbutton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSoundpool.setVolume(50,50);
                try{
                    mSoundpool.prepare();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                mSoundpool.start();
            }
        });
        final ImageView leftDice =  findViewById(R.id.image_LeftDice);

        final ImageView rightDice =  findViewById(R.id.image_RightDice);

        final int[] diceArray =
                {
                        R.drawable.dice1,
                        R.drawable.dice2,
                        R.drawable.dice3,
                        R.drawable.dice4,
                        R.drawable.dice5,
                        R.drawable.dice6
                };

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Dicee", "button is pressed");

                Random randomNumberGenerator = new Random();

                int ranmun = randomNumberGenerator.nextInt(6);

                int number = randomNumberGenerator.nextInt(6);

                Log.d("Dicee", "The random number is" + number);

                leftDice.setImageResource(diceArray[number]);

                rightDice.setImageResource(diceArray[ranmun]);

            }
        });
    }


    //public void playtime(View v) {
      //  Log.d("Dicee", "button is clicked");
     //   mSoundpool.play(DiceSound,1,1,1,0,1);
    //}
}