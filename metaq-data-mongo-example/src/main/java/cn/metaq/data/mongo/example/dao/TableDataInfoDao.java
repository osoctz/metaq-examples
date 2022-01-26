package cn.metaq.data.mongo.example.dao;

import cn.metaq.data.mongo.example.entity.TableDataInfo;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 15:50 2020/2/5
 * @Modified By:
 */
public interface TableDataInfoDao extends MongoRepository<TableDataInfo, String> {

    /**
     * 根据数据表id查询数据样例
     * @param tableId
     * @return
     */
    TableDataInfo findByTableId(String tableId);

    /**
     * 根据数据表id集合批量删除数据表样例数据
     * @param tableIds
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteByTableIdIn(List<String> tableIds);

}
