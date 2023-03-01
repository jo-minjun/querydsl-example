package my.example.querydsl.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import my.example.querydsl.domain.ExampleEntity.Type;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Type attribute) {
    return attribute.getDbData();
  }

  @Override
  public Type convertToEntityAttribute(Integer dbData) {
    return Type.findTypeByDbData(dbData);
  }
}
