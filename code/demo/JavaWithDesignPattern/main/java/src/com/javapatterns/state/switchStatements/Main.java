package com.javapatterns.state.switchStatements;

public class Main
{

    static final int STATE_LOCKED = 1;
    static final int STATE_UNLOCKED = 2;

    static final int EVENT_SPELL = 4;
    static final int EVENT_PASS = 8;

    public void transition(int event)
    {
        int state = STATE_LOCKED;

        switch (state)
        {
            case(STATE_LOCKED):
                switch (event)
                {
                    case(EVENT_SPELL):
                        state = STATE_UNLOCKED;
                        break;
                    case(EVENT_PASS):
                        bang();
                        break;
                }
                break;
            case STATE_UNLOCKED:
                switch (event)
                {
                    case(EVENT_SPELL):
                        state = STATE_UNLOCKED;
                        break;
                    case(EVENT_PASS):
                        state = STATE_LOCKED;
                        break;
                }
                break;
        }
    }

    public void bang()
    {
        System.out.println("You are damned.");
    }

}
