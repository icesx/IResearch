package com.javapatterns.command.audioplayer;

/** This class plays the role of Concrete Command */
public class StopCommand implements Command
{
    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audio)
    {
        myAudio = audio;
    }

    public void execute()
    {
        myAudio.stop();
    }
}
