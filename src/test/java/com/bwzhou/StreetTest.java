package com.bwzhou;


import com.bwzhou.dao.StreetRepository;
import com.bwzhou.entity.Street;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StreetTest {

    @Autowired
    private StreetRepository streetRepository;

    @Test
    public void add(){
        Street street=new Street();
        street.setId(1038);
        street.setDistrictId(1002);
        street.setName("大马士革路");
        streetRepository.addStreet(street);
    }

    @Test
    public void list(){
        List<Street> list = streetRepository.getList(2, 5);
        System.out.println(list);
    }


}
