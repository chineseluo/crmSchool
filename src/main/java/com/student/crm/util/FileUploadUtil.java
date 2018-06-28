package com.student.crm.util;

import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

public class FileUploadUtil {
    public FileUploadUtil() {
    }

    public static String uploadFile(InputStream in, HttpServletRequest request, String fileName) throws Exception {
        String uuid = UUID.randomUUID().toString();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        fileName = uuid + fileType;
        String path = request.getRealPath("/static/upload");
        File targetFile = new File(path, fileName);
        FileUtils.copyInputStreamToFile(in, targetFile);
        return "/static/upload/" + fileName;
    }

    public static void deleteFile(String pic, HttpServletRequest request) {
        String path = request.getRealPath("/") + pic;
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }

    }
}
