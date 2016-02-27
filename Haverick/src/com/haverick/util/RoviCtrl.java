package com.haverick.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
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

		try {
			templates = gson.fromJson(new FileReader(new File("TVGuide.json")), templates.getClass());
			templates = (LinkedTreeMap<String, Object>) templates.get("templates");
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(templates);
		getChannels();

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
