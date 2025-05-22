/**Collecting the entries in a orderly way
* Kamva Poswa
* 05 March 2025
*/
public class Data {

   String term;
   String statement;
   double score;
   /**
     * Constructs a new Data object.
     * 
     * @param term      The keyword or concept.
     * @param statement The statement associated with the term.
     * @param score     The confidence score of the statement.
     */
   
   public Data(String term, String statement, double score){
   
      this.term = term;
      this.statement = statement;
      this.score =score;
   }
   /**
     * Gets the term.
     * 
     * @return The term as a string.
     */
   
   public String getTerm() {
        return term;
   }
   /**
     * Gets the statement.
     * 
     * @return The statement as a string.
     */
   public String getStatement() {
        return statement;
   }
   /**
     * Gets the confidence score.
     * 
     * @return The confidence score as a double.
     */

   public double getScore() {
        return score;
   }
   /**
     * Updates the statement and score if the new score is higher.
     * 
     * @param statement The new statement.
     * @param score     The new confidence score.
     */
   public void updateIfHigher(String statement, double score) {
   
        if (score > this.score) {
        
          this.statement = statement;
          this.score= score;
        }
   }
   /**
     * Returns a formatted string representation of the Data object.
     * 
     * @return A formatted statement including the confidence score.
     */
   @Override
   public String toString(){
   
      return "** Statement found: "+ statement + String.format(" (Confidence score: %.5f) **\n",score);
   }
}