package com.javapatterns.state.taoist;

import java.util.Date;

public class UnlockedState implements WallStateIF
{
    private Date timeOfUnlock;

    public UnlockedState()
    {
        this.setTimeOfUnlock(new Date());
    }

    //correction
    public void spell(WallEntry wall, String aSpell) throws WallEntryException
    {
    }

    public void pass(WallEntry wall) throws WallEntryException
    {
        wall.setState(new LockedState());
    }

    public Date getTimeOfUnlock()
    {
        return timeOfUnlock;
    }

    public void setTimeOfUnlock(Date timeOfUnlock)
    {
        this.timeOfUnlock = timeOfUnlock;
    }
}
