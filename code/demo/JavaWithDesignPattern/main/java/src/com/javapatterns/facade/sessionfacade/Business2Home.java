package com.javapatterns.facade.sessionfacade;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBHome;

public interface Business2Home extends EJBHome
{
    Business2 create() throws CreateException, EJBException, RemoteException;
}
