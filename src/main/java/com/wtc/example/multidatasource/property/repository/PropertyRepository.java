package com.wtc.example.multidatasource.property.repository;

import com.wtc.example.multidatasource.property.entity.PropertyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 房源接口类
 *
 * @author 吴天成
 * @create 2019/4/10
 * @since 1.0.0
 */
@Repository
public interface PropertyRepository extends JpaRepository<PropertyDO, Long> {

}