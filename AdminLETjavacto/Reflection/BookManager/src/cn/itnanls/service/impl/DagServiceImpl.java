package cn.itnanls.service.impl;

import cn.itnanls.Annotation.AutoWird;
import cn.itnanls.Annotation.Bean;
import cn.itnanls.dao.IDogDao;
import cn.itnanls.entity.Dog;
import cn.itnanls.service.IDogService;

/**
 *
 */
@Bean
public class DagServiceImpl implements IDogService {
    @AutoWird
   private IDogDao dogDao;
    @Override
    public void findKiller(int id) {
        Dog dog = dogDao.findDogById(id);
        System.out.println(dog);
    }
}
