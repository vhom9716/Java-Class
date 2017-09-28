package chatbotProject;

public class Chatbot {

	private String userName;
	private Topic victor;
	private boolean chatting; 
	
	public Chatbot() {
		victor = new ChatbotVictor();
		userName = "unknown user";
		chating = true;
	}
	
	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			if(victor.isTriggered(response)) {
				chatting = false;
				victor.startChatting();
			}else {
				ChatbotMain.print("I'm sorry. I don't understand.");
			}
		}
	}

}
