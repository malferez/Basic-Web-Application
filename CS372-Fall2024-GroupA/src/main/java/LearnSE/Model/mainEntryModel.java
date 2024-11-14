package LearnSE.Model;

public class mainEntryModel {
	private String contentTitle;
	private String contentDetails;
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public String getContentDetails() {
		return contentDetails;
	}
	public void setContentDetails(String contentDetails) {
		this.contentDetails = contentDetails;
	}
	@Override
	public String toString() {
		return "mainEntryModel [contentTitle=" + contentTitle + ", contentDetails=" + contentDetails
				+ ", getContentTitle()=" + getContentTitle() + ", getContentDetails()=" + getContentDetails()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


}
