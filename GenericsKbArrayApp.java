// This class provides a simple implementation of a knowledge base application.
// Kamva Poswa
// 01 March 2025

import java.util.*;
import java.io.*;

/** It allows users to load a knowledge base from a file, update statements,
 * search for terms, and manage knowledge entries.
 */
public class GenericsKbArrayApp{

    private static final int MAX_SIZE = 100; 
    private static Data[] knowledgeBase = new Data[MAX_SIZE];
    private static int size = 0;
    /**
     * Main method to run the knowledge base application.
     * It provides a menu to load the knowledge base, update a statement, search by term,
     * and quit the application.
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args){
    
         Scanner input = new Scanner(System.in);
         String fileName = "";
         
         int choice;
         do{
            System.out.println();
            System.out.println("Welcome to My knowledge base:), How can I help you?");
            System.out.println("##################################################################");
            System.out.println("#   1. Load knowledge base                                       #");
            System.out.println("#   2. Update statement (no new entries)                         #");
            System.out.println("#   3. Search by term                                            #");
            System.out.println("#   4. Quit                                                      #");
            System.out.println("##################################################################");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();
            
            if(choice == 1){
               System.out.print("Enter file name:");
               fileName = input.nextLine();
               loadKnowledgeBase(fileName);
               System.out.println();
            }
            else if(choice == 2){
                Scanner kb =  new Scanner(System.in);
                
                System.out.print("Enter term: ");
                String term = input.nextLine();
                System.out.print("Enter statement: ");
                String statement = input.nextLine();
                System.out.print("Enter confidence score: ");
                double score = Double.parseDouble(kb.nextLine());
                
                updateStatement(term, statement, score);
            }
            else if(choice == 3){
               System.out.print("Enter term: ");
               String term = input.nextLine();
               searchByTerm(term);
            }
            
            
         }while (choice != 4);
         System.out.println("Knowledge base terminated.");
    }
    /**
     * Loads the knowledge base from a specified file.
     * Each line of the file must contain a term, statement, and confidence score, separated by tabs.
     * 
     * @param fileName The name of the file to load knowledge from
     */
    
    private static void loadKnowledgeBase(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            size = 0;
            while ((line = reader.readLine()) != null && size < MAX_SIZE) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    knowledgeBase[size++] = new Data(parts[0], parts[1], Double.parseDouble(parts[2]));
                }
            }
            System.out.println("Knowledge base loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
    /**
     * Updates the statement for an existing term in the knowledge base.
     * If the term is found, the statement is updated only if the new confidence score is higher.
     * If the term is not found, no new entries are allowed.
     * 
     * @param term The term whose statement is to be updated
     * @param statement The new statement to associate with the term
     * @param score The confidence score associated with the statement
     */
    private static void updateStatement(String term, String statement, double score) {
        for (int i = 0; i < size; i++) {
            if (knowledgeBase[i].getTerm().equals(term)) {
            
                knowledgeBase[i].updateIfHigher(statement, score);
                System.out.println("Statement updated.");
                return ;
            }
        }
        System.out.println("Term not found. New entries are not allowed.");
    }
    /**
     * Searches for a term in the knowledge base and displays the associated statement and confidence score.
     * 
     * @param term The term to search for in the knowledge base
     */
    private static void searchByTerm(String term) {
        for (int i = 0; i < size; i++) {
            if (knowledgeBase[i].getTerm().equals(term)) {
                System.out.println( knowledgeBase[i]);
                return;
            }
        }
        System.out.println("Term not found.");
    }
}