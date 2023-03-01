package my.example.querydsl.application.port.in;

import lombok.Data;
import my.example.querydsl.domain.ExampleEntity.Type;

@Data
public class ExampleEntityDto {

  private Long id;

  private Integer commonField;

  private Type type;

  private String ATypeField;

  private String BTypeField;

  private String CTypeField;
}
