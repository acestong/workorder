package com.fea.project.model.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/10/18.
 */
@Data
public class ProjectRoleAuthorityDisableModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long authorityId;
}