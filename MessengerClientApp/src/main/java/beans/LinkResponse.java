package beans;

public class LinkResponse {

	private String rel;
	private String href;

	public LinkResponse() {
	}

	public LinkResponse(String rel, String href) {
		super();
		this.rel = rel;
		this.href = href;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
