package com.haverick.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import javax.ws.rs.core.MediaType;
import com.damnhandy.uri.template.UriTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;


public class RoviCtrl {
	private Gson gson;
	private LinkedTreeMap<String, Object> templates;
	private final String USER_AGENT = "Mozilla/5.0";
	private final int providerID = 1063353159;

	@SuppressWarnings("unchecked")
	public RoviCtrl() {
		templates = new LinkedTreeMap<String, Object>();
		gson = new GsonBuilder().setPrettyPrinting().create();
		InputStream input;
		try {
			String jsonString=getFile("TVGuide.json");
			//templates = gson.fromJson(jsonString), templates.getClass());
			templates = (LinkedTreeMap<String, Object>) templates.get("templates");
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println(templates);
		getChannels();

	}
	
	private String getFile(String fileName) {

		StringBuilder result = new StringBuilder("");

		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result.toString();

	  }


	@SuppressWarnings("unchecked")
	public List<Channel> getChannels() {
		String uri = (String) ((LinkedTreeMap<String, Object>) templates.get("data_service_channels")).get("bulk");

		String url = UriTemplate.fromTemplate(uri).set("id", providerID).set("page", "1").expand();

		Client client = ClientBuilder.newClient();
		Response response = client
				.target(url)
				.request(MediaType.TEXT_PLAIN_TYPE).get();

		System.out.println("status: " + response.getStatus());
		System.out.println("headers: " + response.getHeaders());
		System.out.println("body:" + response.readEntity(String.class));
		
		return null;
	}
}
