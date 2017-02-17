package org.loversAPP.Controller.base;

/**
 * Created by Administrator on 2017/2/16.
 */

import org.loversAPP.DTO.FeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Controller基类 提供控制层的基础信息
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

//    @Autowired
//    private ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    //    @InitBinder
//    protected void initBinder(HttpServletRequest request,
//                              ServletRequestDataBinder binder) throws Exception {
//        binder.registerCustomEditor(Date.class, new DateEditor());
//    }
    protected ModelAndView ajaxDone(int statusCode, String message, String forwardUrl) {
        ModelAndView mav = new ModelAndView("ajaxDone");
        mav.addObject("statusCode", statusCode);
        mav.addObject("message", message);
        mav.addObject("forwardUrl", forwardUrl);
        return mav;
    }

    protected ModelAndView ajaxDoneSuccess(String message) {
        return ajaxDone(200, message, "");
    }

    protected ModelAndView ajaxDoneError(String message) {
        return ajaxDone(300, message, "");
    }
    protected String getMessage(String code) {
        return this.getMessage(code, new Object[] {});
    }

    protected String getMessage(String code, Object arg0) {
        return getMessage(code, new Object[] { arg0 });
    }

    protected String getMessage(String code, Object arg0, Object arg1) {
        return getMessage(code, new Object[] { arg0, arg1 });
    }

    protected String getMessage(String code, Object arg0, Object arg1,
                                Object arg2) {
        return getMessage(code, new Object[] { arg0, arg1, arg2 });
    }

    protected String getMessage(String code, Object arg0, Object arg1,
                                Object arg2, Object arg3) {
        return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
    }
    protected String getMessage(String code, Object[] args) {
        //HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        Locale locale = localeResolver.resolveLocale(request);

        return messageSource.getMessage(code, args, locale);
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public FeedBack<String> exception(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        FeedBack<String> feedBack=new FeedBack<>("error","500","Inner error,the server can not perform correctly");
        return feedBack;
    }

}