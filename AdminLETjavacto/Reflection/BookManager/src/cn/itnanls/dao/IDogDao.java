package cn.itnanls.dao;

import cn.itnanls.entity.Dog;

import java.util.List;

/**
 *
 */
public interface IDogDao {
    Dog findDogById(int id);

    List<Dog> findAllDogs();

    List<Dog> findDogsByName();
}
