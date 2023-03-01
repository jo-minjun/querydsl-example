package my.example.querydsl.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Table(name = "example")
@Getter
@AllArgsConstructor
public class ExampleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer commonField;

  private Type type;

  private String ATypeField;

  private String BTypeField;

  private String CTypeField;

  @AllArgsConstructor
  @Getter
  public enum Type {
    A(1),
    B(2),
    C(3);

    private final Integer dbData;

    public static Type findTypeByDbData(Integer dbData) {
      return Arrays.stream(values())
          .filter(value -> value.getDbData().equals(dbData))
          .findFirst()
          .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 타입입니다: " + dbData));
    }
  }
}
