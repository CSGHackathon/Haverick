package com.haverick.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

public class Viewable {

	public String name;
	public String logoImageString;
	
	public Viewable(BufferedImage image, String name) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
		    ImageIO.write(image, "png", baos);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		logoImageString = "data:image/png;base64," +
		    DatatypeConverter.printBase64Binary(baos.toByteArray());
		
		this.name = name;
	}
	
}
