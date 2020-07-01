package com.adminlte.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adminlte.models.User;
import com.adminlte.models.UserRole;
import com.adminlte.services.UserService;


@Controller
public class UserController {

	@Autowired
	private  UserService userService;
	
	
  
  @GetMapping("/admin/user")
  public String getUser(Model model) {
	// Get List Of User
     List<User> userList=userService.findAll();
     //Get List Of Role
     List<UserRole> userRole=userService.findRole();
     
     
    // model.addAttribute("userList", userList);
     model.addAttribute("userRole", userRole);
     //For get Data From Form Add New User
    //.addAttribute("user",new User());
	 return "admin/views/user";
  }
  /*
   * Save User
   */
  @RequestMapping(value="/admin/user/save",method = RequestMethod.POST)
  public  String saveUser( HttpServletRequest request){
	  String username=request.getParameter("username");
	  String password=request.getParameter("password");
	  User user=new User();
	  user.setUsername(username);
	  user.setPassword(password);
	  userService.save(user);
	  return "redirect:/admin/user";
  }
  
 /*
  *Get Single Record By Id 
  */
  @RequestMapping("/admin/user/findById")
  @ResponseBody
  public Optional<User> getSingle(int useid) {
		return userService.findById(useid);
  }
  
  /*
   * Update User
   */
  @RequestMapping(value="/admin/user/update",method= RequestMethod.POST)
  public String updateUser(@ModelAttribute User user) {
	  return "redirect:/admin/user";
  }
  
  /*
   * Delete User
   */
  @RequestMapping(value="/admin/user/delete")
  public String deleteUser(int useid){
	  userService.delete(useid);
	  return "redirect:/admin/user";
  }
 
  @RequestMapping("/user")
  @ResponseBody
  public User  findUserByUsername() {
	  return userService.findByUsername("dara");
  }
	
	
}
