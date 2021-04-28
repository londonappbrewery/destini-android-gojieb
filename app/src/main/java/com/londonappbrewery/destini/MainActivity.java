package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.file.Path;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView textViewStory;
    Button buttonA;
    Button buttonB;
    private int mQuestion;
    private int mAnswerA;
    private int mAnswerB;
    private boolean userSelection;
    private int mStoryIndex = 1;
    private StoryPath[] storyPaths = new StoryPath[]{
            new StoryPath(0, 0, 0),
            new StoryPath(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryPath(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new StoryPath(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new StoryPath(R.string.T4_End, 0, 0),
            new StoryPath(R.string.T5_End, 0, 0),
            new StoryPath(R.string.T6_End, 0, 0)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        textViewStory = findViewById(R.id.storyTextView);
        buttonA = findViewById(R.id.buttonTop);
        buttonB = findViewById(R.id.buttonBottom);

        startGame();


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        View.OnClickListener listenerA = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection = true;
                if (mStoryIndex < 4) {
                    nextPath();
                } else {
                    buttonB.setVisibility(View.VISIBLE);
                    mStoryIndex = 1;
                    startGame();
                }
            }
        };
        buttonA.setOnClickListener(listenerA);


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        View.OnClickListener listenerB = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick: ANSWERED B");
                userSelection = false;
                nextPath();
            }
        };
        buttonB.setOnClickListener(listenerB);
    }


    private void nextPath() {

        if (mStoryIndex == 1 && userSelection) {
            mStoryIndex = 3;
        } else if (mStoryIndex == 1 && userSelection == false) {
            mStoryIndex = 2;
        } else if (mStoryIndex == 2 && userSelection) {
            mStoryIndex = 3;
        } else if (mStoryIndex == 2 && userSelection == false) {
            mStoryIndex = 4;
        } else if (mStoryIndex == 3 && userSelection) {
            mStoryIndex = 6;
        } else if (mStoryIndex == 3 && userSelection == false) {
            mStoryIndex = 5;
        }
        startGame();
    }


    private void startGame() {

        mQuestion = storyPaths[mStoryIndex].getPathID();
        mAnswerA = storyPaths[mStoryIndex].getPathA();
        mAnswerB = storyPaths[mStoryIndex].getPathB();
        textViewStory.setText(mQuestion);
        if (mStoryIndex < 4) {
            buttonA.setText(mAnswerA);
            buttonB.setText(mAnswerB);
        } else {
            buttonA.setText("Restart Game");
            buttonB.setVisibility(View.GONE);
        }
    }
}