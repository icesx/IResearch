package com.javapatterns.state.audioplayer;

public class Julie {
	private static AudioPlayer player;

	public void main(String[] args) {
		player = new AudioPlayer();

		player.startButton();
		player.stopButton();
	}
}
