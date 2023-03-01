package my.example.querydsl.application.port.in;

import java.util.List;
import my.example.querydsl.domain.ExampleEntity;
import my.example.querydsl.domain.ExampleEntity.Type;

public interface ExampleUsecase {

  List<ExampleEntity> searchExampleEntityByType(Type type);
}
