/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agh.hospitalServiceSystem.Dao;

import com.agh.hospitalServiceSystem.Model.Diagnosis;
import com.agh.hospitalServiceSystem.Model.Visit;
import java.util.List;

/**
 *
 * @author Wiktor
 * @author Michal
 */
public interface VisitDao {

    Long create(Visit visit);

    void update(Visit visit);

    Visit getVisitById(Long id);

    List<Visit> getVisits();

    void removeVisit(Long id);

    void getReservation(Long id,Long id_patient);

    void afterVisit(Diagnosis diagnosis, long id);
}

