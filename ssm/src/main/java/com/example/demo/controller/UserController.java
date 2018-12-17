package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	// 查询一个
	@ResponseBody
	@RequestMapping(value="name",method=RequestMethod.GET)
	public User getByName(String name) {
		return userService.getByName(name);
	
	
	/*
	 *  传递参数
	 * @RequestMapping(value="name/{name}",method=RequestMethod.GET)
	public User getByName(@PathVariable("name") String name) {
		return userService.getByName(name);
	}*/
	
	
	/*
	 *  @PathVariable 加在一个参数前面，用来映射这个参数，它可以有三个属性，name/value 表示 URI 里面的某个参数,
	 *  required 表示是否为必填参数
	 * 
	 * @RequestMapping(value="name/{test}",method=RequestMethod.GET)
	public User getByName(@PathVariable(required=false,name="test")String name) {
	public User getByName(@PathVariable(value="test",required=false)String nd) {
		return userService.getByName(nd);
	}*/
	
	/*
	 * 也可以传递多个参数
	 * 
	 * @RequestMapping("test/{name}/{age}")
	public String testParam(@PathVariable(value="name",required=false) String name,@PathVariable(value="age",required=false)String age) {
		return "name is "+name+"\n,age is "+age;
	}*/
	
	/*
	 * 以 ？ 的方式传递参数
	 * 
	 * @RequestMapping(value="name",method=RequestMethod.GET)
	public User getByName(@RequestParam("na")String na) {
		return userService.getByName(na);
	}*/
	/*
	 * 给参数设置默认值，只有 @RequestParam 才可以设置默认值，@PathVariable 不可以
	 * 
	 * @RequestMapping(value="name",method=RequestMethod.GET)
	public User getByName(@RequestParam(value="name",required=false,defaultValue="zhangsan")String name) {
		return userService.getByName(name);
	}*/
	
	}
	// 查询所有
	@ResponseBody
	@RequestMapping(value="all",method=RequestMethod.GET)
	public List<User> getAllUser() {
		return userService.getAllUser(0,16);
	}
	// 添加数据
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.GET)
	public int addUser() {
		User user = new User();
		user.setUsername("name17");
		user.setAge(17);
		return userService.addUser(user);
	}
	// 修改数据
	@RequestMapping(value="user/look/{id}")
	public String updateUser(@PathVariable(value="id",required=false)int id,HttpServletRequest request,ModelMap model) {
		if (request.getMethod().equals("GET")) {
			User user = userService.getById(id);
			model.put("user", user);
			return "userUpdate";
		} else {
			String username = request.getParameter("username");
			int age = Integer.parseInt(request.getParameter("age"));
			User user = new User();
			user.setId(id);
			user.setUsername(username);
			user.setAge(age);
			int i = userService.updateUser(user);
			if (i > 0) {
				return "修改成功";
			} else {
				return "修改失败";
			}
		}
		/*User user = new User();
		user.setId(12);
		user.setUsername("test");
		int i =  userService.updateUser(user);
		if (i > 0) {
			return "修改成功";
		} else {
			return "修改失败";
		}*/
	}
	// 删除数据
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteUser() {
		int i = userService.deleteUser(17);
		if (i > 0) {
			return "删除成功";
		} else {
			return "删除失败";
		}
	}
	// 查询所有并分页
	@RequestMapping(value="allUser",method=RequestMethod.GET)
	public String getAllUser(ModelMap model,@RequestParam(value="page_current",required=false,defaultValue="1")int page_current,Integer begin,Integer num) {
		num = 6;// 每页存放的记录数
		int count = userService.getUserCount();// 总记录数
		int pageCount = count%num == 0?count/num:count/num+1;// 总页数
		begin =(page_current-1)*num;
		model.put("count", count);
		model.put("pageCount", pageCount);
		model.put("page_current", page_current);
		model.put("user", userService.getAllUser(begin, num));
		return "index";
	}
	 
	@RequestMapping(value="user/look/{id}",method=RequestMethod.GET)
	public String look(@PathVariable(value="id")int id,ModelMap model) {
		User user = userService.getById(id);
		model.put("user", user);
		return "userDetails";
	}
	
}
