package com.ddj.entity.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: icho
 * @Date: 2024/10/9 17:25
 * @Describe:
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 搜索值 */
    @Getter
    @JsonIgnore
    private String searchValue;

    /** 创建者 */
    @Getter
    private String createBy;

    /** 创建时间 */
    @Getter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    @Getter
    private String updateBy;

    /** 更新时间 */
    @Getter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 备注 */
    @Getter
    private String remark;

    /** 请求参数 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> params;

    public void setSearchValue(String searchValue)
    {
        this.searchValue = searchValue;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
}
