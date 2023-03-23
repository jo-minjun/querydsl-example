package my.example.querydsl.adapter.out;

import static my.example.querydsl.domain.QExampleEntity.exampleEntity;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.FactoryExpressionBase;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
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

  private BooleanBuilder commonFieldEq(Integer commonField) {
    return nullSafeBuilder(() -> exampleEntity.commonField.eq(commonField));
  }

  private BooleanBuilder typeEq(Type type) {
    return nullSafeBuilder(() -> exampleEntity.type.eq(type));
  }

  // or조건을 사용해도 NPE가 발생하지 않도록
  // e.g. where(typeEq(type).or(commonFiledEq(commonFiled))
  public static BooleanBuilder nullSafeBuilder(Supplier<Predicate> expression) {
    try {
      return new BooleanBuilder(expression.get());
    } catch (IllegalArgumentException e) {
      return new BooleanBuilder();
    }
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
