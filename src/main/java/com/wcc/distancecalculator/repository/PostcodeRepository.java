package com.wcc.distancecalculator.repository;

import com.wcc.distancecalculator.model.PostcodeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostcodeRepository extends CrudRepository<PostcodeInfo, Long> {

    PostcodeInfo findByPostCode(String zipCode);

}
