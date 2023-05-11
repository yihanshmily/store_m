package com.lry.store.comtroller;

import com.lry.store.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @Value("${file.path}")
    private String basePath;


    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        file.transferTo(new File(basePath + originalFilename));
        return R.success(originalFilename);
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletResponse response){
        String newName = name.replace("\uFEFF", "");
        try{
            FileInputStream fis = new FileInputStream(new File(basePath + newName));
            ServletOutputStream outputStream = response.getOutputStream();

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
            outputStream.close();
            fis.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
