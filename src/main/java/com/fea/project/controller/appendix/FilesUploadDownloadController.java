package com.fea.project.controller.appendix;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.appendix.AppendixId;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.util.FileSizeUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("filesUploadDownload")
public class FilesUploadDownloadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilesUploadDownloadController.class);

    @Value("${spring.fileupload.destination}")
    private String destination;

    @Autowired
    private ProjectAppendixService appendixService;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 上传
     *
     * @param request
     * @param files
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public List<ProjectAppendixModel> filesUpload(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) throws Exception{
            List<ProjectAppendixModel> list = new ArrayList<>();

            // 构建上传文件的存放路径
            String destionation = destination + File.separator;
            System.out.println("destionation = " + destionation);

            // 如果文件不为空，写入上传路径，进行文件上传
            if (null != files && files.length > 0) {
                for (MultipartFile file : files) {
                    // 测试MultipartFile接口的各个方法
                    ProjectAppendixModel entity = new ProjectAppendixModel();
                    //System.out.println("文件类型ContentType=" + file.getContentType());
                    //System.out.println("文件组件名称Name=" + file.getName());
                    //System.out.println("文件原名称OriginalFileName=" + file.getOriginalFilename());
                    entity.setRealName(file.getOriginalFilename());
                    //entity.setName("");
                    //System.out.println("文件大小Size=" + file.getSize() + "byte or " + file.getSize() / 1024 + "KB");
                    //创建人信息
                    SysUserModel currentUsr = sysUserService.getCurrentUsr();
                    String userName = currentUsr.getRealName();
                    entity.setCreateBy(userName);
                    entity.setCreateTime(new Date());
                    entity.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
                    saveFile(file, destionation, entity, list, request);

                }
                return list;
            } else {
                LOGGER.debug("文件为空");
                throw new SystemParamCheckException("文件为空");
            }
    }
    /**
     * 文件保存方法
     *
     * @param file
     * @param destination
     * @param entity
     * @param list
     * @param request
     * @return
     */
    private String saveFile(MultipartFile file, String destination, ProjectAppendixModel entity, List<ProjectAppendixModel> list, HttpServletRequest request) throws Exception {
        // 获取上传的文件名称，并结合存放路径，构建新的文件名称
        String filename = file.getOriginalFilename();
        String ext = null;
        if (filename.contains(".")) {
            ext = filename.substring(filename.lastIndexOf("."));
        } else {
            ext = "";
        }
        String timeSuffix = String.valueOf(System.currentTimeMillis());
        filename = timeSuffix + ext;
        File filepath = new File(destination, filename);

        // 判断路径是否存在，不存在则新创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        String targetFilePath = destination + File.separator + filename;
        // 将上传文件保存到目标文件目录
        try {
            file.transferTo(new File(targetFilePath));
            // 调用附件表数据
            entity.setUrl(destination +filename);
            entity.setFileSize(FileSizeUtil.translateFileSizeToFitableUnit(file.getSize()));
            entity = appendixService.insertSelective(entity);
            list.add(entity);
        } catch (Exception ex) {
            throw new Exception();
        }
        return targetFilePath;
    }


    @RequestMapping("download/{id}")
    public void filesDownLoad(HttpServletResponse res, @PathVariable("id") String id) throws UnsupportedEncodingException {
        LOGGER.debug("下载文件开始");
        String path = "";
        //根据id获取文件信息
        if (StringUtils.isNotEmpty(id)) {
            Long appendixId = Long.parseLong(id);
            ProjectAppendixModel fileEntity = appendixService.selectById(appendixId);
            path =  File.separator + fileEntity.getUrl();
            String realName = fileEntity.getRealName();
            res.setHeader("Content-Disposition", "attachment;filename=" + new String(realName.getBytes(),"ISO8859-1"));
        }
        if (StringUtils.isNotEmpty(path)) {
            res.setHeader("content-type", "application/octet-stream; charset=utf-8");
            res.setContentType("application/octet-stream");
            byte[] buff = new byte[1024];
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                File file = new File(path);
                os = res.getOutputStream();
                bis = new BufferedInputStream(new FileInputStream(file));
                int i = bis.read(buff);
                while (i != -1) {
                    Integer len;
                    len = buff.length;
                    os.write(buff, 0, len);
                    os.flush();
                    i = bis.read(buff);
                    res.setHeader("Content-Length", len == null ? "0" : len.toString());
                    res.setHeader("Content-Encoding", "UTF-8");
                }
            } catch (IOException e) {
                LOGGER.error("文件下载报错->" + e);
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        LOGGER.error("流关闭报错:" + e);
                    }
                }
            }
            System.out.println("success");

        } else {
            LOGGER.debug("路径为空");
        }

        LOGGER.debug("下载文件结束");
    }
    @RequestMapping("download")
    public void filesDownLoadPost(HttpServletResponse res, @RequestBody AppendixId model) {
        LOGGER.debug("下载文件开始");
        String path = "";
        //根据id获取文件信息
        if (model.getId()!=null) {
            ProjectAppendixModel fileEntity = appendixService.selectById(model.getId());
            path =  File.separator + fileEntity.getUrl();
            System.out.println(path);
            res.setHeader("Content-Disposition", "attachment;filename=" + fileEntity.getRealName());
        }
        if (StringUtils.isNotEmpty(path)) {
            res.setHeader("content-type", "application/octet-stream; charset=utf-8");
            res.setContentType("application/octet-stream");
            byte[] buff = new byte[1024];
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                File file = new File(path);
                os = res.getOutputStream();
                bis = new BufferedInputStream(new FileInputStream(file));
                int i = bis.read(buff);
                while (i != -1) {
                    Integer len;
                    len = buff.length;
                    os.write(buff, 0, len);
                    os.flush();
                    i = bis.read(buff);
                    res.setHeader("Content-Length", len == null ? "0" : len.toString());
                    res.setHeader("Content-Encoding", "UTF-8");
                }
            } catch (IOException e) {
                LOGGER.error("文件下载报错->" + e);
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        LOGGER.error("流关闭报错:" + e);
                    }
                }
            }
            System.out.println("success");

        } else {
            LOGGER.debug("路径为空");
        }

        LOGGER.debug("下载文件结束");
    }
}
