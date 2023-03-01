package my.example.querydsl.adapter.out;

import static my.example.querydsl.domain.QExampleEntity.exampleEntity;

import com.querydsl.core.types.FactoryExpressionBase;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import my.example.querydsl.application.port.out.ExampleEntityDto;
import my.example.querydsl.domain.ExampleEntity;
import my.example.querydsl.domain.ExampleEntity.Type;
import org.springframework.stereotype.Component;

@Component
public class ExampleEntityCustomRepositoryImpl implements ExampleEntityCustomRepository {

  private final JPAQueryFactory queryFactory;

  public ExampleEntityCustomRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public List<ExampleEntity> searchByType(Type type) {
    final FactoryExpressionBase<ExampleEntityDto> selectFields = getSelectFieldsByType(type);

    final List<ExampleEntityDto> exampleEntityDtos = queryFactory.select(selectFields)
        .from(exampleEntity)
        .where(exampleEntity.type.eq(type))
        .fetch();

    return Mapper.of(exampleEntityDtos);
  }

  private static FactoryExpressionBase<ExampleEntityDto> getSelectFieldsByType(Type type) {
    return switch (type) {
      case A -> Projections.bean(ExampleEntityDto.class, exampleEntity.commonField,
          exampleEntity.ATypeField);
      case B -> Projections.bean(ExampleEntityDto.class, exampleEntity.commonField,
          exampleEntity.BTypeField);
      case C -> Projections.bean(ExampleEntityDto.class, exampleEntity.commonField,
          exampleEntity.CTypeField);
    };
  }
}
