package com.zensar.webservice.download;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class FileDownloadService {

	private static final String textfile = "D:\\a.txt";

	@GET
	@Path("/text")
	@Produces("text/plain")
	public Response getTextFile() {
		File f = new File(textfile);
		ResponseBuilder builder = Response.ok(f);
		builder.header("Content-Disposition", "attachment;filename=a.txt");
		return builder.build();

	}

	private static final String imagefile = "D:\\profile.jpg";

	@GET
	@Path("/img")
	@Produces("image/jpg")
	public Response getImageFile() {
		File f = new File(imagefile);
		ResponseBuilder builder = Response.ok(f);
		builder.header("Content-Disposition", "attachment;filename=image.jpg");
		return builder.build();
	}
	private static final String pdffile = "D:\\s.pdf";

	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getPdfFile() {
		File f = new File(pdffile);
		ResponseBuilder builder = Response.ok(f);
		builder.header("Content-Disposition", "attachment;filename=sample.pdf");
		return builder.build();
	}
}
