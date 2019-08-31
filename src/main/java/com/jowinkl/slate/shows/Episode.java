package com.jowinkl.slate.shows;

import java.util.Date;

public class Episode {

	public static final String EPISODE = "{episode}";
	public static final String FILETYPE = "{filetype}";
	public static final String INFOHASH = "{infohash}";
	public static final String TITLE = "{title}";
	public static final String MAGNET = "magnet:?xt=urn:btih:{infohash}&dn={title}";
	
	private int number;
	private Date date;
	private String fileType;
	private String magnet;
	
	public Episode() {
	}
	
	public Episode(int number) {
		this.number = number;
	}
	
	public void populate(NyaaData nyaaData) {
		this.date = nyaaData.getDate();
		this.fileType = getFileTypeFromFile(nyaaData.getTitle());
		this.magnet = generateMagnet(nyaaData.getInfoHash(), nyaaData.getTitle());
	}
	
	public String getFilename(String filename) {
		return filename.replace(EPISODE, Integer.toString(number))
				.replace(FILETYPE, fileType);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public String getMagnet() {
		return magnet;
	}

	public void setMagnet(String magnet) {
		this.magnet = magnet;
	}
	
	private static String getFileTypeFromFile(String filename) {
		String[] parts = filename.split(".");
		return parts[parts.length - 1];
	}
	
	private static String generateMagnet(String infoHash, String title) {
		return MAGNET.replace(INFOHASH, infoHash).replace(TITLE, title);
	}
}
