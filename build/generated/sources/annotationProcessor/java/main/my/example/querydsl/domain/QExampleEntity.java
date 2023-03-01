package my.example.querydsl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExampleEntity is a Querydsl query type for ExampleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExampleEntity extends EntityPathBase<ExampleEntity> {

    private static final long serialVersionUID = -1272404426L;

    public static final QExampleEntity exampleEntity = new QExampleEntity("exampleEntity");

    public final StringPath ATypeField = createString("ATypeField");

    public final StringPath BTypeField = createString("BTypeField");

    public final NumberPath<Integer> commonField = createNumber("commonField", Integer.class);

    public final StringPath CTypeField = createString("CTypeField");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<ExampleEntity.Type> type = createEnum("type", ExampleEntity.Type.class);

    public QExampleEntity(String variable) {
        super(ExampleEntity.class, forVariable(variable));
    }

    public QExampleEntity(Path<? extends ExampleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExampleEntity(PathMetadata metadata) {
        super(ExampleEntity.class, metadata);
    }

}

