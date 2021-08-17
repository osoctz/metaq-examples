package cn.metaq.example.jpa.dao;

import cn.metaq.data.jpa.BaseRepository;
import cn.metaq.example.jpa.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseRepository<User,Long> {
}
