package com.javapatterns.facade.sessionfacade;

import java.rmi.RemoteException;
import javax.ejb.EJBException;
import javax.ejb.EJBObject;

public interface Business2 extends EJBObject
{
    void businessMethod1() throws RemoteException, EJBException;

    void businessMethod2() throws RemoteException, EJBException;

    void businessMethod3() throws RemoteException, EJBException;
}
