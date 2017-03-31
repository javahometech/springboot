package com.rayala.aws.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

public class S3Helper {
	
	private final static String SECRET_ID="AKIAJDAUUGR6QEKEZSCA";
	private final static String SECRET_ACCESS_KEY="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";
	private static final AWSCredentials Credentails = new BasicAWSCredentials(SECRET_ID,SECRET_ACCESS_KEY);
    public static AWSCredentials getAWSCredentials(){
    	return Credentails;
    }		
    public static  AmazonS3 getS3Client(){
    	AmazonS3 s3Client = new AmazonS3Client(getAWSCredentials());
		s3Client.setEndpoint("http://s3-us-west-1.amazonaws.com");
		return s3Client;
    }
}
