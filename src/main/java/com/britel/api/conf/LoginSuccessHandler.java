package com.britel.api.conf;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.britel.api.model.Authority;
import com.britel.api.model.User;
import com.britel.api.service.AuthorityService;
import com.britel.api.service.UserService;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

  @Autowired
  private UserService userService;
  @Autowired
  private AuthorityService authoritiesService;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    Optional<User> user = userService.findByEmail(((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername());
    Optional<Authority> authority = authoritiesService.findByEmail(((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername());

    request.getSession().setAttribute("currentUserId", user.get().getIdUser());
    request.getSession().setAttribute("authority", authority.get().getAuthority());

    response.setStatus(HttpServletResponse.SC_OK);
    response.sendRedirect("/nntv-control/devices"); // Para este método es necesario poner la ruta absoluta en vez de simplemente /welcome

  }

}
