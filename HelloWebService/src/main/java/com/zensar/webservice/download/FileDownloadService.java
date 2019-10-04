package com.zensar.webservice.download;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class FileDownloadService {
	private static final String textFile = "D:/Dipankar/mavennotes.txt";
	private static final String imageFile = "D:/Dipankar/customer_img.jpg";
	private static final String pdfFile = "D:/SQL/Introduction.pdf";
	@GET
	@Path("/text")
	@Produces("text/plain")
	public Response getTextFile() {
		File file = new File(textFile);
		ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment;filename=mavennotes.txt");
		return responseBuilder.build();
	}
	@GET
	@Path("/image")
	@Produces("image/jpg")
	public Response getImageFile() {
		File file = new File(imageFile);
		ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment;filename=customer_img.jpg");
		return responseBuilder.build();
	}
	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getPdfFile() {
		File file = new File(pdfFile);
		ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment;filename=Introduction.pdf");
		return responseBuilder.build();
	}
}
