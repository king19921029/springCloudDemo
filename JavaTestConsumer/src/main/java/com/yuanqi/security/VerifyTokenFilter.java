package com.yuanqi.security;

import com.yuanqi.comm.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 *  jwt token验证类,验证成功后设置进去SecurityContext中
 */

public class VerifyTokenFilter extends OncePerRequestFilter {

    private JwtTokenUtil jwtTokenUtil;

    public VerifyTokenFilter(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws
            ServletException, IOException {
        try {
            Optional<Authentication> authentication = jwtTokenUtil.verifyToken(request);

            SecurityContextHolder.getContext().setAuthentication(authentication.orElse(null));
            filterChain.doFilter(request,response);
        } catch (JwtException e) {
            String token = request.getHeader("x-authorization");
            filterChain.doFilter(request,response);
            // response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //可以在这里指定重定向还是返回错误接口示例
        }
    }
}