package com.jowinkl.slate.shows;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EpisodeTest {

	private static final String FILENAME_FORMAT = "Name " + Episode.EPISODE + "." + Episode.FILETYPE;
	private static final int EPISODE = 1;
	private static final String FILETYPE = ".mkv";
	private static final String FILENAME = "Name " + EPISODE + "." + FILETYPE;

	@Test
	public void testGetFilename() {
		// Setup test data
		Episode data = new Episode();
		data.setNumber(1);
		data.setFileType(".mkv");

		// Execute test;
		String filename = data.getFilename(FILENAME_FORMAT);

		// Verify
		assertEquals(FILENAME, filename);
	}

}
