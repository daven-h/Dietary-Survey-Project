import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
    //instance variables
    private String surveyFile;
    private FileWriter fileOutput;
    private PrintWriter printWriter;

    //FileHandler constructor
    public FileHandler() {
        File prevSurvey = new File("survey_results.csv");
        prevSurvey.delete();
        File file = new File("survey_results.csv");


        try {
            fileOutput = new FileWriter(file,true);
            printWriter = new PrintWriter(fileOutput);
            printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Dairy,Wheat,Sugar,Miles,Weight");
            fileOutput.close();
            printWriter.close();
        }catch(Exception e){
            System.out.println("File could not be read.");
        }

    }

    /**
     * Writes the data of the survey into the file.
     * @param surveyData The content of the survey.
     */
    public void writeResults(String surveyData){
      File file = new File("survey_results.csv");
      try{
          fileOutput = new FileWriter(file,true);
      }catch(IOException e){
          System.out.println("File could not be read");
      }
      printWriter = new PrintWriter(fileOutput);
      printWriter.println(surveyData);
      printWriter.close();
    }
}//end of class
