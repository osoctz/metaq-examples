package cn.metaq.jq.entity;

import cn.metaq.common.core.IEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_ge_table_definition")
@Setter
@Getter
public class TableDefinition implements IEntity<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id" )
  private Long id;

  @OneToOne
  @JoinColumn(name = "created_by",referencedColumnName = "username")
  private User user;
}
