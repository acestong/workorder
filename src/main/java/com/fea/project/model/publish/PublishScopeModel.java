package com.fea.project.model.publish;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PublishScopeModel implements Serializable {
//	可见范围id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishScopeId;
//    动态发布id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishId;
//    范围类型，部门为0，个人为1，目前前端暂定全传个人,来源于ScopeEnum枚举
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long scopeType;
//范围类型为为0时，传入部门id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long scopeDepartmentId;
//    范围类型为为0时，传入部门名称
    private String scopeDepartmentName;
//    范围为1时，传入个人id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long scopePersonId;
//    范围为1时，传入个人姓名
    private String scopePersonName;

    private static final long serialVersionUID = 1L;

}