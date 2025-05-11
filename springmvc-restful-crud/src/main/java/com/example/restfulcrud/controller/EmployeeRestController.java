package com.example.restfulcrud.controller;


import com.example.restfulcrud.bean.Employee;
import com.example.restfulcrud.common.R;
import com.example.restfulcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author: Zhou
 * @date: 2025/5/10 14:39
 * 同源策略的报错：
 *      base:1 Access to XMLHttpRequest at 'http://localhost:8080/api/v1/employees' from
 * origin 'http://localhost' has been blocked by CORS policy: Response to preflight request
 * doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on
 * the requested resource.
 *
 * CORS policy：同源策略（限制ajax请求，图片，css，js）； 跨域问题
 * 跨源资源共享（CORS）（Cross-Origin Resource Sharing）
 *    浏览器为了安全，默认会遵循同源策略（请求要去的服务器和当前项目所在的服务器必须是同一个源[同一个服务器]），如果不是，请求就会被拦截
 *    复杂的跨域请求会发送2次：
 *    1、options 请求：预检请求。浏览器会先发送options请求，询问服务器是否允许当前域名进行跨域访问
 *    2、真正的请求：POST、DELETE、PUT等
 *
 *
 * 浏览器页面所在的：http://localhost/employee/base
 * 页面上要发去的请求：http://localhost:8080/api/v1/employees
 *  /以前的东西，必须完全一样，一个字母不一样都不行。浏览器才能把请求（ajax）发出去。
 *
 *  跨域问题：
 *    1、前端自己解决：
 *    2、后端解决：允许前端跨域即可
 *          原理：服务器给浏览器的响应头中添加字段：Access-Control-Allow-Origin = *
 */

/**
 * @author: Zhou
 * @date: 2025/5/10 14:54
 * code：业务的状态码，200是成功，剩下都是失败; 前后端将来会一起商定不同的业务状态码前端要显示不同效果。
 * msg：服务端返回给前端的提示消息
 * data：服务器返回给前端的数据
 *   {
 *       "code": 300,
 *       "msg": "余额不足",
 *       "data": null
 *   }
 *
 *   前端统一处理:
 *      1、前端发送请求，接受服务器数据
 *      2、判断状态码，成功就显示数据，失败就显示提示消息（或者执行其他操作）。
 */
@CrossOrigin /*允许跨域*/
@RequestMapping("/api/v1")
@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employee/{iid}")
//    @RequestMapping(value = "/employee/{iid}",method = RequestMethod.GET)
    public R get(@PathVariable("iid") Long id){
        Employee emp = employeeService.getEmp(id);
        return R.ok(emp);
    }

    @DeleteMapping(value = "/employee/{idd}")
//    @RequestMapping(value = "/employee/{idd}",method = RequestMethod.DELETE)
    public R delete(@PathVariable("idd") Long id){
        employeeService.deleteEmp(id);
        return R.ok();
    }

    @PostMapping("/employee")
    public R add(@RequestBody Employee employee){
        employeeService.saveEmp(employee);
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
