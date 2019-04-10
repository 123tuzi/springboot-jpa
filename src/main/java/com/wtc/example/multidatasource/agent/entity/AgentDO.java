package com.wtc.example.multidatasource.agent.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 经纪人
 *
 * @author 吴天成
 * @create 2019/4/10
 * @since 1.0.0
 */
@Entity
@Table(name = "agent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgentDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agent_id", length = 20)
    private Long agentId;

    @Column(name = "agent_name", length = 20)
    private String agentName;

    @Column(name = "city_code", length = 20)
    private Integer cityCode;

    @Column(name = "phone", length = 20)
    private String phone;

}