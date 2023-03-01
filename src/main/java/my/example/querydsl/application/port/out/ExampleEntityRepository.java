package my.example.querydsl.application.port.out;

import my.example.querydsl.adapter.out.ExampleEntityCustomRepository;
import my.example.querydsl.domain.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Long>, ExampleEntityCustomRepository {

}
