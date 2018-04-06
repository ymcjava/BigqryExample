package com.bigquery.example;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;

/**
 * Examples for authenticating to Google BigQuery.
 *
 * <p>See: https://cloud.google.com/bigquery/authentication
 */
public class AuthExample {

  
  public static void implicit() {
    // Instantiate a client. If you don't specify credentials when constructing a client, the
    // client library will look for credentials in the environment, such as the
    // GOOGLE_APPLICATION_CREDENTIALS environment variable.
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

   
  }
  
  public static void explicit() throws IOException {
    // Load credentials from JSON key file. If you can't set the GOOGLE_APPLICATION_CREDENTIALS
    // environment variable, you can explicitly load the credentials file to construct the
    // credentials.
    GoogleCredentials credentials = null;
    File credentialsPath = new File("service_account.json");  
    FileInputStream serviceAccountStream = new FileInputStream(credentialsPath);
    try  {
      credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
    }catch(Exception e)
    {
    	e.printStackTrace();
    }

    // Instantiate a client.
    BigQuery bigquery =
        BigQueryOptions.newBuilder().setCredentials(credentials).
        							build().getService();

    
  }
  // [END explicit_service_account]

  public static void main(String args[]) throws IOException {
   
	String sample="implicit";
    if (sample.equals("implicit")) {
      implicit();
    } else {
      explicit();
    }
  }
}
