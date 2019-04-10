package com.wtc.example.multidatasource.property.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 房源
 *
 * @author 吴天成
 * @create 2019/4/10
 * @since 1.0.0
 */
@Entity
@Table(name = "property")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id", length = 20)
    private Long houseId;

    @Column(name = "city_name", length = 32)
    private String cityName;

    @Column(name = "city_code", length = 20)
    private String cityCode;

    @Column(name = "agent_id", length = 20)
    private Integer agentId;

}