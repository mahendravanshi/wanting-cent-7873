package com.ovs.dao;


import java.util.List;

import com.ovs.entity.Campaign;
import com.ovs.entity.Election;
import com.ovs.exception.NoRecordFoundException;
import com.ovs.exception.SomethingWentWrongException;
import com.ovs.utils.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ElectionDAOImpl implements ElectionDAO {

	
	@Override
    public void addElection(Election election) throws SomethingWentWrongException {
        EntityManager entityManager = EMUtils.getConnection();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.persist(election);
            transaction.commit();
        }
        catch(IllegalArgumentException | IllegalStateException | PersistenceException e){
            transaction.rollback();
            throw e;
        }
        finally{
            entityManager.close();
        }
    }

    @Override
    public List<Election> getAllElection() throws NoRecordFoundException, SomethingWentWrongException {
    	EntityManager entityManager = EMUtils.getConnection();
    	 String jpql = "SELECT E FROM Election E";
         Query query = entityManager.createQuery(jpql, Election.class);
        
        List<Election> elections = query.getResultList();

        entityManager.close();

        if(elections.isEmpty()) throw new NoRecordFoundException("No elections going on");
        return elections;
    }

    @Override
    public void removeElection(Election election) throws SomethingWentWrongException {
    	EntityManager entityManager = EMUtils.getConnection();
        EntityTransaction transaction = entityManager.getTransaction();
        Election remElection = null;
       
        try{
            transaction.begin();
            remElection = entityManager.merge(election);
            entityManager.remove(remElection);
            transaction.commit();
        }
        catch(IllegalStateException | PersistenceException e){
            transaction.rollback();
            throw new SomethingWentWrongException("Failed to delete election");
        }
    }

    @Override
    public void addCampaign(Campaign campaign) throws SomethingWentWrongException {
    	EntityManager entityManager = EMUtils.getConnection();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            String jpql = "SELECT E FROM Election E";
            Query query = entityManager.createQuery(jpql, Election.class);
            Election election = (Election) query.getSingleResult();

            election.getCampaigns().add(campaign);

            entityTransaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
            throw new SomethingWentWrongException("Something went wrong, try again later");
        }

        entityManager.close();
    }
    
}
