
package com.rayala.aws.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.rayala.aws.util.S3Helper;
@Service
public class S3Service {
	private static final String bucketName = "javaintegrate";
	private static final String DRIVING_LICENCE = "DL";

	public void uploadFile(InputStream fis) {

		try {
			AmazonS3 s3Client = S3Helper.getS3Client();
			System.out.println("Uploading a new object to S3 from a file\n");
			ObjectMetadata metadata = new ObjectMetadata();
			s3Client.putObject(new PutObjectRequest(bucketName,DRIVING_LICENCE, fis,metadata));

		} catch (AmazonServiceException ase) {
			ase.printStackTrace();
		} catch (AmazonClientException ace) {
			ace.printStackTrace();
		}
	}
}

