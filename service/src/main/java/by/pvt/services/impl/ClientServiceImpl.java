package by.pvt.services.impl;

import by.pvt.dao.Dao;
import by.pvt.dao.DaoFactory;
import by.pvt.dao.DaoName;
import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.ClientDaoImpl;
import by.pvt.entity.Client;
import by.pvt.services.BaseService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/19/2016.
 */
public class ClientServiceImpl extends BaseService<Client> {

    private static Logger log = Logger.getLogger(ClientServiceImpl.class);
    private Transaction transaction = null;

    public ClientServiceImpl() {
    }

    @Override
    public Client get(Serializable id) throws ServiceException {
        Dao baseDao = DaoFactory.getInstance().getDao(DaoName.CLIENT);
        Session session = getSession();
        transaction = session.beginTransaction();
        Client client = null;
        try {
            client = (Client) baseDao.get(id);
            transaction.commit();
            closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            closeSession();
        }
        return client;
    }

    @Override
    public Client load(Serializable id) throws ServiceException {
        Dao baseDao = DaoFactory.getInstance().getDao(DaoName.CLIENT);
        Session session = getSession();
        transaction = session.beginTransaction();
        Client client = null;
        try {
            client = (Client) baseDao.load(id);
            transaction.commit();
            closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            closeSession();
        }
        return client;
    }

    @Override
    public List<Client> getAll() throws ServiceException {
        return null;
    }


    public List<Client> getClientByLogin(String login) {

        Session session = getSession();
        transaction = session.beginTransaction();

        log.info("Getting object User in class ClientServiceImpl in metod getClientByLogin by login: " + login);
        ClientDaoImpl clientDao = new ClientDaoImpl();
        try {
            List<Client> clients = clientDao.getClientByLogin(login);
            transaction.commit();
            closeSession();
            return clients;
        } catch (DaoException e) {
            e.printStackTrace();
            transaction.rollback();
            closeSession();
            return null;
        }

    }
}
