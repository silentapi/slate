package com.jowinkl.slate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jowinkl.slate.shows.MyAnimeListData;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		MyAnimeListData malData = MyAnimeListData.getFromId(38671);
		log.info(malData.toString());
	}
}