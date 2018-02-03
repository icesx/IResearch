package com.javapatterns.command.audioplayer2;

/** This class plays the role of Concrete Command */

public class RewindCommand implements Command
{
    private AudioPlayer myAudio;

    public RewindCommand(AudioPlayer audio)
    {
        myAudio = audio;
    }

    public void execute()
    {
        myAudio.rewind();
    }
}
