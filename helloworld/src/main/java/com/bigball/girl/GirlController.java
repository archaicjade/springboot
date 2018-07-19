package com.bigball.girl;

import com.sun.javafx.iio.gif.GIFDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {


    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /*
     * 查询所有女生立标
     * @return
     * */
    @RequestMapping(value = "/girls", method = RequestMethod.GET)
    public List<Girl> girlList() {

        return girlRepository.findAll();
    }

    /*
     * 添加一个女生
     * */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    //    查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id);
    }

    //    更新接口
    @PostMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id
            , @RequestParam("cupSize") String cupSize
            , @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    //    删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {

        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl>
    girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {

        girlService.insertTwo();
    }
}
