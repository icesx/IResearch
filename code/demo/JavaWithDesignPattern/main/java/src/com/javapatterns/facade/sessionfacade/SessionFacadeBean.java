package com.javapatterns.facade.sessionfacade;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class SessionFacadeBean implements SessionBean
{
    private SessionContext ctx;
    private Business1Bean aBusiness1Bean;
    private Business2Bean aBusiness2Bean;

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

    public void businessMethod1() throws RemoteException, EJBException
    {
    }

    public void businessMethod2()
    {
    }
}
