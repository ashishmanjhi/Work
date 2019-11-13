package com.ref;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainStreamFunctions {

	//Driver Function
	public static void main(String[] args) {
		
		Computer[] arrayOfComps = {
				new Computer(1, "Apple", 100000), 
				new Computer(2, "HP", 30000), 
				new Computer(3, "Dell", 40000),
				new Computer(4, "Dell", 36001),
				new Computer(5, "Acer", 32002),
				new Computer(6, "Aleinware", 112004),
		};
		List<Computer> compList = Arrays.asList(arrayOfComps);
		
		//DemoStreamFunction Class object
		DemoStreamFunctions demo=new DemoStreamFunctions();
		
		//Calling DemoStreamFunction class methods
		demo.whenLimitInfiniteStream_thenGetFiniteElements();
		demo.whenFlatMapEmployeeNames_thenGetNameStream();
		demo.whenUsingPeek_thenApply();
		demo.whenFindFirst_thenGetFirstComputerInStream(compList);
		demo.whenApplyDistinct_thenRemoveDuplicatesFromStream();
		demo.whenApplyMatch_thenReturnBoolean();
		demo.whenFindMaxOnIntStream_thenGetMaxInteger(compList);
		demo.whenApplySumOnIntStream_thenGetSum(compList);
		demo.whenApplyReduceOnStream_thenGetValue(compList);
		demo.whenCollectByJoining_thenGetJoinedString(compList);
		demo.whenCollectBySet_thenGetSet(compList);
		demo.whenToVectorCollection_thenGetVector(compList);
		demo.whenApplySummarizing_thenGetBasicStats(compList);
		demo.whenStreamPartition_thenGetMap();
		demo.whenStreamGroupingBy_thenGetMap(compList);
		demo.whenStreamMapping_thenGetMap(compList);
		demo.whenStreamReducing_thenGetValue(compList);
		demo.whenStreamGroupingAndReducing_thenGetMap(compList);
		demo.whenGenerateStream_thenGetInfiniteStream();
		demo.whenIterateStream_thenGetInfiniteStream();
		try {
			demo.whenStreamToFile_thenGetFile();
			demo.whenFileToStream_thenGetStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

}
}
