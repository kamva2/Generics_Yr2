/*
 * Geeks for geeks
 * This class implements a Binary Search Tree (BST) for storing and managing knowledge base entries.
 * Each node in the tree contains a term, statement, and confidence score.
 */

class BST {
    private BSTNode root;
    
    /**
     * Inserts a new knowledge base entry into the tree.
     * If the term already exists, the statement is updated only if the new confidence score is higher.
     * 
     * @param term The term to insert into the tree
     * @param statement The statement associated with the term
     * @param confidence The confidence score associated with the statement
     */
     
    public void insert(String term, String statement, double confidence) {
        root = insertRec(root, term, statement, confidence);
    }
    /**
     * Recursively inserts a new knowledge base entry into the tree or updates the existing entry.
     * 
     * @param node The current node in the recursion
     * @param term The term to insert
     * @param statement The statement associated with the term
     * @param confidence The confidence score associated with the statement
     * @return The node after insertion or update
     */
    private BSTNode insertRec(BSTNode node, String term, String statement, double confidence) {
        if (node == null) return new BSTNode(term, statement, confidence);

        int cmp = term.compareTo(node.term);
        if (cmp < 0) {
            node.left = insertRec(node.left, term, statement, confidence);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, term, statement, confidence);
        } else {
            if (confidence > node.confidence) {
                node.statement = statement;
                node.confidence = confidence;
            }
        }
        return node;
    }
    /**
     * Searches for a knowledge base entry by term.
     * 
     * @param term The term to search for
     * @return The node containing the term, or null if not found
     */

    public BSTNode search(String term) {
        return searchRec(root, term);
    }
    /**
     * Recursively searches for a knowledge base entry by term in the tree.
     * 
     * @param node The current node in the recursion
     * @param term The term to search for
     * @return The node containing the term, or null if not found
     */
    private BSTNode searchRec(BSTNode node, String term) {
        if (node== null || node.term.equals(term)) return node;

        if (term.compareTo(node.term) < 0) return searchRec(node.left, term);
        return searchRec(node.right, term);
    }
}

