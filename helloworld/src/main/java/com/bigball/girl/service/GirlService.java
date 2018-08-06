package com.bigball.girl.service;

import com.bigball.girl.domain.Girl;
import com.bigball.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");

        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("F");

        girlB.setAge(20);

        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {

        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new Exception("你还在上小学吧");
        } else if (age > 10 && age < 16) {
            throw new Exception("你可能在上初中");
        }
    }
}
