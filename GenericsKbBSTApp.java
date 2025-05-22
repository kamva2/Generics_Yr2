/*Kamva Poswa
* 10 March 2025
*/

import java.util.*;
import java.io.*;

/*
 * This class represents the application that interacts with a Binary Search Tree (BST)
 * to manage a knowledge base. Users can load a knowledge base from a file, add new
 * terms with statements and confidence scores, and search for terms.
 * @param args Command line arguments
 */
public class GenericsKbBSTApp {
    private static BST knowledgeBase =  new BST();
    
    /*
     * The main method that runs the application.
     * It provides a menu for the user to load the knowledge base, 
     * add new statements, and search for terms.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "";

        int choice;
        do {
            System.out.println("1. Load knowledge base");
            System.out.println("2. Add statement (New terms Permitted)");
            System.out.println("3. Search by term");
            System.out.println("4. Quit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter file name: ");
                fileName = scanner.nextLine();
                loadKnowledgeBase(fileName);
            } else if (choice==2) {
                System.out.print("Enter term: ");
                String term = scanner.nextLine();
                System.out.print("Enter statement: ");
                String statement = scanner.nextLine();
                System.out.print("Enter confidence score: ");
                double score = Double.parseDouble(scanner.nextLine());

                knowledgeBase.insert(term, statement, score);
                System.out.println("\n**New Term Successfully Uploaded!**\n");
                
            } else if (choice == 3) {
                System.out.print("Enter term: ");
                String term = scanner.nextLine();
                BSTNode result = knowledgeBase.search(term);
                if (result != null) System.out.println("** Statement Found: " + result.term + " - " + result.statement + " (" + result.confidence + ") **\n");
                else System.out.println("Term not found.");
            }

        } while (choice != 4);
        System.out.println("Knowledge base terminated.");
    }
    /**
     * Loads the knowledge base from a file. Each line in the file should contain
     * a term, statement, and confidence score separated by tabs.
     *
     * @param fileName The name of the file to load
     */

    private static void loadKnowledgeBase(String fileName) {
        
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
        String line;
        
        while((line = reader.readLine()) != null){
            
            String[] parts = line.split("\t");
            if (parts.length == 3){
            knowledgeBase.insert(parts[0], parts[1], Double.parseDouble(parts[2]));}
            
        }
        System.out.println("\n**Successfully uploaded!**\n");
        
    } catch(IOException e){System.out.print("** File error: "+ e.getMessage());}
   }
}