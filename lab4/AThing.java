public abstract class AThing {
	private String Type;
	private Shorty Owner;

	public AThing(String Type, Shorty Owner) {
		this.Type = Type;
		this.Owner = Owner;
	}

	public String getType() {
		return Type;
	}

	public void newOwner(Shorty Owner) throws InitException {
		if (Owner == null) throw new InitException("Коротышка");
		this.Owner = Owner;
	}
}