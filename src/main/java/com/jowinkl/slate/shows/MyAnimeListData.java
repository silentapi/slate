package com.jowinkl.slate.shows;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyAnimeListData {

	@JsonProperty("mal_id")
	private int mal_id;
	
	@JsonProperty("image_url")
	private String image_url;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("title_english")
	private String title_english;
	
	@JsonProperty("episodes")
	private int episodes;
	
	public MyAnimeListData() {
	}
	
	public int getId() {
		return mal_id;
	}
	
	public void setId(int mal_id) {
		this.mal_id = mal_id;
	}

	public String getImageUrl() {
		return image_url;
	}
	
	public void setImageUrl(String image_url) {
		this.image_url = image_url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitleEnglish() {
		return title_english;
	}
	
	public void setTitleEnglish(String title_english) {
		this.title_english = title_english;
	}
	
	public int getEpisodes() {
		return episodes;
	}
	
	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}
	
	public String getReadableTitle() {
		// If no english title available, use main title
		return getTitleEnglish() != null ? getTitleEnglish() : getTitle();
	}
	
	@Override
	public String toString() {
		return "MyAnimeListData{" +
				"mal_id='" + mal_id + "'" +
				", title='" + title + "'" +
				", title_english='" + title_english + "'" +
				", episodes='" + episodes + "'" +
				", image_url='" + image_url + "'" +
				"}";
	
	}
	
	private static final String JIKAN_URL = "https://api.jikan.moe/v3/anime/";
	
	public static MyAnimeListData getFromId(int id) {
		String url = JIKAN_URL + Integer.toString(id);
    	RestTemplate restTemplate = new RestTemplate();
    	MyAnimeListData malData = restTemplate.getForObject(url, MyAnimeListData.class);
    	return malData;
	}
}
