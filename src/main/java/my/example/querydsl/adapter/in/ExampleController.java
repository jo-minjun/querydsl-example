package my.example.querydsl.adapter.in;

import java.util.List;
import lombok.RequiredArgsConstructor;
import my.example.querydsl.application.port.in.ExampleEntityDto;
import my.example.querydsl.application.port.in.ExampleUsecase;
import my.example.querydsl.domain.ExampleEntity;
import my.example.querydsl.domain.ExampleEntity.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/example")
@RequiredArgsConstructor
public class ExampleController {

  private final ExampleUsecase usecase;

  @GetMapping
  public ResponseEntity<List<ExampleEntityDto>> searchExampleEntityByType(@RequestParam Type type) {
    final List<ExampleEntity> entities = usecase.searchExampleEntityByType(type);

    return ResponseEntity.ok(Mapper.toDto(entities));
  }
}
