package task02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Quiz {
    private Locale language = new Locale("en");
    private String greeting = "Welcome to the quiz. Please, choose language (en/ru): ";
    private ResourceBundle bundle = ResourceBundle.getBundle("questions", language);
    private int questionsQuantity;
    
    public void showAllQuestions(){
        int i = 0;
        StringBuilder questions = new StringBuilder();
        for (String s: bundle.keySet()) {
            if(s.matches("^question\\d+")){
                i++;
                questions.append(i + ". ").append(bundle.getString("question" + i)).append("\n");
            }
        }
        questionsQuantity = i;
        System.out.println(questions);
    }

    public void chooseLanguage(){
        Scanner scanner = new Scanner(System.in);
        String userLanguage = scanner.next();
        if(userLanguage.equalsIgnoreCase("en") | userLanguage.equalsIgnoreCase("ru")){
            language = new Locale(userLanguage);
        }
        else{
            System.out.println("Wrong language. Default settings will be used - en.");
        }
        bundle = ResourceBundle.getBundle("questions", language);
    }

    public void showTheAnswers(){
        System.out.println(bundle.getString("see.the.answer"));
        Scanner scanner = new Scanner(System.in);
        while (true){
            String answerNumber = scanner.next();
            if(Integer.parseInt(answerNumber) <= questionsQuantity){
                System.out.println(bundle.getString("answer" + answerNumber));
            }
            else{
                System.out.println(bundle.getString("wrong.question.number"));
            }
        }
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        System.out.println(quiz.greeting);
        quiz.chooseLanguage();
        quiz.showAllQuestions();
        quiz.showTheAnswers();
    }
}
