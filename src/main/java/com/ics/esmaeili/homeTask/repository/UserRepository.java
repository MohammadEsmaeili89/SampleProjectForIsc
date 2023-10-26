package com.ics.esmaeili.homeTask.repository;

import com.ics.esmaeili.homeTask.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository <User,Integer>, PagingAndSortingRepository<User,Integer> {

    Optional<User> findByUserName(String userName);

}
