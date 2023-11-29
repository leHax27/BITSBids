package com.bitsbids.demo.services;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class storageService {

    private static final Logger log = LoggerFactory.getLogger(storageService.class);
//    @Value("${application.bucket.name}")
    private String bucketName="bitsbids";

    @Autowired
    private AmazonS3 s3Client;
    public String uploadFile(MultipartFile file)
    {
        File fileObj=convertMultitoFile(file);
        String fileName=System.currentTimeMillis()+" "+file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName,fileName,fileObj));
        fileObj.delete();
        return "File Uploaded : " + fileName;
    }

    public byte[] downloadFile(String fileName)
    {
        S3Object s3Obj= s3Client.getObject(bucketName,fileName);
        S3ObjectInputStream inputStream= s3Obj.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public String deleteFile (String fileName)
    {
        s3Client.deleteObject(bucketName,fileName);
        return fileName+ "removed...";
    }
    private File convertMultitoFile (MultipartFile file)
    {
        File convertedFile= new File(file.getOriginalFilename());
        try (FileOutputStream fos= new FileOutputStream((convertedFile)))
        {
            fos.write((file.getBytes()));
        }
        catch (IOException e)
        {
            log.error("Error converting Multi-Part file to one file", e);
        }
        return convertedFile;
    }
}
