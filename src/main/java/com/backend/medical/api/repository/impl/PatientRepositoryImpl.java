package com.backend.medical.api.repository.impl;

import com.backend.medical.api.dto.PatientDto;
import com.backend.medical.api.repository.PatientCustom;
import com.backend.medical.entity.Patient;
import com.backend.medical.entity.QPatient;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PatientRepositoryImpl implements PatientCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<PatientDto> findPatientByTerms(String name, String birthday, String patientCode) {
        QPatient pa = QPatient.patient;

        JPAQuery<Tuple> query = queryFactory.select(
                        pa.id,
                        pa.name,
                        pa.hospital,
                        pa.patientUuid,
                        pa.genderCode,
                        pa.genderCode,
                        pa.birthday,
                        pa.phoneNumber
                ).from(pa)
                .where(nameEq(pa, name), (birthdayEq(pa, birthday)), (patientCodeEq(pa, patientCode)));

        // query 결과를 patient 객체로 변환
        List<Patient> patients = query.fetch().stream().map(tuple -> Patient.builder()
                .id(tuple.get(pa.id))
                .name(tuple.get(pa.name))
                .patientUuid(tuple.get(pa.patientUuid))
                .hospital(tuple.get(pa.hospital))
                .genderCode(tuple.get(pa.genderCode))
                .birthday(tuple.get(pa.birthday))
                .phoneNumber(tuple.get(pa.phoneNumber))
                .build()).toList();

        // 리턴 타입 변환
        return patients.stream().map(PatientDto::new).toList();
    }

    private BooleanBuilder nameEq(QPatient pa, String name) {
        if (name == null) {
            return new BooleanBuilder();
        } else {
            return new BooleanBuilder(pa.name.eq(name));
        }
    }

    private BooleanBuilder birthdayEq(QPatient pa, String birthday) {
        if (birthday == null) {
            return new BooleanBuilder();
        } else {
            return new BooleanBuilder(pa.birthday.eq(birthday));
        }
    }

    private BooleanBuilder patientCodeEq(QPatient pa, String patientCode) {
        if(patientCode == null) {
            return new BooleanBuilder();
        } else {
            return new BooleanBuilder(pa.patientUuid.eq(patientCode));
        }
    }
}
