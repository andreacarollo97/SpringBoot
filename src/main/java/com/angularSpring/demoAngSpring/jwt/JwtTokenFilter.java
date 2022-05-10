package com.angularSpring.demoAngSpring.jwt;

import com.angularSpring.demoAngSpring.services.UserDetailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
             String token = getToken(req);
             if(token != null && jwtProvider.validateToken(token)){
                 String email = jwtProvider.getEmailFromToken(token);
                 UserDetails userDetails = userDetailService.loadUserByUsername(email);
                 UsernamePasswordAuthenticationToken auth =
                         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                 SecurityContextHolder.getContext().setAuthentication(auth);
             }
        }
        catch (Exception e) {
            logger.error("Fail nel metodo doFilter");
        }
        filterChain.doFilter(req,res);
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")){
            return header.replace("Bearer","");
        }
        return null;
    }
}
