package cn.metaq.data.mongo.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 15:41 2020/2/5
 * @Modified By:
 */
@Data
@ToString
@Document(collection = "table_data_info")
public class TableDataInfo implements java.io.Serializable{

    private static final long serialVersionUID = 2411187081232734163L;

    @Id
    private String tableId;

    @Field("sample_data")
    private List<Map<String, Object>> sampleData = new ArrayList<>(128);

}
