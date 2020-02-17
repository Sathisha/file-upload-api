package com.file.stream.controller;

import com.file.stream.model.CustomResponse;
import com.file.stream.model.NewFile;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileController {

    @RequestMapping(method = RequestMethod.POST, path = "sendFile", consumes = "application/json", produces = "application/json")
    public CustomResponse sendFile(@RequestBody NewFile newFile){


        System.out.println("inside Controller:" + newFile.toString());

        CustomResponse resp = new CustomResponse();
        resp.setRespMsg("Thank you!!!");
        return resp;
    }
    @RequestMapping(method = RequestMethod.GET, path = "sendFile2", consumes = "application/json", produces = "application/json")
    public CustomResponse sendFile2(@RequestParam (name = "newFile") String newFile){


        System.out.println("inside Controller:" + newFile.toString());

        CustomResponse resp = new CustomResponse();
        resp.setRespMsg(newFile);
        return resp;
    }

// curl -X POST -H "AuthCode: MyAuthC0de2020P@55w0rd" -F "file=@dummy.txt" http://localhost:8090/api/upload
 //   curl -X POST -H "AuthCode: MyAuthC0de2020P@55w0rd" -F "file=@dummy.txt" http://18.232.163.108:8090/api/upload
    @RequestMapping(method = RequestMethod.POST, path = "/api/upload" )
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile uploadfile) throws IOException {

        System.out.println("inside Controller:" + uploadfile.toString());
        System.out.println(uploadfile.getName());
        System.out.println(uploadfile.getContentType());
        System.out.println(uploadfile.getSize());
        System.out.println(uploadfile.getInputStream().toString());
        File file = new File(uploadfile.getOriginalFilename());
        FileInputStream inputStream = (FileInputStream) uploadfile.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(file);
        int numRead = 0;
        byte[] buf = new byte[1024];
        while ((numRead = inputStream.read(buf)) >= 0) {
            outputStream.write(buf, 0, numRead);
        }

inputStream.close();
        outputStream.close();


        return ResponseEntity.ok().body("Okay");
    }
}
