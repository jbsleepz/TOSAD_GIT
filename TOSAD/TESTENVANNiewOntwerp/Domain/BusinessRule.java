package Domain;

public class BusinessRule {
	private String naam;
	private Errormessage error;

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Errormessage getError() {
		return error;
	}

	public void setError(Errormessage error) {
		this.error = error;
	}

}
