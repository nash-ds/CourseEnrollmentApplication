package com.hdfc.repository;

import com.hdfc.entity.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EnrollmentRepository {

    private Map<Integer, Enrollment> enrollmentStorage = new HashMap<>();

    public void save(Enrollment enrollment){
        enrollmentStorage.put(enrollment.getEnrollmentId() ,enrollment );
    }

    public Enrollment remove(int enrollmentId){
        Enrollment removedEnrollment = enrollmentStorage.get(enrollmentId);
        enrollmentStorage.remove(enrollmentId);
        return  removedEnrollment;
    }

    public List<Enrollment> getAll(){
        return new ArrayList<Enrollment>(enrollmentStorage.values());
    }
     public Enrollment getById(int id){
        return enrollmentStorage.get(id);
     }

}
