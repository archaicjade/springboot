package com.bigball.girl.controller;

import com.bigball.girl.domain.Girl;
import com.bigball.girl.domain.Result;
import com.bigball.girl.repository.GirlRepository;
import com.bigball.girl.service.GirlService;
import com.bigball.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

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

        logger.info("girlList");
        return girlRepository.findAll();
    }

    /*
     * 添加一个女生
     * */
//    @PostMapping(value = "/girls")
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
//                        @RequestParam("age") Integer age) {
//        Girl girl = new Girl();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//        return girlRepository.save(girl);
//    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {

        Result result = new Result();
        if (bindingResult.hasErrors()) {

            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());

        } else {
            girl.setCupSize(girl.getCupSize());
            girl.setAge(girl.getAge());
            Girl girl1 = girlRepository.save(girl);

            return ResultUtil.success(girl1);
        }
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

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
