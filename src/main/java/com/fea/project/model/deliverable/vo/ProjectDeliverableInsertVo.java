package com.fea.project.model.deliverable.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class ProjectDeliverableInsertVo<T> {


    private T model;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> appendixs;

}
