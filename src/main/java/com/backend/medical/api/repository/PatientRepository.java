package com.backend.medical.api.repository;

import com.backend.medical.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, PatientCustom {

    // 이름과 성별로 환자 조회
    Optional<Patient> findByNameAndGenderCode(String name, String genderCode);

    // 병원 ID로 병원환자 수 조회
    int countByHospitalId(long hospitalId);

    // 병원 ID로 환자목록 조회
    List<Patient> findByHospitalId(long hospitalId);
}
