package com.example.apringmvcbestpractice.controller;

import com.example.apringmvcbestpractice.bean.Employee;
import com.example.apringmvcbestpractice.common.R;
import com.example.apringmvcbestpractice.service.EmployeeService;
import com.example.apringmvcbestpractice.vo.req.EmployeeAddVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Tag(name = "员工管理的相关请求")
@CrossOrigin /*允许跨域*/
@RequestMapping("/api/v1")
@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @Operation(summary = "根据id查询员工信息")
    @GetMapping(value = "/employee/{iid}")
//    @RequestMapping(value = "/employee/{iid}",method = RequestMethod.GET)
    public R get(@PathVariable("iid") Long id){
        System.out.println("查询用户方法执行......");
        Employee emp = employeeService.getEmp(id);
        return R.ok(emp);
    }

    @DeleteMapping(value = "/employee/{idd}")
//    @RequestMapping(value = "/employee/{idd}",method = RequestMethod.DELETE)
    public R delete(@PathVariable("idd") Long id){
        employeeService.deleteEmp(id);
        return R.ok();
    }


    /**
     * @author: Zhou
     * @date: 2025/5/11 17:01
     新增员工；
     * 要求：前端发送请求把员工的json放在请求体中
     * 要求：如果校验出错，返回给前端。
     *   {
     *       "code": 500,
     *       "msg": "校验失败",
     *       "data": {
     *           "name": "姓名不能为空",  //这些就是为了让前端知道是哪些输入框错了，怎么错误，给用户要显示提示。
     *           "age": "年龄不能超过150"
     *       }
     *   }
     *
     */
//    @PostMapping("/employee")
//    public R add(@RequestBody @Valid Employee employee, /*@Valid封装数据的时候会根据field的注解进行校验*/
//                 BindingResult result /*BindingResult参数可以拿到校验的结果。【注意：知道即可，不这么使用】*/){
//        /*
//        *validation校验规则的使用
//        *   添加@Valid注解在解析请求参数封装Employee的时候会校验。
//        *   校验失败的话controller方法不会执行
//        * */
//        if (!result.hasErrors()){
//            System.out.println("新增员工目标方法执行。。。。。");
//            employeeService.saveEmp(employee);
//            return R.ok();
//        }
//
//        HashMap<String, String> map = new HashMap<>();
//        for (FieldError fieldError:result.getFieldErrors()){
//            String field = fieldError.getField();
//            String defaultMessage = fieldError.getDefaultMessage();
//            map.put(field,defaultMessage);
//        }
//        return R.error(500,"校验失败",map);
//    }

    @Operation(summary = "添加新员工") //为swagger生成的文档 添加的中文信息
    @PostMapping("/employee")
    public R add(@RequestBody @Valid EmployeeAddVo employee/*@Valid封装数据的时候会根据field的注解进行校验*/){
        System.out.println("新增员工目标方法执行。。。。。");
        /*
        * 1. 接收前端传来的数据，封装为EmployeeAddVo，并且加@Valid表示需要进行数据校验
        * 2. 创建数据库表记录对应的bean,即Employee类
        * 3. 使用BeanUtils.copyProperties完成属性的拷贝（将前端传来的数据封装到Employee类型bean的对应字段）
        * 4. 调用service层的方法完成添加逻辑
        * */
        Employee emp = new Employee();
        BeanUtils.copyProperties(employee,emp);
        employeeService.saveEmp(emp);
        return R.ok();
    }


    @PutMapping("/employee")
    public R update(@RequestBody Employee employee){
        employeeService.updateEmp(employee);
        return R.ok();
    }

    //语义化
    @GetMapping("/employees")
    public R all(){
        List<Employee> employees = employeeService.getList();
        return R.ok(employees);
    }
}
