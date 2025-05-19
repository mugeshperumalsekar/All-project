package com.ponsun.aml.scamTeam.ScamObservation.services;

import com.ponsun.aml.scamTeam.ScamObservation.domain.ScamObservation;

import java.util.List;

public interface ScamObservationReadService {
    ScamObservation fetchScamObservationById(Integer id);
    List<ScamObservation> fetchAllScamObservation();
}
