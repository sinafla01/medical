package com.backend.medical.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCode is a Querydsl query type for Code
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCode extends EntityPathBase<Code> {

    private static final long serialVersionUID = -1190928364L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCode code1 = new QCode("code1");

    public final StringPath code = createString("code");

    public final QCodeGroup codeGroup;

    public final StringPath codeName = createString("codeName");

    public QCode(String variable) {
        this(Code.class, forVariable(variable), INITS);
    }

    public QCode(Path<? extends Code> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCode(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCode(PathMetadata metadata, PathInits inits) {
        this(Code.class, metadata, inits);
    }

    public QCode(Class<? extends Code> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.codeGroup = inits.isInitialized("codeGroup") ? new QCodeGroup(forProperty("codeGroup")) : null;
    }

}

