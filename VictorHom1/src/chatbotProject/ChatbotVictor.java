package chatbotProject;

import java.util.List;

public class ChatbotVictor implements Topic {
	
	private String[] questionWords;
	private String[] verifications;
	private String[] negations;
	private String usedQuestions;
	
	private String[] keywords;
	private String goodbyeWord;
	private String[] testWords;
	private List<String> questions;
	private List<String> answers;
	private String tempQuestion;
	private String tempAnswer;
	private int temperment = 10; //Index for array of happy to angry statements. 0 is happiest, 20 is angriest.
	private boolean chatting;
	
	public ChatbotVictor(){
		String[] temp = {"social studies", "geography", "history"};
		keywords = temp;
		goodbyeWord = "bye";
		String[] temp2 = {"quiz", "test", "assess"};
		testWords = temp2;
		String[] temp3 = {"who", "what", "where", "when", "why"};
		questionWords = temp3;
	}	
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}
	public void startChatting(String response) {
		ChatbotMain.print("Hey! It looks like you want some help with Social Studies. Let me help you! Say ready when you want me to start asking questions.");
		String ready = "ready";
		
		chatting = true;
		while (chatting){
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else {
				for (int i = 0; i < testWords.length; i++) {
					if(ChatbotMain.findKeyword(response, testWords[i], 0) >= 0) {
						ChatbotMain.print("You have questions you want to be quized on? Thats great! Just enter them here. First enter the question.");
						
						tempQuestion = ChatbotMain.getInput();
						while(!isQuestion(tempQuestion)) {
							ChatbotMain.print("Sorry. That is not a question. Please try again.");
							tempQuestion = ChatbotMain.getInput();
							temperment++;
						}
						
						questions.add(tempQuestion);
						//questions += tempQuestion;
						ChatbotMain.print("Great! You entered a question. Now enter the answer.");
						temperment--;
						String tempAnswer = ChatbotMain.getInput();
						answers.add(tempAnswer);
						//answers += tempAnswer;
					}	
				}
			}
			
			if(response.equals(ready.toLowerCase())){
				startQuestioning();
			}
		}
		
	}
	
	public void startQuestioning() {
		int randNum = (int) Math.floor(Math.random() * questions.size());
		while(usedQuestions.indexOf( randNum) > -1) {
			randNum = (int) Math.floor(Math.random() * questions.size());
		}
		ChatbotMain.print(questions.get(randNum));;
		
	}

	public boolean isQuestion(String question) {
		for(int i = 0; i < questionWords.length; i++) {
			if(question.indexOf(questionWords[i]) > -1) {
				return true;
			}
		}
		return false;
	}
	
}
