package com.fea.project.api.other.service.pdt;

import com.fea.project.api.other.dao.pdt.PdtLibraryMapper;
import com.fea.project.api.other.model.pdt.PdtLibraryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/04.
 */
@Service
public class PdtLibraryService {

    @Autowired
    private PdtLibraryMapper pdtLibraryMapper;


    /**
     * 按主键选择
     */
    public PdtLibraryModel selectById(Long ID) {
        return ID == null ? null : this.pdtLibraryMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<PdtLibraryModel> selectByModel(PdtLibraryModel model) {
        return model == null ? new ArrayList<>(0) : this.pdtLibraryMapper.selectByModel(model);
    }

}