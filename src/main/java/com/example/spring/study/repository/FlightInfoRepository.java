package com.example.spring.study.repository;

import com.example.spring.study.entity.TbFlightInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jianglei on 2019/8/27.
 */
@Repository
public interface FlightInfoRepository extends JpaRepository<TbFlightInfoEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tb_flight_info WHERE departure_city_code = :name1 AND arrival_city_code = :name2 ")
    List<TbFlightInfoEntity> findTwoName(@Param("name1") String name1, @Param("name2") String name2);

}
