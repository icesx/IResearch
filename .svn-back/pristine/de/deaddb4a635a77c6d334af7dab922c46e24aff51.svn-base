package com.javapatterns.state.taoist;

import java.util.Date;

public class LockedState implements WallStateIF
{
    //correction
    protected static String rightSpell = "!@#$%^&*()";
    private Date timeOfLock;

    public LockedState()
    {
        this.setTimeOfLock(new Date());
    }

    //correction
    public void spell(WallEntry wall, String aSpell) throws WallEntryException
    {
        if (aSpell.equals(LockedState.rightSpell))
        {
            wall.setState(new UnlockedState());
        }
        else
        {
            throw new WallEntryException("Wrong spell!!!");
        }
    }

    public void pass(WallEntry wall) throws WallEntryException
    {
        throw new WallEntryException("Bang!!!");
    }

    public Date getTimeOfLock()
    {
        return timeOfLock;
    }

    public void setTimeOfLock(Date timeOfLock)
    {
        this.timeOfLock = timeOfLock;
    }
}
