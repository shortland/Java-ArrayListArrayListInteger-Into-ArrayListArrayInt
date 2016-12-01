import java.util.ArrayList;

public class ArrayListArrayListIntegerToArrayListIntegerArray {

	public static void main(String[] args) {
		ArrayList<Integer> hasValues1 = new ArrayList<Integer>();
		hasValues1.add(2);
		hasValues1.add(5);
		hasValues1.add(3);

		ArrayList<Integer> hasValues2 = new ArrayList<Integer>();
		hasValues2.add(6);
		hasValues2.add(8);
		hasValues2.add(28);

		ArrayList<Integer> hasValues3 = new ArrayList<Integer>();
		hasValues3.add(1011);
		hasValues3.add(1052);
		hasValues3.add(8123);

		ArrayList<ArrayList<Integer>> iniList =  new ArrayList<ArrayList<Integer>>();
		iniList.add(hasValues1);
		iniList.add(hasValues2);
		iniList.add(hasValues3);
		
		/*
		// uncomment this to view the array structure
		System.out.println("Make Work:");
		
		for(int i = 0; i < getIt(iniList).size(); i++) {
			for(int j = 0; j < getIt(iniList).get(0).length; j++) {
				System.out.print(getIt(iniList).get(i)[j] + " ");
			}
			System.out.println();
		}
		*/
	}

	public static ArrayList<int[]> getIt(ArrayList<ArrayList<Integer>> intListList) {
		ArrayList<int[]> arrayNew = new ArrayList<int[]>();
		int[] start = new int[0];
		return addThem(arrayNew, start, intListList, 0, 0);
	}

	public static ArrayList<int[]> addThem(ArrayList<int[]> mainNew, int[] start, ArrayList<ArrayList<Integer>> headArray, int row, int col) {

		if(col == (headArray.get(0).size()-1)) {
			int[] startN = addItFunc(start, headArray.get(row).get(col));
			if(row == (headArray.size()-1)) {
				mainNew.add(row, startN);
				return mainNew;
			}
			else {
				mainNew.add(row, startN);
				startN = null;
				startN = new int[0];
				return addThem(mainNew, startN, headArray, (row+1), 0);
			}
		}
		else {
			int[] startN = addItFunc(start, headArray.get(row).get(col));
			return addThem(mainNew, startN, headArray, row, (col+1));
		}

	}

	public static int[] addItFunc(int[] existing, int newItem) {
		if(existing.length == 0) {
			int[] newAr = {newItem};
			return newAr;
		}
		else {
			int[] newerAr = new int[existing.length + 1];
			return addItFunc(existing, newItem, newerAr, 0);
		}
	}

	public static int[] addItFunc(int[] existing, int newItem, int[] newerAr, int pos) {
		if(pos < existing.length) {
			newerAr[pos] = existing[pos];
			return addItFunc(existing, newItem, newerAr, pos+1);
		}
		else {
			newerAr[pos] = newItem;
			return newerAr;
		}
	}

}