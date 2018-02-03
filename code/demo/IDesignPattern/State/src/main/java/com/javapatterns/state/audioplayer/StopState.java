package com.javapatterns.state.audioplayer;

public class StopState extends AudioPlayerState {
	public StopState() {
	}

	public StopState(AudioPlayer player) {
		super(player);
	}

	public void playButton() {
		player.setState(AudioPlayerState.playState);
		player.startPlay();
	}
}
