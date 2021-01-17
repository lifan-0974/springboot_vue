package com.lllfff.controller;

import com.lllfff.model.Leaver;
import com.lllfff.model.PageResult;
import com.lllfff.model.People;
import com.lllfff.model.Result;
import com.lllfff.service.LeaverService;
import com.lllfff.service.PeopleService;
import com.lllfff.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

//控制层
@Controller
public class LeaveAndPeoController {
    //注入业务层
    @Resource
    private PeopleService peopleService;
    @Resource
    private LeaverService leaverService;

    //首页跳转
    @GetMapping("{url}")
    @ResponseBody
    public ModelAndView redirect(@PathVariable("url") String url){
          ModelAndView modelAndView=new ModelAndView();
          modelAndView.setViewName(url);
          return modelAndView;
    }
    //登录
    @PostMapping("login")
    @ResponseBody
    public R login(@RequestBody People people ){
        //将登录的值放入token
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(people.getUsername(),people.getPassword());
        try {
            //登录成功
            subject.login(token);
            People people1=(People) subject.getPrincipal();
            return R.ok().data("people",people1);
        }catch (UnknownAccountException e){
            //用户不存在
            e.printStackTrace();
            return R.error().message("用户不存在");
        }catch (IncorrectCredentialsException e){
            //密码错误
            e.printStackTrace();
            return  R.error().message("密码错误");
        }

    }
    //分页查询
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows){
        return leaverService.findPage(page, rows);
    }
    //条件查询
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search( Integer pid, Integer page, Integer rows  ){
        return leaverService.findPage1(pid, page, rows);
    }
    //根据id查询
    @RequestMapping("/findOne")
    @ResponseBody
    public R findOne(Integer lid) {
        Leaver leaver = leaverService.selectByid(lid);
        return R.ok().data("findone",leaver);
    }
    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer lid) {
            leaverService.delete(lid);
        return R.ok().message("删除成功");
    }
    //批量审核
    @RequestMapping("/upstatic1")
    @ResponseBody
    public R upstatic1(String userList) {
        String[] strs = userList.split(",");
        for (int i = 0; i < strs.length; i++) {
            leaverService.upstatic1(Integer.parseInt(strs[i]));
        }


        return R.ok().message("删除成功");
    }
    //批量驳回
    @RequestMapping("/upstatic2")
    @ResponseBody
    public R upstatic2(String userList) {
        String[] strs = userList.split(",");
        for (int i = 0; i < strs.length; i++) {
            leaverService.upstatic2(Integer.parseInt(strs[i]));
        }


        return R.ok().message("删除成功");
    }
    //批量删除
    @RequestMapping("/deleteall")
    @ResponseBody
    public R deleteall(String userList) {
        String[] strs = userList.split(",");
        for (int i = 0; i < strs.length; i++) {
            leaverService.delete(Integer.parseInt(strs[i]));
        }


        return R.ok().message("删除成功");
    }
    //审核方法
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Leaver leaver){
        try {
            leaverService.upstatic(leaver);
            return new Result(true, "审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
    //修改
    @RequestMapping("/update1")
    @ResponseBody
    public Result update1(@RequestBody Leaver leaver){
        try {
            leaverService.update(leaver);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Leaver leaver){
        try {
            leaverService.insert(leaver);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }
    //权限不足界面
    @GetMapping("unauth")
    @ResponseBody
    public String unauth(){
        return "未授权 无法访问！";
    }
    //退出登录
    @GetMapping("loginout")
    @ResponseBody
    public String loginout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return "login";

    }

}
