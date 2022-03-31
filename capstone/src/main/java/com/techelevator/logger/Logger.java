package com.techelevator.logger;

import java.io.*;

public class Logger {

    private File logFile;
    private PrintWriter writer;

    public Logger(String pathName){

        this.logFile = new File(pathName);   //Makes a new file.
         if(!logFile.exists()){
             try{
                 this.writer = new PrintWriter(this.logFile);
             } catch (FileNotFoundException e){
                 System.out.println("Internal Error - System Will Exit - FileNotFound");
             }
         } else {
             try{
                 this.writer = new PrintWriter(new FileWriter(this.logFile, true));
             } catch (IOException e){
                 System.out.println("Internal Error - System Will Exit - IOException ");
             }
         }
    }

    public void write(String logMessage){
        this.writer.println(logMessage); //Puts it in a buffer.
        this.writer.flush(); // Takes the whole thing and writes it to a file line.
    }

    public void close() throws IOException{
        this.writer.close(); //Close when you're done writing
    }

}
