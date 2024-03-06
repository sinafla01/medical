package com.backend.medical.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeGroup is a Querydsl query type for CodeGroup
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeGroup extends EntityPathBase<CodeGroup> {

    private static final long serialVersionUID = -727248181L;

    public static final QCodeGroup codeGroup1 = new QCodeGroup("codeGroup1");

    public final StringPath codeGroup = createString("codeGroup");

    public final StringPath explanation = createString("explanation");

    public final StringPath groupName = createString("groupName");

    public QCodeGroup(String variable) {
        super(CodeGroup.class, forVariable(variable));
    }

    public QCodeGroup(Path<? extends CodeGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeGroup(PathMetadata metadata) {
        super(CodeGroup.class, metadata);
    }

}

