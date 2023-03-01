package my.example.querydsl.adapter.out;

import java.util.List;
import java.util.stream.Collectors;
import my.example.querydsl.application.port.out.ExampleEntityDto;
import my.example.querydsl.domain.ExampleEntity;

public class Mapper {

  public static List<ExampleEntity> of(List<ExampleEntityDto> exampleEntityDtos) {
    return exampleEntityDtos.stream()
        .map(dto -> new ExampleEntity(dto.getId(),
            dto.getCommonField(),
            dto.getType(),
            dto.getATypeField(),
            dto.getBTypeField(),
            dto.getCTypeField()))
        .collect(Collectors.toList());
  }
}
