package com.wtc.example.multidatasource;

import com.wtc.example.multidatasource.property.entity.PropertyDO;
import com.wtc.example.multidatasource.property.repository.PropertyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDataSourceApplicationTests {

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    @Transactional("propertyTransactionManager")
    public void contextLoads() {
        PropertyDO propertyDO = propertyRepository.findById(1L).orElse(null);
        System.out.println(propertyDO.getCityName());
    }

}
