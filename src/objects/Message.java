package objects;

public class Message {
	
	private String text;
	private int id;
	
	public Message(String text, int id) {//id used to identify the sender of the message. 0 for AI, 1 for user.
		this.text=text;
		this.id=id;
	}
	
	public String getText() {
		return text;
	}
	
	public int getID() {
		return id;
	}

}
