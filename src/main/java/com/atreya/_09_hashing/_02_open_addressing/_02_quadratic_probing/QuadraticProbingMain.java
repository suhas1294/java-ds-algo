package com.atreya._09_hashing._02_open_addressing._02_quadratic_probing;

public class QuadraticProbingMain {
    public static void main(String[] args) {

        //Constructor
        QuadraticProbing quadraticProbing = new QuadraticProbing();


        quadraticProbing.insertKeyInHashTable("The");
        quadraticProbing.insertKeyInHashTable("quick");
        quadraticProbing.insertKeyInHashTable("brown");
        quadraticProbing.insertKeyInHashTable("fox");
        quadraticProbing.insertKeyInHashTable("over");
        quadraticProbing.insertKeyInHashTable("lazy");
        quadraticProbing.displayHashTable();

		/*quadraticProbing.insertKeyInHashTable("fox"); //use for showing collision
		quadraticProbing.displayHashTable();

		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.displayHashTable();

		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.displayHashTable();

		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.displayHashTable();


		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.displayHashTable();*/



        quadraticProbing.searchKeyInHashTable("jump");
        quadraticProbing.searchKeyInHashTable("brown");


        quadraticProbing.deleteKeyFromHashTable("jump");
        quadraticProbing.displayHashTable();


        quadraticProbing.deleteKeyFromHashTable("quick");
        quadraticProbing.displayHashTable();


        quadraticProbing.deleteHashTable();
        quadraticProbing.displayHashTable();


    }//end of method

}
