package com.hdfc.repository;

import com.hdfc.entity.Enrollment;

import java.util.HashMap;
import java.util.Map;

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

}
