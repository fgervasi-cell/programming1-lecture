package de.dhbwka.java.second_semester.threads.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
	private String[] urls;
	private List<PageLoader> loaders = new ArrayList<>();
	
	public SearchEngine(String... urls) {
		this.urls = urls;
	}
	
	public void search() {
		for(String url : urls) {
			PageLoader loader = new PageLoader(url);
			Thread thread = new Thread(loader);
			loaders.add(loader);
			thread.start();
		}
		while(!loaders.isEmpty()) { 
			for(int i = 0; i < loaders.size(); i++) {			
				if(loaders.get(i).pageLoaded()) {
					System.out.println(loaders.get(i).getPageContent());
					loaders.remove(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		new SearchEngine("https://www.tagesschau.de", "https://sueddeutsche.de", "https://www.spiegel.de").search();
	}
}
