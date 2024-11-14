package LearnSE.Model;

public class processtypedata {
	private String titletypetext;
	private String detailtypetext;
	/**
	 * @return the titletypetext
	 */
	public String getTitletypetext() {
		return titletypetext;
	}
	/**
	 * @param titletypetext the titletypetext to set
	 */
	public void setTitletypetext(String titletypetext) {
		this.titletypetext = titletypetext;
	}
	/**
	 * @return the detailtypetext
	 */
	public String getDetailtypetext() {
		return detailtypetext;
	}
	/**
	 * @param detailtypetext the detailtypetext to set
	 */
	public void setDetailtypetext(String detailtypetext) {
		this.detailtypetext = detailtypetext;
	}
	@Override
	public String toString() {
		return "processtypedata [titletypetext=" + titletypetext + ", detailtypetext=" + detailtypetext
				+ ", getTitletypetext()=" + getTitletypetext() + ", getDetailtypetext()=" + getDetailtypetext()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
