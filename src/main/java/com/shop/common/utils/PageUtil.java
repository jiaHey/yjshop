package com.shop.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {

    public static PageRequest page(HttpServletRequest request) {

        String rowsStr = request.getParameter("rows");
        Integer rows = 10;
        if (StringUtils.isNumeric(rowsStr)) {
            rows = Integer.parseInt(rowsStr);
        }

        String pageStr = request.getParameter("page");
        Integer page = 0;
        if (StringUtils.isNumeric(pageStr)) {
            page = Integer.parseInt(pageStr);
            page--;
        }
        String sidx = request.getParameter("sidx");
        String sord = request.getParameter("sord");
        PageRequest pageable;
        if (StringUtils.isNotEmpty(sidx)) {
            pageable = new PageRequest(page, rows, new Sort(sord.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC
                    , sidx==null?"id":sidx));
        } else {
            pageable = new PageRequest(page, rows);
        }
        return pageable;
    }
}
