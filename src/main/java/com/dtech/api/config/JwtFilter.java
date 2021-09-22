package com.dtech.api.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dtech.api.model.TenantStorage;
import com.dtech.api.service.UserDetailsServiceImpl;
import com.dtech.api.utils.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		
		System.out.println("Requested Method: "+httpServletRequest.getMethod());
		
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS,DELETE");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Request-Headers", "authorization, content-type");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-Tenant, Content-Type, Accept, Authorization");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");		

		String autherizationHeader = httpServletRequest.getHeader("Authorization");
		String tenantHeader = httpServletRequest.getHeader("X-Tenant");
		String token = null;
		String username = null;

//		httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
//		httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,HEAD,PUT");

		if (tenantHeader != null)
			System.out.println("Tenant : " + tenantHeader);
		else
			tenantHeader="test1";

		TenantStorage.setCurrentTenent(tenantHeader);

		if (autherizationHeader != null && autherizationHeader.startsWith("Bearer ")) {
			token = autherizationHeader.substring("Bearer ".length());
			username = jwtUtil.extractUsername(token);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			// Validate User
			if (jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			}
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

}
