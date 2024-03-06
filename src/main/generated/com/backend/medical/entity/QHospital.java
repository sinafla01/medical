package com.backend.medical.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHospital is a Querydsl query type for Hospital
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHospital extends EntityPathBase<Hospital> {

    private static final long serialVersionUID = -151468831L;

    public static final QHospital hospital = new QHospital("hospital");

    public final StringPath delegateName = createString("delegateName");

    public final StringPath hospitalName = createString("hospitalName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nursingAgency = createString("nursingAgency");

    public QHospital(String variable) {
        super(Hospital.class, forVariable(variable));
    }

    public QHospital(Path<? extends Hospital> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHospital(PathMetadata metadata) {
        super(Hospital.class, metadata);
    }

}

