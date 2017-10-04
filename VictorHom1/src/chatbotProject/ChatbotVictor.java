package chatbotProject;

import java.util.ArrayList;
import java.util.List;

import chatbotProject.ChatbotMain;

public class ChatbotVictor implements Topic {
	
	//Used to determine emotions
	private String[] verifications;
	private String[] negations;
	private int temperment = 5; //Index for array of happy to angry statements. 0 is happiest, 10 is angriest.
	
	
	//Used to facilitate question adding, question asking, and answer validation
	private String[] questionWords;
	private String usedQuestions;
	private List<String> questions = new ArrayList<String>();
	private List<String> answers = new ArrayList<String>();
	
	private String[] keywords;
	private String goodbyeWord;
	private String[] testWords;
	private boolean chatting;
	
	public ChatbotVictor(){
		String[] temp = {"social studies", "geography", "history"};
		keywords = temp;
		
		String[] tempVer = {"That's amazing", "Great", "Awesome", "temp1", "temp", "Okay", "Come on", "Is that the best you can do?", "Wow. I honestly can't believe you actually did something right."};
		verifications = tempVer;
		String[] tempNeg = {"Come on you can do it!", "You almost got it right!", "Everyone makes mistakes", "temp2" ,"That is incorrect.", "Are you listening to me?", "Is that the best you can do?", "I thought I was seeing things. But somehow, you did something wrong. AGAIN.", "Seriously? Are you sure you know how to do this?"};
		negations = tempNeg;

		goodbyeWord = "bye";
		
		String[] temp2 = {"quiz", "test", "assess"};
		testWords = temp2;
		String[] temp3 = {"who", "what", "where", "when", "why"};
		questionWords = temp3;
		
		usedQuestions = "";
		String[] tempQue = {"Who is the first president of the United States?"};
		String[] tempAns = {"George Washington"};
		turnArrayToList(questions, tempQue);
		turnArrayToList(answers, tempAns);
	}	
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyWord(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}
	public void startChatting(String response) {
		ChatbotMain.print("Hey! It looks like you want some help with Social Studies. Say ready when you want me to start asking questions.");
		String ready = "ready";
		
		boolean questionEnter = false;
		String question = "";
		
		chatting = true;
		while (chatting){
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyWord(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else {
				if(response.equals(ready)) {
					startQuestioning();
				}
				for (int i = 0; i < testWords.length; i++) {
					if(ChatbotMain.findKeyWord(response, testWords[i], 0) >= 0) {
						ChatbotMain.print("You have questions you want to be quized on?" + getTempermentStatement(true, "Just enter them here. First enter the question."));
						
						while(!isQuestion(response))
							 question = response;
						}
					
						//questionEnter = true;
						
						//ChatbotMain.print(getTempermentStatement(false, "That is not a question. Please try again.")); //Make sure that the questions are unique and not repeated
						//temperment++;
						
						ChatbotMain.print(getTempermentStatement(true, "You entered a question. Now enter the answer."));
						
						
						questions.add(response);
						//temperment--;
						//answers.add(response);
					}	
				}
				


			}
		}
		

	
	public void startQuestioning() {
		String response = "";
		int randNum = getUnusedQuestionIndex();
		String newResponse = ChatbotMain.getInput(); 
		
		ChatbotMain.print(questions.get(randNum));
		usedQuestions += randNum; 
			
		while(!(newResponse.indexOf(answers.get(randNum).toLowerCase()) > -1)){
			newResponse = ChatbotMain.getInput(); 
			if(response != newResponse) {
				response = newResponse;
				temperment++;
				ChatbotMain.print("You are wrong." + getTempermentStatement(false, "Try again.\n" + questions.get(randNum)));
			}
		}
		
		ChatbotMain.print(getTempermentStatement(true, "You are correct. Say ready when you want your next question or request questions you want to be quized on."));
		temperment--;
	}

	public boolean isQuestion(String question) {
		for(int i = 0; i < questionWords.length; i++) {
			if(question.indexOf(questionWords[i]) > -1) {
				return true;
			}
		}
		return false;
	}
	
	public int getUnusedQuestionIndex() {
		if(usedQuestions.length() == questions.size()) {
			usedQuestions = ""; //When all questions have been used, clears string to allow old questions to be reused.
		}
		int randNum = (int) Math.floor(Math.random() * questions.size());
		while(usedQuestions.indexOf(randNum) > -1) {
			randNum = (int) Math.floor(Math.random() * questions.size());
		}
		return randNum;
	}
	
	//Input True gives verifications. Input False gives negations.
	public String getTempermentStatement(boolean positive, String s) {
		

		if(positive) {
			
			if(temperment < 7) {
				return verifications[temperment];
			}
			return verifications[temperment] + s;
		}
		if(temperment < 7) {
			return negations[temperment];
		}
		return negations[temperment] + s;
	}
	
	//Adds all elements of the array to a list
	public void turnArrayToList(List<String> l, String[] a) {
		for(int i = 0; i < a.length; i++) {
			String n = a[i];
			l.add(n);
		}
	}
}

