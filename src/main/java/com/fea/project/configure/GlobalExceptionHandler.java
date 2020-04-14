package com.fea.project.configure;

import com.fea.project.configure.exception.LoginStateIllegalException;
import com.fea.project.configure.exception.PriorityIllegalException;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.base.RequestReturnCodeEnum;
import com.fea.project.model.base.BaseResultModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/4/23 15:32
 * 全局异常处理
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {

    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResultModel errorHandler(Exception ex) {
        ex.printStackTrace();
        if(ex instanceof LoginStateIllegalException){
            return RequestReturnCodeEnum.createFailureModel(ex.getMessage(), RequestReturnCodeEnum.CODE_REQUEST_OVERTIME);
        } else if (ex instanceof SystemParamCheckException) {
            return RequestReturnCodeEnum.createFailureModel(((SystemParamCheckException) ex).getAlarmMsg(), RequestReturnCodeEnum.CODE_REQUEST_EXCEPTION, ex.getMessage());
        }else if (ex instanceof PriorityIllegalException){
            return RequestReturnCodeEnum.createFailureModel(ex.getMessage(), RequestReturnCodeEnum.CODE_REQUEST_EXCEPTION);
        }
        return RequestReturnCodeEnum.createFailureModel(null, RequestReturnCodeEnum.CODE_SYSTEM_ERROR);
    }


}
