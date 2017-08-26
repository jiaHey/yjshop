package com.shop.modules.shop.controller.home;

import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Order;
import com.shop.modules.shop.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/home/pay")
public class WxPayController {
    @Resource(name = "wxPayService")
    private WxPayService wxService;
    @Autowired
    private OrderService orderService;

    /**
     * 统一下单(详见http://com.github.binarywang.wechat.pay.bean.pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
     * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
     * 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
     *
     * @param request 请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
     */
    @PostMapping("/unifiedOrder")
    public WxPayUnifiedOrderResult unifiedOrder(@RequestBody WxPayUnifiedOrderRequest request) throws WxPayException {
        return this.wxService.unifiedOrder(request);
    }

    /**
     * 该接口调用“统一下单”接口，并拼装发起支付请求需要的参数
     * 详见http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115&token=&lang=zh_CN
     *
     * @param request 请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
     */
    @PostMapping("/payInfo")
    public Map<String, String> getPayInfo(@RequestBody WxPayUnifiedOrderRequest request) throws WxPayException {
        return this.wxService.getPayInfo(request);
    }
}
