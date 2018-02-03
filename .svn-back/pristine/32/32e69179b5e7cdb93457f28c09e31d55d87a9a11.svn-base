package com.javapatterns.command.audioplayer;

/** This class plays the role of Concrete Command */

public class PlayCommand implements Command
{
    private AudioPlayer myAudio;

    public PlayCommand(AudioPlayer audio)
    {
        myAudio = audio;
    }

    public void execute()
    {
        myAudio.play();
    }
}
