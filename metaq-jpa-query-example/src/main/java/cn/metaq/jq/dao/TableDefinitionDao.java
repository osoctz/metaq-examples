package cn.metaq.jq.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.jq.entity.TableDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface TableDefinitionDao extends BaseDao<TableDefinition, Long> {

}
