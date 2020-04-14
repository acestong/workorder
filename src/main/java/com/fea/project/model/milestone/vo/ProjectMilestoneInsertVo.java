package com.fea.project.model.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.configure.annotations.base.NotNullAnno;
import lombok.Data;

import java.util.List;
@Data
public class ProjectMilestoneInsertVo<T> {
    private T model;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> deliveryIds;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> appendixs;
}
