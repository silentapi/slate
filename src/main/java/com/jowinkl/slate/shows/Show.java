package com.jowinkl.slate.shows;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Show {

	@Id
	private String id;
	
	private int malId;
	private String title;
	private String posterUrl;
	private State state;
	private SaveDir saveDir;
	private QueryFormat query;
	private String filename;
	private int episodeCount;
	private int episodeCurrent;
	private List<Episode> episodes;
	
	public Show() {
	}
	
	public Show(int malId, QueryFormat query, SaveDir saveDir, String filename) {
		this.setMALId(malId);
		this.setState(State.CREATED);
		this.setSaveDir(saveDir);
		this.setQueryFormat(query);
		this.setEpisodes(new ArrayList<>());
		this.setFilename(filename);
	}
	
	public Show(MyAnimeListData malData, QueryFormat query, SaveDir saveDir, String filename) {
		this(malData.getId(), query, saveDir, filename);
		this.setState(State.SETTING_UP);
		populate(malData);
	}
	
	public void populate(MyAnimeListData malData) {
		this.setTitle(malData.getReadableTitle());
		this.setEpisodeCount(malData.getEpisodes());
		this.setPosterUrl(malData.getImageUrl());
	}
	
	public boolean isFinishedAiring() {
		return getEpisodeCurrent() == getEpisodeCount();
	}
	
	public List<Integer> getMissingEpisodes() {
		List<Integer> missingEpisodes = new ArrayList<>();
		for (int i = 1; i <= getEpisodeCount(); i++) {
			missingEpisodes.add(i);
		}
		for (Episode episode : getEpisodes()) {
			missingEpisodes.remove(Integer.valueOf(episode.getNumber()));
		}
		return missingEpisodes;
	}
	
	public int getMALId() {
		return malId;
	}

	public void setMALId(int malId) {
		this.malId = malId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public SaveDir getSaveDir() {
		return saveDir;
	}

	public void setSaveDir(SaveDir saveDir) {
		this.saveDir = saveDir;
	}

	public QueryFormat getQueryFormat() {
		return query;
	}

	public void setQueryFormat(QueryFormat query) {
		this.query = query;
	}

	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public int getEpisodeCurrent() {
		return episodeCurrent;
	}

	public void setEpisodeCurrent(int episodeCurrent) {
		this.episodeCurrent = episodeCurrent;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	public enum State {
		CREATED,
		SETTING_UP,
		WAITING,
		AIRING,
		MISSING,
		FINISHED
	}
	
}
