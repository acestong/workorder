package com.fea.project.model.projectdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class DataTeamVo {
    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    /**
     * 类型标识（团队或人员）
     */
    private Integer tag;
    /**
     * 类型id（团队id或人员id）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

}
