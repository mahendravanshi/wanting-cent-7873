package com.ovs.service;
import java.util.List;

import com.ovs.dao.ElectionDAO;
import com.ovs.dao.ElectionDAOImpl;
import com.ovs.entity.Campaign;
import com.ovs.entity.Election;
import com.ovs.exception.NoRecordFoundException;
import com.ovs.exception.SomethingWentWrongException;

import jakarta.persistence.NoResultException;

public class ElectionServiceImpl implements ElectionService {
    static ElectionDAO electionDAO;

    static{
        electionDAO = new ElectionDAOImpl();
    }
    @Override
    public void addElection(Election election) throws SomethingWentWrongException {
        try{
            electionDAO.addElection(election);
        }
        catch(Exception e){
            throw new SomethingWentWrongException("Something went Wrong, Try again later");
        }
    }

    @Override
    public List<Election> getAllElection() throws NoRecordFoundException, SomethingWentWrongException {
        try{
            return electionDAO.getAllElection();
        }
        catch(NoRecordFoundException | NoResultException e){
            throw new NoRecordFoundException("No Election found");
        }
        catch(Exception e){
            e.printStackTrace();
            throw new SomethingWentWrongException("Something went Wrong, Try again later");
        }
    }

    @Override
    public Election getCurrentElection() throws NoRecordFoundException, SomethingWentWrongException {
        return getAllElection().get(0);
    }

    @Override
    public void removeElection(Election election) throws SomethingWentWrongException {
        electionDAO.removeElection(election);
    }

    @Override
    public void removeCurrentElection() throws NoRecordFoundException, SomethingWentWrongException {
       electionDAO.removeElection(getCurrentElection());
    }

    @Override
    public void addCampaign(Campaign campaign) throws SomethingWentWrongException {
        electionDAO.addCampaign(campaign);;
    }
    
}