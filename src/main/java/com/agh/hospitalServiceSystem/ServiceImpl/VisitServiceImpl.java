/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agh.hospitalServiceSystem.ServiceImpl;

import com.agh.hospitalServiceSystem.Dao.DiagnosisDao;
import com.agh.hospitalServiceSystem.Dao.VisitDao;
import com.agh.hospitalServiceSystem.Model.*;
import com.agh.hospitalServiceSystem.Service.VisitService;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wiktor
 */
@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDao visitDao;
    @Autowired
    private DiagnosisDao diagnosisDao;
    @Override
    public Long create(Visit visit) {
        return visitDao.create(visit);
    }

    @Override
    public void update(Visit visit) {
        visitDao.update(visit);
    }

    @Override
    public Visit getVisitById(Long id) {
        return visitDao.getVisitById(id);
    }

    @Override
    public List<Visit> getVisits() {

        return visitDao.getVisits();
    }



    @Override
    public void removeVisit(Long id) {
        visitDao.removeVisit(id);
    }

    @Override
    public void getReservation(Long id, Long id_patient) {
        visitDao.getReservation(id, id_patient);
    }

    @Override
    public void afterVisit(Diagnosis diagnosis, long id) {
        diagnosisDao.create(diagnosis);
        visitDao.afterVisit(diagnosis, id);
    }

    @Override
    public List<Visit> getAvaiable(){
        List<Visit> visit=new ArrayList<>();
        List<Visit> all=visitDao.getVisits();
        for(Visit u:all){
            if(u.getStatus().equals(Status.AVAILABLE)){
                visit.add(u);
            }
        }
        return visit;
    }
    
    public List<Visit> getVisitByPatientId(Long id){
        List<Visit> patientVisits=new ArrayList();
        List<Visit> allVisits=getVisits();
        if(allVisits!=null){
            for(Visit v:allVisits){
                if(v.getPatient()!=null){
                    if(v.getPatient().getId()==id){
                        patientVisits.add(v);
                    }
                }
            }
        }
        return patientVisits;
    }
    
}

