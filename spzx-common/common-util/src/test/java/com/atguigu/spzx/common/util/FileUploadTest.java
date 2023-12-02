package com.atguigu.spzx.common.util;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.FileInputStream;

public class FileUploadTest {

    public static void main(String[] args) throws Exception {
        // 创建一个Minio的客户端对象
        MinioClient minioClient = MinioClient.builder()
                .endpoint("http://192.168.195.31:9000")
                .credentials("minio", "12345678")
                .build();

        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("spzx-bucket").build());

        // 如果不存在，那么此时就创建一个新的桶
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("spzx-bucket").build());
        } else {  // 如果存在打印信息
            System.out.println("Bucket 'spzx-bucket' already exists.");
        }

        FileInputStream fis = new FileInputStream("C:\\Users\\user\\Pictures\\TX10005_00.jpg") ;
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket("spzx-bucket")
                .stream(fis, fis.available(), -1)
                .object("TX10005_00.jpg")
                .build();
        minioClient.putObject(putObjectArgs) ;

        // 构建fileUrl
        String fileUrl = "http://192.168.195.31:9000/spzx-bucket/TX10005_00.jpg" ;
        System.out.println(fileUrl);

//        FileInputStream fileInputStream = null;
//        try {
//
//            fileInputStream =  new FileInputStream("E:\\list.html");;
//
//            //1.创建minio链接客户端
//            MinioClient minioClient = MinioClient.builder()
//                    .credentials("minio", "12345678")
//                    .endpoint("http://192.168.195.31:9000").build();
//            //2.上传
//            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
//                    .object("list.html")//文件名
//                    .contentType("text/html")//文件类型
//                    .bucket("spzx-bucket")//桶名词  与minio创建的名词一致
//                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
//                    .build();
//            minioClient.putObject(putObjectArgs);
//
////            System.out.println("http://192.168.195.31:9000/spzx-bucket/TX10005_00.jpg");
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
}