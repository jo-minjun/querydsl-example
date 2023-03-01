package my.example.querydsl.adapter.out;

import java.util.List;
import my.example.querydsl.domain.ExampleEntity;
import my.example.querydsl.domain.ExampleEntity.Type;

public interface ExampleEntityCustomRepository {

  List<ExampleEntity> searchByType(Type type);
}
