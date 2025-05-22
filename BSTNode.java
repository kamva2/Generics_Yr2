// Node class
/** 
 * Represents a node in the Binary Search Tree.
 */

class BSTNode {
    String term;
    String statement;
    double confidence;
    BSTNode left, right;
    
        /**
     * Constructs a new BSTNode.
     * 
     * @param term       The keyword for the statement.
     * @param statement  The actual statement.
     * @param confidence The confidence score of the statement.
     */

    public BSTNode(String term, String statement, double confidence) {
        this.term= term;
        this.statement = statement;
        this.confidence = confidence;
    }
}
