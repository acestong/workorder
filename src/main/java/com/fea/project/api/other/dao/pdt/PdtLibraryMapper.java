package com.fea.project.api.other.dao.pdt;

import com.fea.project.api.other.model.pdt.PdtLibraryModel;

import java.util.List;

/**
 * Created by Administrator on 2019/12/04.
 */
public interface PdtLibraryMapper {

    /**
     * 按主键选择
     */
    PdtLibraryModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<PdtLibraryModel> selectByModel(PdtLibraryModel model);

}