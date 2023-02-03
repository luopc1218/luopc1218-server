package com.luopc1218.luopc1218server.util.minio;

import io.minio.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Minio {
    static String bucketName = "luopc1218";

    @Value("${minio.endpoint}")
    private String endpoint;

    @Autowired
    private MinioClient minioClient;

    public String upload(MultipartFile file) {
        try {
            String originalFileName = file.getOriginalFilename();
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(bucketName).object(originalFileName).contentType(file.getContentType()).stream(file.getInputStream(), file.getSize(), -1).build();
            minioClient.putObject(objectArgs);
            String previewUrl = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(bucketName).object(originalFileName).build());
//            System.out.println(previewUrl);
            return endpoint + '/' + bucketName + "/" + originalFileName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
