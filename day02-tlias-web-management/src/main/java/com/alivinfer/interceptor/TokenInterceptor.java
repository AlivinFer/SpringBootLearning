package com.alivinfer.interceptor;

import com.alivinfer.utils.CurrentHolder;
import com.alivinfer.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fer
 * @version 1.0
 * @description Token 拦截器
 * @date 2025/5/27
 */

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {
        // 1.获取到请求路径(/login)
        String path = request.getRequestURI();

        // 2.判断请求路径是否以 /login 结尾，判断是不是登录，如果是就放行
        if (path.contains("/login")){
            log.info("登录请求, 放行");
            return true;
        }

        // 3.获取请求头中的token
        String token = request.getHeader("token");

        // 4.判断 token 是否存在，不存在就返回未登录信息 401，存在就放行
        if (token == null || token.isEmpty()){
            log.info("令牌为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 5.如果 token 存在，就放行，并且将 token 解析，获取其中的用户信息，校验不通过返回 401
        try {
            // 解析token
            Claims claims = jwtUtil.parseToken(token);
            log.info("解析令牌成功");

            Integer id = Integer.valueOf(claims.get("id").toString());
            String username = claims.get("username").toString();

            CurrentHolder.setCurrentUserInfo(id, username);
            log.info("当前登录员工 ID 和名称: {}-{}, 将其存入ThreadLocal", id, username);
        } catch (Exception e) {
            log.info("非法令牌");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 6.如果token校验通过，将用户放行
        log.info("令牌校验通过");
        return true;
    }

    /**
     * 在请求处理完成后调用的方法（整个请求完成，包括视图渲染）
     * 该方法在请求处理完成后被调用，可以用于执行一些清理工作或记录日志
     *
     * @param request  当前的HTTP请求对象
     * @param response 当前的HTTP响应对象
     * @param handler  处理请求的处理器对象
     * @param ex       如果请求处理过程中抛出了异常，该参数将包含异常信息
     */
    @Override
    public void afterCompletion(@NonNull HttpServletRequest request,
                                @NonNull HttpServletResponse response,
                                @NonNull Object handler,
                                Exception ex) throws Exception {
//        System.out.println("请求结束后统一处理");
        CurrentHolder.remove();
    }


    /**
     * 在请求处理完成后，但在视图渲染之前调用的后处理方法
     * 该方法继承自 HandlerInterceptor 接口，用于在请求处理完成后进行一些额外的处理
     *
     * @param request 当前的HTTP请求对象
     * @param response 当前的HTTP响应对象
     * @param handler 处理当前请求的处理器对象
     * @param modelAndView 包含模型和视图信息的对象
     */
    @Override
    public void postHandle(@NonNull HttpServletRequest request,
                           @NonNull HttpServletResponse response,
                           @NonNull Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 调用父类的postHandle方法，执行默认的后处理逻辑
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}
