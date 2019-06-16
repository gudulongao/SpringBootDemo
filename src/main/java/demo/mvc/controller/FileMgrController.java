package demo.mvc.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileMgrController {
    private static Logger log = LoggerFactory.getLogger(FileMgrController.class);
    private static final String TEMP_FILE_PATH = "/Users/tanglei";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file) {
        log.debug("start create new file,file name :" + file.getOriginalFilename());
        try {
            FileUtils.writeByteArrayToFile(new File(TEMP_FILE_PATH + File.separator + file.getOriginalFilename()), file
                    .getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("done!");
        return "fail";
    }
}
