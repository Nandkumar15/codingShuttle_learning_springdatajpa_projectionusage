package com.learning.codingshuttle.hospitalManagement.repository;

import com.learning.codingshuttle.hospitalManagement.dto.BloodGroupStats;
import com.learning.codingshuttle.hospitalManagement.dto.CPatientInfo;
import com.learning.codingshuttle.hospitalManagement.dto.IPatientInfo;
import com.learning.codingshuttle.hospitalManagement.entities.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    //interface based projection - read only
    @Query("select p.id as id,p.name as name,p.email as email from Patient p")
    List<IPatientInfo>getPatientInfo();

    //class based projection , can be used to modify the data, we have to pass a reference of the projection class
    @Query("select new com.learning.codingshuttle.hospitalManagement.dto.CPatientInfo(p.id ,p.name)" +
            " from Patient p")
    List<CPatientInfo> getAllPatientInfoUsingConcreate();

    @Query("select new com.learning.codingshuttle.hospitalManagement.dto.BloodGroupStats(p.bloodGroup ,COUNT(p)) " +
            "from Patient p group by p.bloodGroup order by COUNT(p) DESC" )
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name=:name where p.id =:id")
    int updatePatientNameById(@Param("name") String name, @Param("id")Long id);
}
