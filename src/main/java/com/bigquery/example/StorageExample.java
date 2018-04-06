package com.bigquery.example;


import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class StorageExample {
	
	public static void storage()
	{
		
		Storage storage = null;
	    storage = StorageOptions.getDefaultInstance().getService();
	
		    
		BlobId blobId = BlobId.of("gcp-public-data-nexrad-l2", "1991/06/05/KTLX/NWS_NEXRAD_NXL2LG_KTLX_19910605160000_19910605235959.tar");
		Blob blob = storage.get(blobId);
		      
		//ReadChannel readChannel = blob.reader();
		        
		System.out.println(blob);
		    
	}
	
	public static void main(String args[])
	{
		storage();
		
		
	}

}
