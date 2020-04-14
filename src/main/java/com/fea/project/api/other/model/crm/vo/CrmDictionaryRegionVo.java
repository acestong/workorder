package com.fea.project.api.other.model.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.crm.CrmDictionaryRegionModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/3/16 18:56
 **/
@Data
public class CrmDictionaryRegionVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;
    private List<CrmDictionaryRegionVo> children;

    public CrmDictionaryRegionVo(CrmDictionaryRegionModel crmDictionaryRegionModel) {
        this.id = crmDictionaryRegionModel.getID();
        this.name = crmDictionaryRegionModel.getNAME();
        this.parentId = crmDictionaryRegionModel.getPARENTID();
    }

    public static List<CrmDictionaryRegionVo> createListByCrmDictionaryRegionModel(List<CrmDictionaryRegionModel> list){
        Map<Long, CrmDictionaryRegionVo> map = list.stream().collect(Collectors.toMap(CrmDictionaryRegionModel::getID, CrmDictionaryRegionVo::new));
        List<CrmDictionaryRegionVo> finalList = new ArrayList<>();
        list.forEach(x -> {
            if(x.getPARENTID() == null){
                finalList.add(map.get(x.getID()));
            }else{
                CrmDictionaryRegionVo tmpModel = map.get(x.getPARENTID());
                if(tmpModel != null){
                    List<CrmDictionaryRegionVo> children = null;
                    if(tmpModel.getChildren() == null){
                        children = new ArrayList<>();
                        tmpModel.setChildren(children);
                    }else{
                        children = tmpModel.getChildren();
                    }
                    children.add(map.get(x.getID()));
                }
            }
        });
        return finalList;
    }

}
