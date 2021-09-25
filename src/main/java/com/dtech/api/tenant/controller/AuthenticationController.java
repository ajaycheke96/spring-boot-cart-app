package com.dtech.api.tenant.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.api.tenant.entity.User;
import com.dtech.api.tenant.model.ApiResponse;
import com.dtech.api.tenant.model.AuthRequest;
import com.dtech.api.tenant.service.UserService;
import com.dtech.api.tenant.utils.JwtUtil;

@RestController
@RequestMapping("/rest/api")
public class AuthenticationController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@RequestMapping("/master-record")
	public ApiResponse test() {
		List<User> users = userService.getAllUsers();
		return new ApiResponse(LocalDateTime.now(), 200, "SUCCESS", users);
	}

	@PostMapping("/authenticate")
	public ApiResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid username/password");
		}

		Map<String, Object> authObject = new HashMap<>();
		authObject.put("authToken", jwtUtil.generateToken(authRequest.getUsername()));
		return new ApiResponse(LocalDateTime.now(), 200, "SUCCESS", authObject);

	}
}