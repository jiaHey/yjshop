package com.shop;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testWechat {
    @Autowired
    private WxPayService wxPayService;
    @Test
    public void we() throws WxErrorException {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxdefabfcdf94af03c"); // 设置微信公众号的appid
        config.setSecret("187de2f9c830cc956164cfeb8abc55cc"); // 设置微信公众号的app corpSecret

        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);

// 用户的openid在下面地址获得
// https://mp.weixin.qq.com/debug/cgi-bin/apiinfo?t=index&type=用户管理&form=获取关注者列表接口%20/user/get
        String openid = "o2q200p3PK_8cCmmJ6yuHtYkqeHQ";
        WxMpKefuMessage message = WxMpKefuMessage.TEXT().toUser(openid).content("Hello World").build();
        wxService.getKefuService().sendKefuMessage(message);


    }
    @Test
    public void info(){
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxdefabfcdf94af03c"); // 设置微信公众号的appid
        config.setSecret("187de2f9c830cc956164cfeb8abc55cc"); // 设置微信公众号的app corpSecret

        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);

        String s = wxService.oauth2buildAuthorizationUrl("1", "2", "2");
        System.out.println(s);

    }
    @Test
    public void pay(){
        WxPayUnifiedOrderRequest.Builder builder = WxPayUnifiedOrderRequest.newBuilder();
        builder.body("2");
        builder.outTradeNo("2asf");
        builder.totalFee(12);
        builder.spbillCreateIp("120.43.64.82");
        builder.notifyURL("sadasd");
        builder.openid("asdas");
        builder.tradeType("JSAPI");
        WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = builder.build();
        try {
            Map<String, String> payInfo = wxPayService.getPayInfo(wxPayUnifiedOrderRequest);
            System.out.println("1");
            System.out.println("1");
            System.out.println("1");
        } catch (WxPayException e) {
            e.printStackTrace();
        }
    }
}
