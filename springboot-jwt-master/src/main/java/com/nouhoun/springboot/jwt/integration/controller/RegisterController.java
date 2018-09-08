package com.nouhoun.springboot.jwt.integration.controller;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.bean.JsonResponse;
import com.nouhoun.springboot.jwt.integration.bean.MessageBean;
import com.nouhoun.springboot.jwt.integration.bean.UserBean;
import com.nouhoun.springboot.jwt.integration.domain.RandomCity;
import com.nouhoun.springboot.jwt.integration.service.GenericService;

@RestController
@RequestMapping("/registeruser")
public class RegisterController {
	@Autowired
    private GenericService userService;
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
    public List<MessageBean> registerUser(@RequestBody UserBean userBean){
		List<MessageBean> arlMsgBean = new ArrayList<MessageBean>();
		MessageBean msgBean = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(userBean.getPassword().getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	        /*StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	     
	        System.out.println("Hex format : " + sb.toString());*/
	        
	        //convert the byte to hex format method 2
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	    	
	    	userBean.setEncodedPswd(hexString.toString());
	    	int id = userService.registerUser(userBean);
	    	
	    	msgBean = new MessageBean();
	    	if(id == -1){
	    		msgBean.setVal("error");
	    		msgBean.setMsg("Error occured while inserting User");
	    	}else if(id == -2){
	    		msgBean.setVal("error");
	    		msgBean.setMsg("Error occured while inserting User");
	    	}else{
	    		msgBean.setVal("success");
	    		msgBean.setMsg("Record Inserted Successfully");
	    	}
	    	arlMsgBean.add(msgBean);
		} catch (Exception e) {
			System.out.println("Ex-->"+e);
		}
        return arlMsgBean;
    }
	
	@RequestMapping(value ="/users", method = RequestMethod.POST)
    public List<UserBean> getUsers(@RequestHeader(value="Authorization", required=false) String authorization){
		 
		System.out.println("authorization--->" + authorization);
		/*if (authorization != null && authorization.startsWith("Bearer")) {
		String jwtToken = authorization.substring("Bearer".length()).trim();
        System.out.println("------------ Decode JWT ------------");
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        String base64EncodedSignature = split_string[2];

        System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        System.out.println("JWT Header : " + header);


        System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println("JWT Body : "+body);        
		}*/
		String[] values = null;
		  if (authorization != null && authorization.startsWith("Basic")) {
	        // Authorization: Basic base64credentials
	        String base64Credentials = authorization.substring("Basic".length()).trim();
	        String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
	        // credentials = username:password
	         values = credentials.split(":",2);
		  }
    	System.out.println("getUsersEntered");
        return userService.getAllUsers();
    }
	
	@RequestMapping(value ="/loginUser", method = RequestMethod.GET)
    public JsonResponse loginUser(@RequestHeader(value="Authorization", required=false) String authorization, @RequestHeader(value="app_name", required=false) String str_app_name){
		JsonResponse response = new JsonResponse();
		System.out.println("loginUser started--->" + authorization);
		String[] values = null;
		  if (authorization != null && authorization.startsWith("Basic")) {
	        // Authorization: Basic base64credentials
	        String base64Credentials = authorization.substring("Basic".length()).trim();
	        String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
	        System.out.println("credentials-->"+credentials);
	        // credentials = username:password
	         values = credentials.split(":",2);
		  }
		  response.setResponse_status("Success");
		  response.setResponse_message("User logged in successfully");
		  List<UserBean> list = userService.getUserByUserName(values[0]);
		  System.out.println(list);
		  response.setData(list);
		  System.out.println("values--->" + values[0]);
    	System.out.println("getUsersEntered");
        return response;
    }
	
	@RequestMapping(value ="/cities")
    public List<RandomCity> getUser(){
        return userService.findAllRandomCities();
    }
	
	@RequestMapping(value ="/user", method = RequestMethod.POST )
    public List<UserBean> getUserByUserId(@RequestHeader(value="User-Name", required=false) String userName){
    	System.out.println("UserName----->" + userName);
    	List<UserBean> list = userService.getUserByUserName(userName);
    	System.out.println("UName----->" + list.get(0).getLastName());
        return list;
    }
	
}
