package com.fea.project.model.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data
public class ProjectMilestoneDeliveryInsertVo<T> {
    private T model;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> appendixs;
}
