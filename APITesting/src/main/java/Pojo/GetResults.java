package Pojo;

import java.util.List;

public class GetResults
{
	private String page;
	private List<Results> results;
	private String total_pages;
	private String total_results;
	
	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}
	/**
	 * @return the results
	 */
	public List<Results> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<Results> results) {
		this.results = results;
	}
	
	/**
	 * @return the total_results
	 */
	public String getTotal_results() {
		return total_results;
	}
	/**
	 * @param total_results the total_results to set
	 */
	public void setTotal_results(String total_results) {
		this.total_results = total_results;
	}
	
	/**
	 * @return the total_pages
	 */
	public String getTotal_pages() {
		return total_pages;
	}
	/**
	 * @param total_pages the total_pages to set
	 */
	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}
	
}
