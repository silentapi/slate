package com.jowinkl.slate.shows;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ShowTest {

	private int EPISODE_COUNT = 24;
	private int[] MISSING = new int[] {1, 3, 5, 7, 9};

	@Test
	public void testGetMissingEpisodes() {
		// Setup test data
		List<Episode> episodes = new ArrayList<Episode>();
		for (int i = 1; i <= EPISODE_COUNT; i++) {
			boolean skip = false;
			for (int j = 0; j < MISSING.length; j++) {
				if (MISSING[j] == i) {
					skip = true;
					break;
				}
			}
			
			if (skip) {
				continue;
			}
			
			Episode episode = new Episode();
			episode.setNumber(i);
			episodes.add(episode);
		}
		
		Show data = new Show();
		data.setEpisodeCount(EPISODE_COUNT);
		data.setEpisodes(episodes);

		// Execute test;
		List<Integer> missing = data.getMissingEpisodes();
		
		// Verify
		assertEquals(MISSING.length, missing.size());
		for (int i = 0; i < MISSING.length; i++) {
			assertEquals(Integer.valueOf(MISSING[i]), missing.get(i));
		}
	}

}
