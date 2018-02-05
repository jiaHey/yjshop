package com.sys;

import com.shop.modules.sys.domain.SysUser;
import io.jsonwebtoken.*;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by heyujia on 2017/9/27.
 */
public class testAuth {
    @Test
    public void jwt() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 4);

        String compactJws = Jwts.builder()
                .setId("1")
                .setExpiration(cal.getTime())
                .signWith(SignatureAlgorithm.HS512, SysUser.SIGNKEY)
                .compact();
//        Jws<Claims> shop = Jwts.parser().setSigningKey("shop").parseClaimsJws(compactJws);
//        String id = shop.getBody().getId();
        System.out.println(compactJws);
    }
}
