package com.fea.project.controller.util;

import com.fea.project.enums.base.RequestReturnCodeEnum;
import com.fea.project.model.base.AppendixModel;
import com.fea.project.model.base.BaseResultModel;
import com.fea.project.service.base.AppendixService;
import com.fea.project.util.FileSizeUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("filesUploadDown")
public class FilesUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilesUploadController.class);

    @Value("${spring.fileupload.destination}")
    private String destination;

    @Autowired
    private AppendixService appendixService;


    /**
     * 上传
     *
     * @param request
     * @param files
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public BaseResultModel filesUpload(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) {
        try {
            List<AppendixModel> list = new ArrayList<AppendixModel>();

            // 构建上传文件的存放路径
            String destionation = destination + File.separator;
            System.out.println("destionation = " + destionation);

            // 如果文件不为空，写入上传路径，进行文件上传
            if (null != files && files.length > 0) {
                for (MultipartFile file : files) {
                    // 测试MultipartFile接口的各个方法
                    AppendixModel entity = new AppendixModel();
                    System.out.println("文件类型ContentType=" + file.getContentType());
                    System.out.println("文件组件名称Name=" + file.getName());
                    System.out.println("文件原名称OriginalFileName=" + file.getOriginalFilename());
                    entity.setRealName(file.getOriginalFilename());
                    System.out.println("文件大小Size=" + file.getSize() + "byte or " + file.getSize() / 1024 + "KB");
                    saveFile(file, destionation, entity, list, request);

                }
                return RequestReturnCodeEnum.createRightModel(list);
            } else {
                LOGGER.debug("文件为空");
                return RequestReturnCodeEnum.createFailureModel(null, RequestReturnCodeEnum.CODE_REQUEST_EXCEPTION, "文件为空");
            }
        } catch (Exception ex) {
            return RequestReturnCodeEnum.createFailureModel(null, RequestReturnCodeEnum.CODE_SYSTEM_ERROR);
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
    private String saveFile(MultipartFile file, String destination, AppendixModel entity, List<AppendixModel> list, HttpServletRequest request) throws Exception {
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
            entity.setUrl(filename);
            entity.setFileSize(FileSizeUtil.translateFileSizeToFitableUnit(file.getSize()));
            entity = appendixService.insertModel(entity, request);
            list.add(entity);
        } catch (Exception ex) {
            throw new Exception();
        }
        return targetFilePath;
    }


    @RequestMapping("download")
    public void filesDownLoad(HttpServletResponse res, String id) {
        LOGGER.debug("下载文件开始");
        String path = "";
        //根据id获取文件信息
        if (StringUtils.isNotEmpty(id)) {
            Long appendixId = Long.parseLong(id);
            AppendixModel fileEntity = appendixService.selectById(appendixId);
            path = destination + File.separator + fileEntity.getUrl();
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
