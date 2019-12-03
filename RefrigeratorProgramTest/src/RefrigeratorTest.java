import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import com.refrigerator.Item;
import com.refrigerator.Refrigerator;
import com.refrigerator.Refrigerator.ItemNotFoundException;
import com.refrigerator.Refrigerator.NotEnoughSpaceException;
import com.refrigerator.Shelf;

public class RefrigeratorTest {

	@Test
	public void itemInsertionsTest() throws Exception{
		List<Shelf> shelves=new ArrayList<Shelf>();
		shelves.add(new Shelf(1,10));
		shelves.add(new Shelf(2,12));
		shelves.add(new Shelf(3,13));
		shelves.add(new Shelf(4,14));

		Refrigerator refrigerator=new Refrigerator(shelves);


		//Adding items inside the refrigerator
		refrigerator.addItem(new Item(101, "Milk",1.0f));
		refrigerator.addItem(new Item(102, "apple",2.0f));
		refrigerator.addItem(new Item(103, "cake",5.0f));
		refrigerator.addItem(new Item(104, "drink",9.0f));
		refrigerator.addItem(new Item(105, "beer",6.0f));
		refrigerator.addItem(new Item(106, "Banana",5.0f));
		refrigerator.addItem(new Item(107, "Mango",4.0f));
		refrigerator.addItem(new Item(108, "Ice",3.0f));
		refrigerator.addItem(new Item(109, "Ice1",6.0f));
		refrigerator.addItem(new Item(110, "Ice2",5.0f));
		refrigerator.addItem(new Item(111, "Ice3",3.0f));

		DoubleSummaryStatistics stats1 = shelves.stream()
				.collect(Collectors.summarizingDouble(Shelf::getRemainingCapacity));

		System.out.println("remaining space"+stats1.getSum());
	}

	@Test(expected = NotEnoughSpaceException.class)
	public void refrigeratorException1Test() throws Exception{

		List<Shelf> shelves=new ArrayList<Shelf>();
		shelves.add(new Shelf(1,10));
		shelves.add(new Shelf(2,12));
		shelves.add(new Shelf(3,13));
		shelves.add(new Shelf(4,14));

		//Refrigerator object
		Refrigerator refrigerator=new Refrigerator(shelves);


		//Adding items inside the refrigerator
		refrigerator.addItem(new Item(101, "Milk",1.0f));
		refrigerator.addItem(new Item(102, "apple",2.0f));
		refrigerator.addItem(new Item(103, "cake",5.0f));
		refrigerator.addItem(new Item(104, "drink",9.0f));
		refrigerator.addItem(new Item(105, "beer",6.0f));
		refrigerator.addItem(new Item(106, "Banana",5.0f));
		refrigerator.addItem(new Item(107, "Mango",4.0f));
		refrigerator.addItem(new Item(108, "Ice",3.0f));
		refrigerator.addItem(new Item(109, "Ice1",6.0f));
		refrigerator.addItem(new Item(110, "Ice2",5.0f));
		refrigerator.addItem(new Item(111, "Ice3",3.0f));
		DoubleSummaryStatistics stats1 = shelves.stream()
				.collect(Collectors.summarizingDouble(Shelf::getRemainingCapacity));

		System.out.println("remaining space"+stats1.getSum());
		
		//inserting after space is zero 
		refrigerator.addItem(new Item(112, "Ice4",3.0f));


	}


	@Test(expected = NotEnoughSpaceException.class)
	public void refrigeratorException2Test() throws Exception{

		List<Shelf> shelves=new ArrayList<Shelf>();
		shelves.add(new Shelf(1,10));
		shelves.add(new Shelf(2,12));
		shelves.add(new Shelf(3,13));
		shelves.add(new Shelf(4,14));

		//Refrigerator object
		Refrigerator refrigerator=new Refrigerator(shelves);


		//Adding items inside the refrigerator
		refrigerator.addItem(new Item(101, "Milk",1.0f));
		refrigerator.addItem(new Item(102, "apple",2.0f));
		refrigerator.addItem(new Item(103, "cake",5.0f));
		refrigerator.addItem(new Item(104, "drink",9.0f));
		refrigerator.addItem(new Item(105, "beer",6.0f));
		refrigerator.addItem(new Item(106, "Banana",5.0f));
		refrigerator.addItem(new Item(107, "Mango",4.0f));
		refrigerator.addItem(new Item(108, "Ice",3.0f));
		refrigerator.addItem(new Item(109, "Ice1",6.0f));
		refrigerator.addItem(new Item(110, "Ice2",4.0f));
		DoubleSummaryStatistics stats1 = shelves.stream()
				.collect(Collectors.summarizingDouble(Shelf::getRemainingCapacity));

		System.out.println("remaining space"+stats1.getSum());
		
		//inserting after remaining space is 4 but can not be inserted  
		refrigerator.addItem(new Item(111, "Ice4",4.0f));


	}

	@Test(expected = ItemNotFoundException.class)
	public void refrigeratorException3Test() throws Exception{

		List<Shelf> shelves=new ArrayList<Shelf>();
		shelves.add(new Shelf(1,10));
		shelves.add(new Shelf(2,12));
		shelves.add(new Shelf(3,13));
		shelves.add(new Shelf(4,14));

		//Refrigerator object
		Refrigerator refrigerator=new Refrigerator(shelves);


		//Adding items inside the refrigerator
		refrigerator.addItem(new Item(101, "Milk",1.0f));
		refrigerator.addItem(new Item(102, "apple",2.0f));
		refrigerator.addItem(new Item(103, "cake",5.0f));
		refrigerator.addItem(new Item(104, "drink",9.0f));
		refrigerator.addItem(new Item(105, "beer",6.0f));
		refrigerator.addItem(new Item(106, "Banana",5.0f));
		refrigerator.addItem(new Item(107, "Mango",4.0f));
		refrigerator.addItem(new Item(108, "Ice",3.0f));
		refrigerator.addItem(new Item(109, "Ice1",6.0f));
		refrigerator.addItem(new Item(110, "Ice2",3.0f));
		DoubleSummaryStatistics stats1 = shelves.stream()
				.collect(Collectors.summarizingDouble(Shelf::getRemainingCapacity));

		System.out.println("remaining space"+stats1.getSum());

		//Taking out an item from the refrigerator while the item is not present by using itemId .
		System.out.println("item taken out by the user by item id "+refrigerator.getItemById(111));


	}
	
	@Test
	public void itemRemovalTest() throws Exception{
		List<Shelf> shelves=new ArrayList<Shelf>();
		shelves.add(new Shelf(1,10));
		shelves.add(new Shelf(2,12));
		shelves.add(new Shelf(3,13));
		shelves.add(new Shelf(4,14));

		Refrigerator refrigerator=new Refrigerator(shelves);


		//Adding items inside the refrigerator
		refrigerator.addItem(new Item(101, "Milk",1.0f));
		refrigerator.addItem(new Item(102, "apple",2.0f));
		refrigerator.addItem(new Item(103, "cake",5.0f));
		refrigerator.addItem(new Item(104, "drink",9.0f));
		refrigerator.addItem(new Item(105, "beer",6.0f));
		refrigerator.addItem(new Item(106, "Banana",5.0f));
		refrigerator.addItem(new Item(107, "Mango",4.0f));
		refrigerator.addItem(new Item(108, "Ice",3.0f));
		refrigerator.addItem(new Item(109, "Ice1",6.0f));
		refrigerator.addItem(new Item(110, "Ice2",5.0f));
		refrigerator.addItem(new Item(111, "Ice3",3.0f));

		DoubleSummaryStatistics stats1 = shelves.stream()
				.collect(Collectors.summarizingDouble(Shelf::getRemainingCapacity));

		System.out.println("remaining space"+stats1.getSum());
		
		//Taking out an item from the refrigerator by using itemId.
		System.out.println("item taken out by the user by item id "+refrigerator.getItemById(111));

		//Taking out an item from the refrigerator by using item name.
		System.out.println("item taken out by the user by item name "+refrigerator.getItemByName("Ice1"));

	}
}
