package it.unimol.quiztime.handler;

import it.unimol.quiztime.entities.Answer;
import it.unimol.quiztime.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class HandlerQuiz {

    private List<Question> questionslist = new ArrayList<>();

    String[] descriptionQ =    {
            "E' possibile istanziare una interfaccia in java?",
            "Con quale parola chiave di java si ottiene l'ereditarietà?",
            "quanti sono i tipi primitivi in java?",
            "Se la variabile 'double' di nome x è pari al valore 9.997 cosa stamperà a video la seguente istruzione java? system.out.print((int)math.round(x));",
            "Quale delle seguenti sigle fa direttamente parte del mondo java?  ",
            "Per eliminare eventuali spazi bianchi dai dati inseriti in un campo di testo è necessario utilizzare l'istruzione java:",
            "Quale delle seguenti istruzioni java dichiara una costante? ",
            "Nel linguaggio java, l'istruzione 'int[] a = new int[100];' : ",
            "Nel linguaggio java, il codice contenuto nei blocchi 'try' e 'catch':",
            "L'istruzione java 'frame.setdefaultcloseoperation(jframe.exit_on_close);' è necessaria per:"
    };

    String[][] descriptionA =    {
            {"Mai, poichè le interfacce non sono classi.","Sempre, perchè le interfacce sono classi.","Solo in alcuni casi.","Solo nel seguente modo: Comparable com = new Comparable();"},
            {"Implements","Extends","Instanceof","Serializable"},
            {"infiniti" ,"4","8","256"},
            {"10","9.98","100","1000"},
            {"DBMS","ONU","CPU","JDK"},
            {"nomecasellatesto=Tastiera.!readLine();"," BufferedReader Tastiera = new BufferedReader(input);","nomecasellatesto.gettext().trim();","System.out.print(''//'');"},
            {"Private int temp=0;","Prortected int=10;","Final double pgreco = 3.14;","long j = 1;"},
            {"Assegna ad a il valore 100.","Crea 100 variabili di nome a.","Crea un array che può contenere 100 numeri interi.","Setta l'array pieno di elementi inizializzati a 100."},
            {"Serve a gestire l'ereditarietà.","Serve per clonare oggetti.","Serve per commentare un blocco di codice nel caso in cui esso non funzioni.","Serve a gestire le eccezioni"},
            {"Chiudere il programma una volta verificati errori.","Garantire che l'esecuzione del programma si arresti quando viene chiuso il frame.","Garantire che vengano gestite al meglio le risorse.","Permette al sistema di effettuare operazioni di default dopo aver svolto operazioni matematiche."}
    };


    Boolean[][] verify = {

            {true,false,false,false},
            {false,true,false,false},
            {false,false,true,false},
            {true,false,false,false},
            {false,false,false,true},
            {false,false,true,false},
            {false,false,true,false},
            {false,false,true,false},
            {false,false,false,true},
            {false,true,false,false}

    };

    public HandlerQuiz(){
      this.uploadQuestions();

    }

    private void uploadQuestions(){
        for (int i=0;i<descriptionQ.length;i++){
            List<Answer> descriptionAnswers = new ArrayList<>();
            for (int j=0;j<4;j++) {
                Answer answer = new Answer(descriptionA[i][j], verify[i][j]);
                descriptionAnswers.add(answer);
            }
            Question question = new Question(descriptionQ[i], descriptionAnswers);
            this.questionslist.add(question);
        }
    }

    public String returnQuestion(int i){
        String question = this.questionslist.get(i).getDescription();
        return question;
    }

    public  String returnAnswer(int i,int j){
        String answer = this.questionslist.get(i).getAnswers().get(j).getDescription();
        return answer;
    }

    public boolean check(int i,int j){
        Boolean verify = this.questionslist.get(i).getAnswers().get(j).getIsCorrect();
        return verify;
    }

}
