package cn.itnanls.dao.impl;

import cn.itnanls.Annotation.Bean;
import cn.itnanls.dao.IDogDao;
import cn.itnanls.entity.Dog;

import java.util.List;

/**
 *
 */
@Bean
public class DogDaoImpl implements IDogDao {
    @Override
    public Dog findDogById(int id) {
        return new Dog("teddy",12,"red");
    }

    @Override
    public List<Dog> findAllDogs() {
        return null;
    }

    @Override
    public List<Dog> findDogsByName() {
        return null;
    }
}
