package cn.itnanls.dao.impl;

import cn.itnanls.dao.IUserMapper;
import cn.itnanls.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class UserMapperImpl   implements IUserMapper {
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public User findUserById(Integer id) {
        IUserMapper mapper = sqlSessionTemplate.getMapper(IUserMapper.class);
        return mapper.findUserById(id);

    }
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
