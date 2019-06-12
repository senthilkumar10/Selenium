package week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List; //
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnList {

	/**
	 * 
	 * Collections - 
	 * 
	 * 
	 * All collections frameworks contain the following:
	 * 
	 * 1) Interfaces: These are abstract data types that 
	 * represent collections.Interfaces allow collections 
	 * to be manipulated independently of the details
	 * 
	 * 2) Implementations: These are the concrete 
	 * implementations of the collection interfaces.
	 * In essence, they are reusable data structures.
	 * 
	 * 3) Algorithms: These are the methods that perform 
	 * useful computations, such as searching and sorting, 
	 * on objects that implement collection interfaces.
	 * The algorithms are said to be polymorphic: 
	 * that is, the same method can be used on many
	 * different implementations of the appropriate 
	 * collection interface. 
	 * 
	 * 
	 */


	/**
	 * Date: 21 Jan 2018
	 * 
	 * 1) 
	 * List is an interface
	 * An ordered collection (also known as a sequence). 
	 * The user of this interface has precise control over where in the list each element is inserted. 
	 * The user can access elements by their integer index (position in the list),
	 * and search for elements in the list.
	 * 
	 * Lists typically allow duplicate elements.
	 * Lists (like Java arrays) are zero based 
	 * 
	 * 2) 
	 * ArrayList is one of the implementation of the List interface 
	 * ArrayList has few additional methods on top of List interface
	 *
	 * 3) 
	 * Methods we will learn today
	 * 
	 * size, get(index), add, remove, clear, isEmpty
	 */

	public static void main(String[] args) {

		// Create a List
		List<String> mentors = new ArrayList<String>();

		// Add mentors to the List -- Note the order
		mentors.add("Rasheed");
		mentors.add("Gopi");
		mentors.add("Sethu");
		mentors.add("Nesa");
		mentors.add("Sarath");
		mentors.add("babu");
		
		// Now get the count
		System.out.println("The total mentors are :"+mentors.size());

		// Try duplicate
		mentors.add("Gopi");

		// Now get the count
		System.out.println("The total mentors are :"+mentors.size());

		// Print the name of all mentors -- you will notice the order in the list not maintained
		for (String mentor : mentors) {
			System.out.println(mentor);
		}

		// contains
		System.out.println("Is Gopi is available "
				+ "in the set :"+mentors.contains("Gopi"));

		// remove
	mentors.remove("Gopi");

		// contains
		System.out.println("Is Gopi is available in the List"
				+ " after removal :"+mentors.contains("Gopi"));


		System.out.println("*********************");
		
		Collections.sort(mentors);
		for (String mentor : mentors) {			
			System.out.println(mentor);
		}

		// clear
		mentors.clear();

		// check if it empty
		System.out.println("The List is empty :"
				+ ""+mentors.isEmpty());

	}
}
