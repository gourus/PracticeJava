package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * This Class functionality is same like "https://tinyurl.com/"
 * 
 * This class gives us the tiny URL for a given big URL with the length from 6
 * to 10 characters.
 * 
 * This is just a Core functionality of creating and returning a tiny URL.
 * 
 * We are only considering the number of URLs we can support. And for storage we
 * are using HashTable (Which is not preferable for real world design.)
 * 
 * We are not using Base62 or Base64 models to get the tiny URL. Simply
 * returning a random string with all the lower alphabets.
 * 
 * Example:
 * 
 * Input: www.google.com 
 * Output: https://www.gourusTinyUrl.com/......
 * 
 * @author sgouru
 */

public class TinyURL {

	private Map<String, String> shortToLongUrlMap = new HashMap<String, String>();
	private Map<String, String> longToShortUrlMap = new HashMap<String, String>();

	private final String BASE_URL = "https://www.gourusTinyUrl.com/";
	private final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";

	// TODO: We can have getters and setters for lengths
	public int minUrlLength = 6;
	public int maxUrlLength = 10;

	/**
	 * This method takes the long URL and returns the Short URL.
	 * 
	 * @param url - Long URL
	 * @return - Short URL - e.g. https://www.gourusTinyUrl.com/......
	 */
	public String getTinyUrl(String url) {

		// Base conditions
		if (url == null || url.isEmpty() /* Or we can add any regex check for URL patern */) {
			return null;
		}

		// Return if the Tiny Url is already calculated
		if (longToShortUrlMap.containsKey(url)) {
			return BASE_URL + longToShortUrlMap.get(url);
		}

		StringBuilder urlBuilder = new StringBuilder();

		Random random = new Random();
		
		// Get the Random number between Min and Max length of URL.
		int tinyUrlLength = random.nextInt(maxUrlLength - minUrlLength + 1) + minUrlLength;

		for (int i = 0; i < tinyUrlLength; i++) {
			urlBuilder.append(ALPHABETS.charAt(random.nextInt(25)));
		}

		if (shortToLongUrlMap.containsKey(urlBuilder.toString())) {
			return getTinyUrl(url);
		} else {
			shortToLongUrlMap.put(urlBuilder.toString(), url);
			longToShortUrlMap.put(url, urlBuilder.toString());
			return BASE_URL + urlBuilder.toString();
		}
	}

	/**
	 * 
	 * This function returns the Long URL for given short URL
	 * 
	 * @param sUrl - e.g. https://www.gourusTinyUrl.com/......
	 * 
	 * @return longUrl
	 */

	public String returnLongURL(String sUrl) {

		String shortUrl = sUrl.substring(BASE_URL.length(), sUrl.length());

		if (shortToLongUrlMap.containsKey(shortUrl)) {
			return shortToLongUrlMap.get(shortUrl);
		} else {
			throw new RuntimeException("Given URL is not converted before...");
		}
	}

	public static void main(String[] args) {
		TinyURL tinyURL = new TinyURL();

		System.out.println(tinyURL.getTinyUrl("www.google.com"));
		String sUrl = tinyURL.getTinyUrl("www.google.com");

		System.out.println(tinyURL.returnLongURL(sUrl));

	}

}
