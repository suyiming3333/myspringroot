package com.sym.mybatisplus.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sym.mybatisplus.model.enums.TypeEnum;
import com.sym.mybatisplus.model.system.User;
import com.sym.mybatisplus.service.system.IUserService;
import com.sym.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Author: D.Yang
 * Email: koyangslash@gmail.com
 * Date: 16/10/9
 * Time: 上午11:58
 * Describe: 用户控制器
 * 
 * 代码生成器，参考源码测试用例：
 * 
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/MysqlGenerator.java
 *
 */
@Controller
public class UserController extends BaseController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("userList", userService.selectList(null));
        return modelAndView;
    }

    @RequestMapping("/preSave")
    public ModelAndView preSave(ModelAndView modelAndView, @RequestParam(value = "id", required = false) Long id) {
        modelAndView.setViewName("save");
        if (id != null) {
            modelAndView.addObject("user", userService.selectById(id));
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("save")
    public Object save(User user) {
        user.setType(TypeEnum.DISABLED);
        if (user.getId() == null) {
            return userService.insert(user) ? renderSuccess("添加成功") : renderError("添加失败");
        } else {
            return userService.updateById(user) ? renderSuccess("修改成功") : renderError("修改失败");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestParam(value = "id", required = false) Long id) {
        return userService.deleteById(id) ? renderSuccess("删除成功") : renderError("删除失败");
    }

    /**
     * mybatisplus 条件包装以及分页
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object selectPage(){
        EntityWrapper ew = new EntityWrapper();
        ew.setEntity(new User());
        ew.where("name = {0}","Tom").andNew("age>{0}","20").orderBy("age");
        Page page=new Page(1,10);
        page = userService.selectPage(page, ew);
        User user = new User();
        user.setName("corn");
        user.setAge(25);
        RedisUtil.set("test",user);
        User getUser = RedisUtil.getObj("test",User.class);
        return page;
    }
}
