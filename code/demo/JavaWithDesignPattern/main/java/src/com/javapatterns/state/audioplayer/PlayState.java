package com.javapatterns.state.audioplayer;

public class PlayState extends AudioPlayerState
{
    public PlayState() { }

    public PlayState(AudioPlayer player)
    {
        super(player);
    }

    public void stopButton()
    {
        player.setState(AudioPlayerState.stopState);
        player.stopPlay();
    }
}
