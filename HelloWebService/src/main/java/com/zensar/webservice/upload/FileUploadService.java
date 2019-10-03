package com.zensar.webservice.upload;



import java.io.FileOutputStream;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload")
public class FileUploadService {
	@POST
	@Path("/up")
	@Produces("text/plain")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("myfile") InputStream is, @FormDataParam("myfile") FormDataContentDisposition filedetails) {
	String fl = "D://uploads/"+filedetails.getFileName();
	FileOutputStream fos= new FileOutputStream(fl);
	byte[] b = new byte[1024];
	int data =0;
	while((data = is.read(b)) != -1) {
		fos.write(b, 0 ,data);
		
	}
	fos.flush();
	fos.close();
	
	}
}
