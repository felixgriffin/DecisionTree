// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2019T2, Assignment 4
 * Name:
 * Username:
 * ID:
 */

/**
 * Implements a decision tree that asks a user yes/no questions to determine a decision.
 * Eg, asks about properties of an animal to determine the type of animal.
 * 
 * A decision tree is a tree in which all the internal nodes have a question, 
 * The answer to the question determines which way the program will
 *  proceed down the tree.  
 * All the leaf nodes have the decision (the kind of animal in the example tree).
 *
 * The decision tree may be a predermined decision tree, or it can be a "growing"
 * decision tree, where the user can add questions and decisions to the tree whenever
 * the tree gives a wrong answer.
 *
 * In the growing version, when the program guesses wrong, it asks the player
 * for another question that would help it in the future, and adds it (with the
 * correct answers) to the decision tree. 
 *
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class DecisionTree {

    public DTNode theTree;    // root of the decision tree;

    /**
     * Setup the GUI and make a sample tree
     */
    public static void main(String[] args){
        DecisionTree dt = new DecisionTree();
        dt.setupGUI();
        dt.makeSampleTree();
    }

    /**
     * Set up the interface
     */
    public void setupGUI(){
        UI.addButton("Run Tree", this::runTree);
        UI.addButton("Grow Tree", this::growTree);
        UI.addButton("Print Tree", this::printTree);
        UI.addButton("Draw Tree", this::drawTree);
        UI.addButton("Load Tree", this::loadTree);
        UI.addButton("Save Tree", this::saveTree);
        UI.addButton("Reset", this::makeSampleTree);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.5);
    }

    /**
     * Makes an initial tree with four question nodes and five leaf nodes.
     */
    public void makeSampleTree(){
        theTree = new DTNode("has whiskers",
            new DTNode("bigger than person",
                new DTNode("Tiger"),
                new DTNode("Cat")),
            new DTNode("has legs",
                new DTNode("has trunk",
                    new DTNode("Elephant"),
                    new DTNode("Rhino")),
                new DTNode("Snake")));
    }

    /**
     * Run the tree by starting at the top (of theTree), and working
     * down the tree until it gets to a leaf node (a node with no children)
     * If the node is a leaf it prints the answer in the node
     * If the node is not a leaf node, then it asks the question in the node,
     * and depending on the answer, goes to the "yes" child or the "no" child.
     */
    public void runTree() {
        /*# YOUR CODE HERE */
        boolean running = true;
        DTNode node = theTree;
        while (running == true){
            if (node.getYes() == null && node.getNo() == null){
                UI.println(node);
                running = false;
                return;
            }
            boolean answer = UI.askBoolean("Is it true: " + theTree + " (Y/N)");
            if (answer){
                node = node.getYes();
            }
            if (!answer){
                node = node.getNo();   
            }

        }

    }

    // You will need to define at least headers for the other methods to make the GUI work.
    /*# YOUR CODE HERE */
    public void growTree(){

    }

    public void printTree(){

    }

    public void drawTree(){

    }

    public void loadTree(){

    }

    public void saveTree(){

    }

}
