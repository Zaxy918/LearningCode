package com.zaxyliu.controller;

import com.zaxyliu.pojo.Dept;
import com.zaxyliu.pojo.Result;
import com.zaxyliu.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j @RequestMapping("/depts") @RestController
public class DeptController {

    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        //        System.out.println("Query all depts");
        log.info("Query all depts");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    //    @DeleteMapping("/depts")
    //    public Result delete(HttpServletRequest request) {
    //        int id = Integer.parseInt(request.getParameter("id"));
    //        System.out.println("Delete dept" + id);
    //        return Result.success();
    //    }
    //    @DeleteMapping("/depts")
    //    public Result delete(@RequestParam(value = "id", required = false) Integer deptId) {
    //        System.out.println("Delete dept " + deptId);
    //        return Result.success();
    //    }
    @DeleteMapping//Use this when param from frontend is same as param in this method
    public Result delete(Integer id) {
        //        System.out.println("Delete dept " + id);
        log.info("Delete dept {}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        //        System.out.println("Add dept " + dept);
        log.info("Add dept {}", dept);
        return Result.success();
    }

    //    @GetMapping("/depts/{id}")
    //    public Result getInfo(@PathVariable("id") Integer deptId) {
    //        System.out.println("Query dept " + deptId);
    //        Dept dept = deptService.getInfo(deptId);
    //        return Result.success(dept);
    //    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        //        System.out.println("Query dept " + id);
        log.info("Query dept {}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        //        System.out.println("Update dept " + dept);
        log.info("Update dept {}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
