package my.example.querydsl.adapter.in;

import java.util.List;
import java.util.stream.Collectors;
import my.example.querydsl.application.port.in.ExampleEntityDto;
import my.example.querydsl.domain.ExampleEntity;

public class Mapper {

  public static List<ExampleEntityDto> toDto(List<ExampleEntity> exampleEntities) {
    return exampleEntities.stream()
        .map(entity -> {
          final ExampleEntityDto exampleEntityDto = new ExampleEntityDto();
          exampleEntityDto.setId(entity.getId());
          exampleEntityDto.setType(entity.getType());
          exampleEntityDto.setATypeField(entity.getATypeField());
          exampleEntityDto.setBTypeField(entity.getBTypeField());
          exampleEntityDto.setCTypeField(entity.getCTypeField());

          return exampleEntityDto;
        })
        .collect(Collectors.toList());
  }
}
