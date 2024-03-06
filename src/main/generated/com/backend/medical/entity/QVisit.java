package com.backend.medical.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVisit is a Querydsl query type for Visit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVisit extends EntityPathBase<Visit> {

    private static final long serialVersionUID = 1753309188L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVisit visit = new QVisit("visit");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final QHospital hospital;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPatient patient;

    public final DateTimePath<java.time.LocalDateTime> receiptDt = createDateTime("receiptDt", java.time.LocalDateTime.class);

    public final StringPath visitCode = createString("visitCode");

    public QVisit(String variable) {
        this(Visit.class, forVariable(variable), INITS);
    }

    public QVisit(Path<? extends Visit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVisit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVisit(PathMetadata metadata, PathInits inits) {
        this(Visit.class, metadata, inits);
    }

    public QVisit(Class<? extends Visit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hospital = inits.isInitialized("hospital") ? new QHospital(forProperty("hospital")) : null;
        this.patient = inits.isInitialized("patient") ? new QPatient(forProperty("patient"), inits.get("patient")) : null;
    }

}

