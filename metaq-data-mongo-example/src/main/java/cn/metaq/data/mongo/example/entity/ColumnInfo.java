package cn.metaq.data.mongo.example.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Setter
@Getter
@Document(collection = "column_info")
public class ColumnInfo {

  @Id
  private String id;

  @Indexed(name = "column_ti_index")
  private String tableId;

  private String columnName;

  @DocumentReference
  private List<ColumnInfo> columns;
}
