package com.div.S3File;

import com.amazonaws.AmazonClientException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.MultipleFileDownload;
import com.amazonaws.services.s3.transfer.Transfer;
import com.amazonaws.services.s3.transfer.TransferManager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
@Slf4j
@Data
@Configuration
public class AmazonS3Util {

    @Value("${s3.bucket.name}")
    private String s3BucketName;

    @Value("${aws.access.key.id}")
    private String awsAccessKeyId;

    @Value("${aws.secret.access.key}")
    private String awsSecretAccessKey;

    @Value("${aws.secret.s3.regionId}")
    private String s3RegionId;

    @Value("${s3.bucket.name}")
    private String bucketName;

    @Value("${file.path}")
    private Resource filepath;

    AWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);

    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(Regions.AP_SOUTH_1)
            .build();



    public void createBucket() {
        String bucketName = "ddkjojs32413-bucket";

        if (s3Client.doesBucketExist(bucketName)) {
            log.info("Bucket name is not available."
                    + " Try again with a different Bucket name.");
            return;
        }

        s3Client.createBucket(bucketName);
    }


    public void putObject() throws IOException, InterruptedException {
        String fileName = "Criteria_1";
        Reader reader = new InputStreamReader(filepath.getInputStream(), UTF_8);
        String filePath =  FileCopyUtils.copyToString(reader);
        s3Client.putObject(
                bucketName,
                fileName,
                new File(filePath)
        );
        // tmp
        new File(filePath).delete();
        System.out.println(fileName+" deleted from tmp");

        // Bucket delete
        synchronized (this){
            this.wait(15000);
            deletePrefixObject(s3BucketName, "Summer");
            System.out.println(fileName+" deleted from S3");
        }

    }

    public void listBucket() {
        List<Bucket> buckets = s3Client.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(bucket.getName());
        }
    }

    public void listObjects(){
        ObjectListing objectListing = s3Client.listObjects(s3BucketName);
        for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
            log.info(os.getKey());
        }
    }
    public void deleteS3Objects(String bucketName, List<String> list){
        for (String s : list) {
            s3Client.deleteObject(bucketName, s);
        }
    }

    public void deleteCriteriaObject(String bucketName){
        deletePrefixObject(bucketName, "Criteria");
    }
    public void deletePrefixObject(String bucketName, String pattern){
        ObjectListing objectListing = s3Client.listObjects(bucketName);
        log.info("object Listing" + objectListing);
        List<S3ObjectSummary> objectSummaries = objectListing.getObjectSummaries();
        log.info("object Summaries" + objectSummaries);

        List<String> criteriaKeyList = objectSummaries.stream().map(S3ObjectSummary::getKey).filter(e -> e.contains(pattern)).collect(Collectors.toList());
        log.info("object criteriaKeyList" + criteriaKeyList);

        deleteS3Objects(bucketName, criteriaKeyList);
        log.info("Deleted all Criteria");
    }
}
