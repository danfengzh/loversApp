package org.loversAPP.Controller.base;

/**
 * Created by Administrator on 2017/2/16.
 */

import org.loversAPP.utils.ResourcesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Controller基类 提供控制层的基础信息
 */
@Component
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpSession session;
    @Autowired
    private ResourcesUtil resourcesUtil;
}
