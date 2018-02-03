package com.javapatterns.state.audioplayer;

public abstract class AudioPlayerState {
	protected static AudioPlayerState initialState;
	protected static AudioPlayerState playState;
	protected static AudioPlayerState stopState;

	static {
		playState = new PlayState();
		stopState = new StopState();
	}

	protected AudioPlayer player = null;

	public AudioPlayerState() {
	}

	public AudioPlayerState(AudioPlayer aPlayer) {
		player = aPlayer;
	}

	public void playButton() {
	}

	public void stopButton() {
	}
}
