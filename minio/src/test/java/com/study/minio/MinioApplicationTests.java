package com.study.minio;

import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootTest
class MinioApplicationTests {

    @Resource
    private MinioClient minioClient;

    @Test
    void contextLoads() {


    }

    @Test
    void fastTest() throws Exception {
        boolean minioTest = minioClient.bucketExists(BucketExistsArgs.builder().bucket("minio-test").build());
        if (!minioTest) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("minio-test").build());
        }
        minioClient.uploadObject(UploadObjectArgs.builder()
                .bucket("minio-test")
                .object("微信图片_20210515185658.jpg")
                .filename("C:\\Users\\y2216\\Pictures\\Saved Pictures\\微信图片_20210515185658.jpg").build());
    }

}
