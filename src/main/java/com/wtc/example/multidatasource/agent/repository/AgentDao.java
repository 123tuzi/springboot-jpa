package com.wtc.example.multidatasource.agent.repository;

import com.wtc.example.multidatasource.agent.entity.AgentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 〈经纪人接口〉
 *
 * @author 吴天成
 * @create 2019/4/10
 * @since 1.0.0
 */
@Repository
public interface AgentDao extends JpaRepository<AgentDO, Long> {

}