package com.padmacareer.restfultemplate.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryRequest {
	Query query;

	public QueryRequest() {

	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	@Override
	public String toString() {
		return String.format("QueryRequest [query=%s]", query);
	}

}
