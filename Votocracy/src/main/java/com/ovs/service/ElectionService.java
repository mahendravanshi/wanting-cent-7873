package com.ovs.service;

import java.util.List;

import com.ovs.entity.Campaign;
import com.ovs.entity.Election;
import com.ovs.exception.NoRecordFoundException;
import com.ovs.exception.SomethingWentWrongException;



public interface ElectionService {
    public void addElection(Election election) throws SomethingWentWrongException;
    public List<Election> getAllElection() throws NoRecordFoundException, SomethingWentWrongException;
    public Election getCurrentElection() throws NoRecordFoundException, SomethingWentWrongException;
    public void removeElection(Election election) throws SomethingWentWrongException;
    public void removeCurrentElection() throws NoRecordFoundException, SomethingWentWrongException;
    public void addCampaign(Campaign campaign) throws SomethingWentWrongException;
}
