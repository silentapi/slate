package com.jowinkl.slate.shows;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyAnimeListDataTest {

	@Test
	public void testGetReadableTitle() {
		// Setup test data
		MyAnimeListData data = new MyAnimeListData();
		data.setTitle("japanese");
		data.setTitleEnglish("english");
		
		// Execute test;
		String title = data.getReadableTitle();
		
		// Verify
		assertEquals("english", title);
	}
	
	@Test
	public void testGetReadableTitle_noEnglish() {
		// Setup test data
		MyAnimeListData data = new MyAnimeListData();
		data.setTitle("japanese");
		data.setTitleEnglish(null);
		
		// Execute test;
		String title = data.getReadableTitle();
		
		// Verify
		assertEquals("japanese", title);
	}
	
}
