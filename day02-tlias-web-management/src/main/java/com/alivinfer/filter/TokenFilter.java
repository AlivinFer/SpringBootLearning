package com.alivinfer.filter;

import com.alivinfer.utils.CurrentHolder;
import com.alivinfer.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

/**
 * @author Fer
 * @version 1.0
 * @description 令牌校验 Filter 的拦截器
 * @date 2025/5/26
 */

@Slf4j
@WebFilter(urlPatterns = {"/*"}) // 拦截所有请求
public class TokenFilter implements Filter {

    private final JwtUtil jwtUtil;

    public TokenFilter() {
        // 获取Spring上下文里的Bean
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getServletContext()
        );
        jwtUtil = ctx.getBean(JwtUtil.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求路径
        String path = request.getRequestURI();

        // 判断请求路径是否以 /login 结尾，若是放行
        if (path.contains("/login")) {
            log.info("登录请求，放行");
            filterChain.doFilter(request, response);
            return;
        }

        // 获取 token
        String token = request.getHeader("token");

        // 判断 token 是否存在，不存在就返回未登录信息 401
        if (token == null || token.isEmpty()) {
            log.info("令牌为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try {
            // 解析 token，获取 token 第二部分
            Claims claims = jwtUtil.parseToken(token);

            Integer id = Integer.valueOf(claims.get("id").toString());
            String username = claims.get("username").toString();

            CurrentHolder.setCurrentUserInfo(id, username);
            log.info("当前登录员工 ID 和名称：{}-{}, 将其存入ThreadLocal", id, username);
        } catch (Exception e) {
            log.info("非法令牌");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 如果token校验通过，将用户放行
        log.info("令牌校验通过");
        filterChain.doFilter(request, response);
    }

    // 初始化方法, 只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
        Filter.super.init(filterConfig);
    }

    // 销毁方法, 只调用一次
    @Override
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
        Filter.super.destroy();
    }
}
