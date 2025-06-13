package com.alivinfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 登录信息
 * @date 2025/5/22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {

    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 名称
     */
    private String name;

    /**
     * token 认证信息
     */
    private String token;
}
