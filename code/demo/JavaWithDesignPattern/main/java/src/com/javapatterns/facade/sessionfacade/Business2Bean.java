package com.javapatterns.facade.sessionfacade;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class Business2Bean implements SessionBean
{
    private SessionContext ctx;

    public void setSessionContext(SessionContext context) throws RemoteException, EJBException
    {
        ctx = context;
    }

    public void ejbActivate() throws RemoteException, EJBException
    {
    }

    public void ejbPassivate() throws RemoteException, EJBException
    {
    }

    public void ejbRemove() throws RemoteException, EJBException
    {
    }

    public void ejbCreate() throws CreateException, EJBException, RemoteException
    {
        // Write your code here
    }

    public void businessMethod1()
    {
    }

    public void businessMethod2()
    {
    }
}
