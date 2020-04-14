package com.fea.project.api.other.model.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.crm.CrmDictionaryIndustryModel;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/3/16 18:56
 **/
@Data
public class CrmDictionaryIndustryVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;
    private List<CrmDictionaryIndustryVo> children;

    public CrmDictionaryIndustryVo(CrmDictionaryIndustryModel crmDictionaryIndustryModel) {
        this.id = crmDictionaryIndustryModel.getID();
        this.name = crmDictionaryIndustryModel.getNAME();
        this.parentId = crmDictionaryIndustryModel.getPARENTID();
    }

    public static List<CrmDictionaryIndustryVo> createListByCrmDictionaryIndustryModel(List<CrmDictionaryIndustryModel> list){
        Map<Long, CrmDictionaryIndustryVo> map = list.stream().collect(Collectors.toMap(CrmDictionaryIndustryModel::getID, CrmDictionaryIndustryVo::new));
        List<CrmDictionaryIndustryVo> finalList = new ArrayList<>();
        list.forEach(x -> {
            if(x.getPARENTID() == null){
                finalList.add(map.get(x.getID()));
            }else{
                CrmDictionaryIndustryVo tmpModel = map.get(x.getPARENTID());
                if(tmpModel != null){
                    List<CrmDictionaryIndustryVo> children = null;
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
