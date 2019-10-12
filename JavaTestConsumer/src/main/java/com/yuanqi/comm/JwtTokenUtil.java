package com.yuanqi.comm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by fengqiang on 2019/7/26.
 */
public class JwtTokenUtil {

    //定义日志对象
    Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    /**
     * token过期时间
     */
    private static final long VALIDITY_TIME_MS = 24 * 60 * 60 * 1000 * 10000 * 1000; // (24 hours  validity)*10000=1w days

    /**
     * header中标识
     */
    private static final String AUTH_HEADER_NAME = "x-authorization";

    /**
     * 签名密钥
     */
    // @Value("${jwt.token.secret}")
    private String secret = "ab#s9d";

    /**
     * 验签
     */
    public Optional<Authentication> verifyToken(HttpServletRequest request) {

        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (!StringUtils.isEmpty(token)){
            final TokenUserDTO user = parse(token.trim());
            if (user != null) {
                return Optional.of(new TokenUserAuthentication(user, true));
            }
        }
        return Optional.empty();
    }


    /**
     * 从用户中创建一个jwt Token
     *
     * @param userDTO 用户
     * @return token
     */
    public String create(TokenUserDTO userDTO) {
        long now = System.currentTimeMillis();
        long dt = now + VALIDITY_TIME_MS;
        Date date = new Date(now + dt);
        return Jwts.builder()
                .setExpiration(date)
                .setSubject(userDTO.getUsername())
                .claim("id",userDTO.getId())
                .claim("avatar", userDTO.getAvatar())
                .claim("roles", userDTO.getRoles())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 从token中取出用户
     */
    public TokenUserDTO parse(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        TokenUserDTO userDTO = new TokenUserDTO();
        userDTO.setId(claims.get("id", String.class));
        userDTO.setAvatar(claims.get("avatar",String.class));
        userDTO.setUsername(claims.get("username",String.class));
        userDTO.setRoles((List<String>) claims.get("roles"));
        userDTO.setToken(token);
        return userDTO;
    }
}
