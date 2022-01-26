package cn.metaq.jq.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.jq.entity.DataQualityRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface DataQualityRecordDao extends BaseDao<DataQualityRecord, String> {

}
