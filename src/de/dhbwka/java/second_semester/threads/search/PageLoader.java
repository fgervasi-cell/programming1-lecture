package de.dhbwka.java.second_semester.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageLoader implements Runnable {
	private final String url;
	private String pageContent = null;
	private boolean isLoaded = false;

	public PageLoader(String url) {
		this.url = url;
	}

	public boolean pageLoaded() {
		return this.isLoaded;
	}

	public String getPageContent() {
		if (this.pageContent == null) {
			return "The page did not load yet";
		} else {
			return this.pageContent;
		}
	}

	@Override
	public void run() {
		StringBuilder builder = new StringBuilder();
		String line = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(this.url).openStream()))) {
			System.out.println(String.format("Loading %s...", this.url));
			int lineCount = 0;
			while (br.ready()) {
				lineCount++;
				line = br.readLine();
				builder.append(line + System.lineSeparator());
				if(lineCount == 100) {
					break;
				}
			}
			System.out.println("Page loaded");
			this.setLoaded(true);
			this.pageContent = builder.toString();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		} catch (IOException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public void setLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}

}
