package objects;

public class Stack {
	
	private Message[] messages;
	
	public Stack() {
		messages=new Message[0];
	}
	
	public void addMessage(Message message) {
		Message[] temp=messages;
		messages=new Message[temp.length+1];
		for(int i=0; i<temp.length; i++) {
			messages[i+1]=temp[i];
		}
		messages[0]=message;
	}
	
	public Message[] getMessages() {
		return messages;
	}
}
