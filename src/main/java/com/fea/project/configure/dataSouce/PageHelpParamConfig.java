package com.fea.project.configure.dataSouce;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/29 14:54
 **/
@Configuration
@ConfigurationProperties(prefix = "pagehelper")
public class PageHelpParamConfig {

    private Boolean offsetAsPageNum;
    private Boolean rowBoundsWithCount;
    private Boolean pageSizeZero;
    private Boolean reasonable;
    private Boolean supportMethodsArguments;

    private Properties properties;

    @PostConstruct
    public void initProperties() {
        Properties tmp = new Properties();
        tmp.put("offsetAsPageNum", offsetAsPageNum + "");
        tmp.put("rowBoundsWithCount", rowBoundsWithCount + "");
        tmp.put("pageSizeZero", pageSizeZero + "");
        tmp.put("reasonable", reasonable + "");
        tmp.put("supportMethodsArguments", supportMethodsArguments + "");
        properties = tmp;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Boolean getOffsetAsPageNum() {
        return offsetAsPageNum;
    }

    public void setOffsetAsPageNum(Boolean offsetAsPageNum) {
        this.offsetAsPageNum = offsetAsPageNum;
    }

    public Boolean getRowBoundsWithCount() {
        return rowBoundsWithCount;
    }

    public void setRowBoundsWithCount(Boolean rowBoundsWithCount) {
        this.rowBoundsWithCount = rowBoundsWithCount;
    }

    public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    public Boolean getReasonable() {
        return reasonable;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }

    public Boolean getSupportMethodsArguments() {
        return supportMethodsArguments;
    }

    public void setSupportMethodsArguments(Boolean supportMethodsArguments) {
        this.supportMethodsArguments = supportMethodsArguments;
    }
}
