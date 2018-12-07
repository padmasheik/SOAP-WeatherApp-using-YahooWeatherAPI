package com.padmacareer.restfultemplate.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {
	int count;
	String created;
	String lang;
	Results results;

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	public Query() {
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return String.format("Query [count=%s, created=%s, lang=%s, results=%s]", count, created, lang, results);
	}

}
