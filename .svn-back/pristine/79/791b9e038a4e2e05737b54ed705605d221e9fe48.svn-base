package com.javapatterns.state.login;

public abstract class UserState
{
    private UserState state;
    private String nextPage;
    protected static final String PAGE_WELCOME = "/javapatterns/state/welcome.html";
    protected static final String PAGE_LOGIN = "/javapatterns/state/login.html";

    public UserState()
    {
        this.nextPage = PAGE_LOGIN;
    }

    public abstract boolean login(String userId, String password);

    public abstract void logout();

    public void setCurrentState(UserState state)
    {
        this.state = state;
    }

    public UserState getCurrentState()
    {
        if (this.state == null)
        {
            this.state = new LoginState();
        }
        return this.state;
    }

    public String getNextPage()
    {
        return nextPage;
    }

    public void setNextPage(String nextPage)
    {
        this.nextPage = nextPage;
    }
}
