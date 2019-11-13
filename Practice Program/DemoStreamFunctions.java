package com.ref;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Class contain various function on steam
public class DemoStreamFunctions {

//When Limit InfiniteStream and then GetFiniteElements
	public void whenLimitInfiniteStream_thenGetFiniteElements() {
		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

		List<Integer> collect = infiniteStream
				.skip(3)
				.limit(5)
				.collect(Collectors.toList());
		System.out.println("Finite Elements using short-circuiting operations :");
		collect.stream().forEach(System.out::println);

	}
//--------------------------------------------------------------------------------------------------	
	//When FlatMap Employee Names and then Get NameStream
	public void whenFlatMapEmployeeNames_thenGetNameStream() {
		List<List<String>> namesNested = Arrays.asList( 
				Arrays.asList("Jeff", "Bezos"), 
				Arrays.asList("Bill", "Gates"), 
				Arrays.asList("Mark", "Zuckerberg"));

		List<String> namesFlatStream = namesNested.stream()
				.flatMap(Collection::stream)

				.collect(Collectors.toList());

		System.out.println("\nFlatMap elements :");
		namesFlatStream.parallelStream().forEach(System.out::println);
	}

	//--------------------------------------------------------------------------------------------------
	//When Using Peek 
	public void whenUsingPeek_thenApply() {
		Computer[] arrayOfEmps = {
				new Computer(1, "Jeff Bezos", 100000), 
				new Computer(2, "Bill Gates", 200000), 
				new Computer(3, "Mark Zuckerberg", 300000)
		};

		List<Computer> empList = Arrays.asList(arrayOfEmps);
		System.out.println("\nPeek function two operation at a time :");
		empList.stream()
		.peek(e -> {
			if(e.getPrice()>100000) 
				e.setPrice(100);
		})
		.peek(System.out::println)
		.collect(Collectors.toList());


	}

	//--------------------------------------------------------------------------------------------------
	//When FindFirst and then GetFirst Computer InStream
	public void whenFindFirst_thenGetFirstComputerInStream(List<Computer> compList) {

		Computer computer = compList.stream()
				.filter(e -> e != null)
				.filter(e -> e.getPrice() > 30000)
				.findFirst()
				.orElse(null);
		System.out.println("\nFind First function :"+computer);

	}

	//--------------------------------------------------------------------------------------------------
	//when Apply Distinct and then Remove Duplicates From Stream
	public void whenApplyDistinct_thenRemoveDuplicatesFromStream() {
	    List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
	    List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
	    System.out.println("\nDistinct function :");
	    distinctIntList.stream().forEach(System.out::println);
	}
	
	//----------------------------------------------------------------------------------------------------

	//When Apply Match and then Return Boolean
	public void whenApplyMatch_thenReturnBoolean() {
	    List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
	    
	    boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
	    boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
	    boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);
	    System.out.println("\n"+"AllEven ="+allEven+", OneEven ="+oneEven+", None*of3 ="+noneMultipleOfThree+".");
	}

	//--------------------------------------------------------------------------------------------------
	//When FindMax On IntStream and then Get Max Integer
	public void whenFindMaxOnIntStream_thenGetMaxInteger(List<Computer> compList) {
	
	    Integer latestCompId = compList.stream()
	      .mapToInt(Computer::getId)
	      .max()
	      .orElseThrow(NoSuchElementException::new);
	    System.out.println("\nMax on IntStream ="+latestCompId);
	    
	}

	//--------------------------------------------------------------------------------------------------
	//When Apply Sum On IntStream and then Get Sum
	public void whenApplySumOnIntStream_thenGetSum(List<Computer> compList) {
	    Double avgPrice = compList.stream()
	      .mapToDouble(Computer::getPrice)
	      .average()
	      .orElseThrow(NoSuchElementException::new);
	    
	    System.out.println("\n Average Sum of Price of Computer :"+avgPrice);
	    
	}

	//--------------------------------------------------------------------------------------------------

	//When Apply Reduce On Stream and then Get Value
	public void whenApplyReduceOnStream_thenGetValue(List<Computer> compList) {
	    Long sumPrice = compList.stream()
	      .map(Computer::getPrice)
	      .reduce((long) 0.0, Long::sum);
	    System.out.println("\nReduce Function to get Total Price of Computer:"+sumPrice);	    
	}
	//--------------------------------------------------------------------------------------------------

	//When Collect By Joining and then Get Joined String
	public void whenCollectByJoining_thenGetJoinedString(List<Computer> compList) {
	    String compNames = compList.stream()
	      .map(Computer::getName)
	      .collect(Collectors.joining(", "))
	      .toString();
	    System.out.println("\nJoining Function by Name of Computer :"+compNames);
	 }
	//--------------------------------------------------------------------------------------------------

		//When Collect By Set and then Get Set
	public void whenCollectBySet_thenGetSet(List<Computer> compList) {
	    Set<String> compNames = compList.stream()
	            .map(Computer::getName)
	            .collect(Collectors.toSet());
	    System.out.println("\ntoSet function to show Computer Names: ");
	    compNames.stream().forEach(System.out::println);
	}
	//--------------------------------------------------------------------------------------------------

	//when ToVectorCollection and then Get Vector
	public void whenToVectorCollection_thenGetVector(List<Computer> compList) {
	    Vector<String> compNames = compList.stream()
	            .map(Computer::getName)
	            .collect(Collectors.toCollection(Vector::new));

	    System.out.println("\n toCollection function to show Computer Names: ");
	    compNames.stream().forEach(System.out::println);
	}
	//--------------------------------------------------------------------------------------------------

		//When Apply Summarizing and then Get Basic Stats
	public void whenApplySummarizing_thenGetBasicStats(List<Computer> compList) {
	    DoubleSummaryStatistics stats = compList.stream()
	      .collect(Collectors.summarizingDouble(Computer::getPrice));

	    System.out.println("\nSummaray Statistics function for Computer :");
	    System.out.println("Count = "+stats.getCount()+"");
	    System.out.println("Total Price = "+stats.getSum());
	    System.out.println("Min Price = "+stats.getMin());
	    System.out.println("Max Price = "+stats.getMax());
	    System.out.println("Average Price= "+stats.getAverage());
	}
	//--------------------------------------------------------------------------------------------------

	//When Stream Partition and then Get Map
	public void whenStreamPartition_thenGetMap() {
	    List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
	    Map<Boolean, List<Integer>> isEven = intList.stream().collect(
	      Collectors.partitioningBy(i -> i % 2 == 0));
	    System.out.println("\nPartitionBy function :");
	    System.out.println("Even no:"+isEven.get(true).size());
	    System.out.println("Odd no:"+isEven.get(false).size());
	}
	//--------------------------------------------------------------------------------------------------

		//When Stream GroupingBy and then GetMap
	public void whenStreamGroupingBy_thenGetMap(List<Computer> compList) {
	    Map<Character, List<Computer>> groupByAlphabet = compList.stream().collect(
	      Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));

	    System.out.println("\nGroupingBy function :");
   System.out.println((groupByAlphabet.get('D')));
   System.out.println(groupByAlphabet.get('D').get(0));
   System.out.println(groupByAlphabet.get('D').get(0).getName());
	}
	//--------------------------------------------------------------------------------------------------

	// When Stream Mapping and then GetMap
	public void whenStreamMapping_thenGetMap(List<Computer> compList) {
	    Map<Character, List<Integer>> idGroupedByAlphabet = compList.stream().collect(
	      Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
	        Collectors.mapping(Computer::getId, Collectors.toList())));

	    System.out.println("\nMapping function :");
	    System.out.println(idGroupedByAlphabet.get('A'));
	    System.out.println(idGroupedByAlphabet.get('D').get(0));
	    System.out.println(idGroupedByAlphabet.get('H'));
	}
	//--------------------------------------------------------------------------------------------------

		//When Stream Reducing and then GetValue
	public void whenStreamReducing_thenGetValue(List<Computer> compList) {
	    Double percentage = 10.0;
	    Double priceIncrOverhead = compList.stream().collect(Collectors.reducing(
	        0.0, e -> e.getPrice() * percentage / 100, (s1, s2) -> s1 + s2));

	    System.out.println("\nReducing Function :"+priceIncrOverhead);
	}
	//--------------------------------------------------------------------------------------------------	
	
	// When Stream Grouping And Reducing then GetMap
	public void whenStreamGroupingAndReducing_thenGetMap(List<Computer> compList) {
	    Comparator<Computer> byNameLength = Comparator.comparing(Computer::getName);
	    
	    //we find the computer with the longest name
	    Map<Character, Optional<Computer>> longestNameByAlphabet = compList.stream().collect(
	      Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
	        Collectors.reducing(BinaryOperator.maxBy(byNameLength))));

	    System.out.println("\nStream Grouping And Reducing function by initials:");
	    System.out.println(longestNameByAlphabet.get('A').get().getName());
	    System.out.println(longestNameByAlphabet.get('D').get().getName());
	    System.out.println(longestNameByAlphabet.get('H').get().getName());
	}
	//--------------------------------------------------------------------------------------------------	
	
		//	when Generate Stream then Get InfiniteStream
	public void whenGenerateStream_thenGetInfiniteStream() {
		System.out.println("\nGenerate Stream of random no :");
	    Stream.generate(Math::random)
	      .limit(5)
	      .forEach(System.out::println);
	}
	//--------------------------------------------------------------------------------------------------	
	
		//when Iterate Stream  then Get InfiniteStream
	public void whenIterateStream_thenGetInfiniteStream() {
	    Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

	    List<Integer> collect = evenNumStream
	      .limit(6)
	      .collect(Collectors.toList());

	   System.out.println("\n"+collect);
	}
	//--------------------------------------------------------------------------------------------------	
	
			//when Stream ToFile then GetFile()
	
	public void whenStreamToFile_thenGetFile() throws IOException {
	
	    String[] words = {
	      "hello", 
	      "refer",
	      "world",
	      "level"
	    };
	    
	    try (PrintWriter pw = new PrintWriter(
	      Files.newBufferedWriter(Paths.get("C:\\Users\\Ashish.manjhi\\Desktop\\test.txt")))) {
	        Stream.of(words).forEach(pw::println);
	    }
	}
	//--------------------------------------------------------------------------------------------------	
	
	// when FileToStream  then Get Stream
	private List<String> getPalindrome(Stream<String> stream, int length) {
	    return stream.filter(s -> s.length() == length)
	      .filter(s -> s.compareToIgnoreCase(
	        new StringBuilder(s).reverse().toString()) == 0)
	      .collect(Collectors.toList());
	}
	
	public void whenFileToStream_thenGetStream() throws IOException {
	    List<String> str = getPalindrome(Files.lines(Paths.get("C:\\Users\\Ashish.manjhi\\Desktop\\test.txt")), 5);
	   System.out.println("\nGet palindrome words from file :"+str);
	}
}
