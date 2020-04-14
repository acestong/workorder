package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评论model
 * @author st
 * @since 2020/04/01
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel implements Serializable {
    private Long commentId;

    private Long workorderId;

    private Double qualityWeight;

    private Double qualityScore;

    private Double timeWeight;

    private Double timeScore;

    private Double satisfyWeight;

    private Double satisfyScore;
    
    private Double score;

    private String remark;

    private Long createRole;

    private Long createId;

    private String createBy;

    private Date createTime;

    private static final long serialVersionUID = 1L;

}