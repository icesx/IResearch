package com.javapatterns.state.taoist;

public class WallEntry {
	private WallStateIF state;

	public void setState(WallStateIF state) {
		this.state = state;
	}

	public void pass() throws WallEntryException {
		state.pass(this);
	}

	// correction
	public void spell(String aSpell) throws WallEntryException {
		state.spell(this, aSpell);
	}

}
