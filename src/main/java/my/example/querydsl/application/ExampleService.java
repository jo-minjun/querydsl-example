package my.example.querydsl.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import my.example.querydsl.application.port.in.ExampleUsecase;
import my.example.querydsl.application.port.out.ExampleEntityRepository;
import my.example.querydsl.domain.ExampleEntity;
import my.example.querydsl.domain.ExampleEntity.Type;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService implements ExampleUsecase {

  private final ExampleEntityRepository repository;

  @Override
  public List<ExampleEntity> searchExampleEntityByType(Type type) {
    return repository.searchByType(type);
  }
}
