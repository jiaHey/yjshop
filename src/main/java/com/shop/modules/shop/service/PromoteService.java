package com.shop.modules.shop.service;

import com.shop.modules.shop.domain.Cart;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.Order;
import com.shop.modules.shop.domain.Promote;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


/**
 * Created by heyujia on 2017/11/24.
 */
@Service
public class PromoteService {

    /**
     * 使用促销后的价格(促销不可用返回null)
     *
     * @param promote
     * @param cartList
     * @return
     */
    public BigDecimal getPromotePrice(Promote promote, Iterable<Cart> cartList) {
        String goodsIds = promote.getGoodsIds();
        BigDecimal total = new BigDecimal(0);
        Integer number = 0;
        for (Cart cart : cartList) {
            Goods goods = cart.getGoods();
            if (goodsIds.indexOf(goods.getId() + "") > 0) {
                total = total.add(goods.getPrice().multiply(new BigDecimal(cart.getNumber())));
                number += cart.getNumber();
            }
        }
        if (!validPromote(promote, total, number)) {
            //促销不生效返回null
            return null;
        }
        switch (promote.getPromoteType()) {
            case CUT:
                total = total.subtract(promote.getPromotePrice());
                break;
            case DISCOUNT:
                total = total.multiply(promote.getPromotePrice());
                break;
            case LOOP_CUT:
                BigDecimal loop = total.divideToIntegralValue(promote.getPromotePrice());
                total = total.subtract(promote.getPromotePrice().multiply(loop));
                break;
        }
        return total;
    }
    /**
     * 促销是否生效
     *
     * @return
     */
    private boolean validPromote(Promote promote, BigDecimal total, Integer number) {
        boolean valid = false;
        switch (promote.getConditionType()) {
            case TOTAL:
                valid = total.compareTo(promote.getConditionPrice()) >= 0;
                break;
            case NUMBER:
                valid = promote.getConditionPrice().compareTo(new BigDecimal(number)) <= 0;
                break;
        }
        return valid;
    }
}
