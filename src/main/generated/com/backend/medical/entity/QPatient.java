package com.backend.medical.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPatient is a Querydsl query type for Patient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPatient extends EntityPathBase<Patient> {

    private static final long serialVersionUID = 44774270L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPatient patient = new QPatient("patient");

    public final StringPath birthday = createString("birthday");

    public final StringPath genderCode = createString("genderCode");

    public final QHospital hospital;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath patientUuid = createString("patientUuid");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<Visit, QVisit> visits = this.<Visit, QVisit>createList("visits", Visit.class, QVisit.class, PathInits.DIRECT2);

    public QPatient(String variable) {
        this(Patient.class, forVariable(variable), INITS);
    }

    public QPatient(Path<? extends Patient> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPatient(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPatient(PathMetadata metadata, PathInits inits) {
        this(Patient.class, metadata, inits);
    }

    public QPatient(Class<? extends Patient> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hospital = inits.isInitialized("hospital") ? new QHospital(forProperty("hospital")) : null;
    }

}

