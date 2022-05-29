public interface IShorty {
	public void LayDown(Furniture f);
	public void GetUp();
	public void Give(AThing t, Shorty s);
	public void MoveTo(ALocation l);
	public void MoveTo(ALocation l, String r);
	public void Say(String s);
	public void Advice(Shorty s);
}