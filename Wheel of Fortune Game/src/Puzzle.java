import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Puzzle {

  public static final Puzzle[] puzzles = new Puzzle[3];
  //public static ArrayList<Character> vowels = new ArrayList<>( );
  String category;
  String puzzle;
  String answer;
  Character guess;
  int tempCount = 0;
    int correctLetters = 0;
    int incorrectLetters = 0;
    String tempAnswer = "";

  public  ArrayList<CategoryPuzzle> categoryPuzzleArrayList = new ArrayList<>();
  public  ArrayList<PuzzleLetter> puzzleLetterArrayList = new ArrayList<>();
  public  ArrayList<PuzzleLetter> tempLetterArrayList = new ArrayList<>();

    public ArrayList<PuzzleLetter> getTempLetterArrayList() {
        return tempLetterArrayList;
    }

    public ArrayList<CategoryPuzzle> getCategoryPuzzleArrayList() {
        return categoryPuzzleArrayList;
    }

    public ArrayList<PuzzleLetter> getPuzzleLetterArrayList() {
        return puzzleLetterArrayList;
    }

    public Puzzle() { //default constructor
    category = "";
    puzzle = "";
  }

    public  String getTempAnswer() {
        return tempAnswer;
    }

    public void setTempAnswer(String tempAnswer) {
        this.tempAnswer = tempAnswer;
    }

    public Puzzle(String category, String puzzle) {  //Primary Constructor
    this.category = category;
    this.puzzle = puzzle;
  }

  public String loadPuzzleQuestion(String category) { //loads puzzle from file
    ArrayList<CategoryPuzzle> tempPuzzleArrayList = new ArrayList<>();
    int i = 0;
    try {
      Scanner fileObj = new Scanner(new File(category.toLowerCase() + ".txt"));

      CategoryPuzzle categoryPuzzle = new CategoryPuzzle();
      while (fileObj.hasNextLine()) {
        categoryPuzzle.category = category;
        if (i == 0){
          puzzle = fileObj.nextLine();

          categoryPuzzle.puzzle = puzzle;
          i = 1;
        }else if (i == 1){
          answer = fileObj.nextLine();
          categoryPuzzle.answer = answer;
          i = 0;
          tempPuzzleArrayList.add(categoryPuzzle);
          categoryPuzzle = new CategoryPuzzle();
        }


      }
      fileObj.close();

    } catch (FileNotFoundException e) {
      System.err.println("Could Not Load File");
    }

    if (tempPuzzleArrayList.size() > 0){
      Random rand = new Random();
      int rand_int = rand.nextInt(tempPuzzleArrayList.size() - 1);
      return tempPuzzleArrayList.get(rand_int).puzzle;
    }else {
      return "";
    }

  }

    public String loadPuzzleAnswer(String category,String question) { //loads puzzle from file
        int i = 0;
        String puzzleAnswer = "";
        try {
            Scanner fileObj = new Scanner(new File(category.toLowerCase() + ".txt"));
            CategoryPuzzle categoryPuzzle = new CategoryPuzzle();
            categoryPuzzle.category = category;
            while (fileObj.hasNextLine()) {

                if (i == 0){
                    puzzle = fileObj.nextLine();


                    categoryPuzzle.puzzle = puzzle;



                    i = 1;
                }else if (i == 1){
                    answer = fileObj.nextLine();

                    if (categoryPuzzle.puzzle.equals(question)){
                        puzzleAnswer = answer;
                    }
                    categoryPuzzle.answer = answer;
                    i = 0;
                    categoryPuzzleArrayList.add(categoryPuzzle);
                    categoryPuzzle = new CategoryPuzzle();
                }


            }
            fileObj.close();

        } catch (FileNotFoundException e) {
            System.err.println("Could Not Load File");
        }
        return puzzleAnswer;
    }

  public boolean loadPuzzle(String category,Character guessed,String question) { //loads puzzle from file
    int i = 0;
     tempAnswer = "";
    try {
      Scanner fileObj = new Scanner(new File(category.toLowerCase() + ".txt"));
      CategoryPuzzle categoryPuzzle = new CategoryPuzzle();
      categoryPuzzle.category = category;
      while (fileObj.hasNextLine()) {

        if (i == 0){
          puzzle = fileObj.nextLine();


          categoryPuzzle.puzzle = puzzle;



          i = 1;
        }else if (i == 1){
          answer = fileObj.nextLine();

          if (categoryPuzzle.puzzle.equals(question)){
            System.out.println("ques: " + question);
            tempAnswer = answer;
          }
          categoryPuzzle.answer = answer;
          i = 0;
          categoryPuzzleArrayList.add(categoryPuzzle);
          categoryPuzzle = new CategoryPuzzle();
        }


      }
      fileObj.close();

    } catch (FileNotFoundException e) {
      System.err.println("Could Not Load File");
    }
      return getPuzzle(guessed,tempAnswer);
  }


  public Boolean getPuzzle(Character guessed,String tempAnswer){

    puzzleLetterArrayList.clear();

    for (int i = 0; i < tempAnswer.length(); i++){
      PuzzleLetter letters = new PuzzleLetter();
      letters.setLetter(tempAnswer.charAt(i));
      puzzleLetterArrayList.add(letters);
    }


    return guessPuzzle(guessed,1);
  }

    public void getPuzzle(String tempAnswer){

        puzzleLetterArrayList.clear();

        clearArrays();

        for (int i = 0; i < tempAnswer.length(); i++){
            PuzzleLetter letters = new PuzzleLetter();
            letters.setLetter(tempAnswer.charAt(i));
            puzzleLetterArrayList.add(letters);
        }

        for (int i = 0; i < tempAnswer.length(); i++){
            PuzzleLetter letters = new PuzzleLetter();
            letters.setLetter('*');
            tempLetterArrayList.add(letters);
        }


    }

  public void clearArrays(){

      puzzleLetterArrayList.clear();
      tempLetterArrayList.clear();
      int tempCount = 0;
      int correctLetters = 0;
      int incorrectLetters = 0;

  }

    public boolean guessPuzzle(Character guessed,int attempt){



        guess = guessed;

        Character upperGuessed = String.valueOf(guessed).toUpperCase().charAt(0);
        Character lowerGuessed =  String.valueOf(guessed).toLowerCase().charAt(0);

        if(attempt == 1) {
            for (int i = 0; i < puzzleLetterArrayList.size(); i++){
                if (puzzleLetterArrayList.get(i).letter != lowerGuessed && puzzleLetterArrayList.get(i).letter != upperGuessed) {
                    PuzzleLetter tempPuzzle = new PuzzleLetter();
                    tempPuzzle.setLetter('*');
                    tempLetterArrayList.add(i, tempPuzzle);

                } else {
                    PuzzleLetter tempPuzzle = new PuzzleLetter();
                    tempPuzzle.setLetter(guessed);
                    tempLetterArrayList.add(i, tempPuzzle);
                    correctLetters++;
                }

                if (i == puzzleLetterArrayList.size() - 1) {
                    if (correctLetters == 0) {
                        incorrectLetters = 1;
                    }
                }

            }

        }else {

            for (int i = 0; i < puzzleLetterArrayList.size(); i++) {
                if (puzzleLetterArrayList.get(i).letter != lowerGuessed && puzzleLetterArrayList.get(i).letter != upperGuessed) {
                    if (tempLetterArrayList.get(i).letter == '*') {
                        PuzzleLetter tempPuzzle = new PuzzleLetter();
                        tempLetterArrayList.get(i).setLetter('*');
                    }

                } else {
                    PuzzleLetter tempPuzzle = new PuzzleLetter();
                    tempLetterArrayList.get(i).setLetter(guessed);
                    correctLetters++;
                }

                if (i == puzzleLetterArrayList.size() - 1) {
                    if (correctLetters == 0) {
                        incorrectLetters = 1;
                    }else {
                        incorrectLetters = 0;
                    }
                }
            }

        }

        if (correctLetters > 0){

            for (int i = 0; i < tempLetterArrayList.size(); i++) {
                System.out.print("  " + tempLetterArrayList.get(i).letter);
            }

            for (int i = 0; i < tempLetterArrayList.size(); i++){
                if (tempLetterArrayList.get(i).letter.equals('*')){

                    if (incorrectLetters == 0){

                        Scanner OpObj = new Scanner(System.in);
                        System.out.println("\nWould you like to Guess, Solve or Buy Vowel");
                        String option = OpObj.nextLine();

                        if (option.toLowerCase().equals("solve")){
                            solvePuzzle();
                        }else if (option.toLowerCase().equals("Guess".toLowerCase())){

                            Scanner GObj = new Scanner(System.in);
                            System.out.println("\nChoose a Letter");
                            String guess_new = GObj.nextLine();
                            correctLetters = 0;
                            incorrectLetters = 1;
                            guess = guess_new.charAt(0);
                            guessPuzzle(guess_new.charAt(0),2);

                        }else if (option.toLowerCase().equals("Buy Vowel".toLowerCase())){
                            buyVowel();
                        }


                    }


                }
      else if (incorrectLetters == 0){

                    if (i == tempLetterArrayList.size() - 1){

                        if (tempCount == 0){

                            System.out.println("\nCongrats you successfully solved the puzzle");
                            tempCount = 1;
                            return true;
                        }

                    }

                }


            }
        }

        if (incorrectLetters > 0){
            if (attempt == 1){

                correctLetters = 0;
                System.out.println("Puzzle has no " + "'" + guess + "'" + "in it");
//                for (int i = 0; i < puzzleLetterArrayList.size(); i++){
//                    System.out.print("  " + puzzleLetterArrayList.get(i).getLetter());
//                }

            }


        }

        if (tempCount == 1){
            return true;
        }
        
        else{
            return false;
        }
    }

    public void buyVowel(){

      int count = 0;
        for (int i = 0; i < puzzleLetterArrayList.size(); i++) {

            if (String.valueOf(puzzleLetterArrayList.get(i).letter).toLowerCase().charAt(0) == 'a' ||
                    String.valueOf(puzzleLetterArrayList.get(i).letter).toLowerCase().charAt(0) == 'e' ||
                    String.valueOf(puzzleLetterArrayList.get(i).letter).toLowerCase().charAt(0) == 'i' ||
                    String.valueOf(puzzleLetterArrayList.get(i).letter).toLowerCase().charAt(0) == 'o' ||
                    String.valueOf(puzzleLetterArrayList.get(i).letter).toLowerCase().charAt(0) == 'u') {

                if (tempLetterArrayList.get(i).getLetter() == '*'){
                    if (count < 1){
                        tempLetterArrayList.get(i).setLetter(puzzleLetterArrayList.get(i).letter);
                        correctLetters++;
                        incorrectLetters = 0;
                        count++;

                        for (int j = 0; j < tempLetterArrayList.size(); j++){
                            System.out.print(" " + tempLetterArrayList.get(j).getLetter());
                        }
                    }
                }

            }
            else{

                if (i == puzzleLetterArrayList.size() - 1 && count < 1){
                    System.out.print("No Vowels Found");
                    incorrectLetters = 0;
                }
            }
       }




}

    public void solvePuzzle(){

        Scanner GObj = new Scanner(System.in);
        System.out.println("Enter your Guess");
        String guess_new = GObj.nextLine();

        if (guess_new.toLowerCase().equals(tempAnswer.toLowerCase())){

            correctLetters = 0;
            incorrectLetters = 0;

            for (int i = 0; i < puzzleLetterArrayList.size(); i++) {
                if (puzzleLetterArrayList.get(i).letter == guess_new.toLowerCase().charAt(i) || puzzleLetterArrayList.get(i).letter == guess_new.toUpperCase().charAt(i)) {
                    PuzzleLetter tempPuzzle = new PuzzleLetter();
                    tempLetterArrayList.get(i).setLetter(guess_new.charAt(i));
                    correctLetters++;
                }
            }


        }

    }

	  

  public void displayPuzzles() {
    if (categoryPuzzleArrayList.size() > 0){
      System.out.println("\nCategory:" + "  " + categoryPuzzleArrayList.get(0).category);
    }


    for (int i = 0; i < categoryPuzzleArrayList.size() ; i++) {
      System.out.println("  " + categoryPuzzleArrayList.get(i).puzzle );

    }
  }
}
