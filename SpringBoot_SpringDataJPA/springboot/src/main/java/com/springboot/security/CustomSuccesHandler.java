package com.springboot.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccesHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		try {
			determineTargetUrl(authentication);
			if (response.isCommitted()) {
				return;
			}
			super.handle(request, response, authentication);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	public static MyUser getPrincipal()throws Exception {
		MyUser myUser = null;
		try {
			myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myUser;
	}

	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() throws Exception{
		List<String> results = new ArrayList<String>();
		try {
			List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
					.getAuthentication().getAuthorities());
			for (GrantedAuthority authority : authorities) {
				results.add(authority.getAuthority());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	private String determineTargetUrl(Authentication authentication) throws Exception {
		String url = "";
		try {
			List<String> roles = getAuthorities();
			if (isAdmin(roles)) {
				url = "/quan-tri/trang-chu";
			} else if (isUser(roles)) {
				url = "/trang-chu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	private boolean isAdmin(List<String> roles) throws Exception {
		try {
			if (roles.contains("ROLE_ADMIN")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isUser(List<String> roles) throws Exception{
		try {
			if (roles.contains("ROLE_USER")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
