package com.fea.project.service.flowdetailconfig;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.enums.project.ProjectResourceEnum;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/10 11:33
 * 项目创建审批
 **/
@Service
public class ProjectCreateVerifyService {


    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    @Autowired
    private SysUserService sysUserService;

    public List<ProjectDictionaryItemSelectVo> selectDictionaryList(String shortName) {
        Long regId = UserUtil.getUserRegId();
        return projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(
                new ProjectDictionaryModel(shortName, regId));
    }

    public Object selectProjectResource() {
        return ProjectResourceEnum.getProjectResource();
    }

    public Object selectRegUsers() {
        Long regId = UserUtil.getUserRegId();
        List<SysUserModel> list = this.sysUserService.selectByRegId(regId);
        return list.stream().map(tmp -> {
            Map<String, String> map = new HashMap<>(16);
            map.put("id", tmp.getUserId() + "");
            map.put("name", tmp.getRealName());
            return map;
        }).collect(Collectors.toList());
    }
}
