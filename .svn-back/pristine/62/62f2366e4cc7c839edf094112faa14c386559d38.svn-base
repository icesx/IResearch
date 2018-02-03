package com.javapatterns.command.audioplayer2;

/** This is the Invoker role */
public class Keypad
{
    private Command playCmd;
    private Command rewindCmd;
    private Command stopCmd;

    //correction
    public Keypad(Command aPlayCmd, Command aStopCmd, Command aRewindCmd)
    {
        // concrete Command registers itself with the invoker
        playCmd = aPlayCmd;
        stopCmd = aStopCmd;
        rewindCmd = aRewindCmd;
    }

    public void play()
    {
        playCmd.execute();
    }

    public void stop()
    {
        stopCmd.execute();
    }

    public void rewind()
    {
        rewindCmd.execute();
    }

    public void playMacro() { }
}

