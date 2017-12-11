package Lab0;

public class Variant20 {
	
	public static class Cordinates{
		public int x;
		public int y;
		public Cordinates(int x1,int y1){
			x = x1;
			y = y1;
		}
	}
	public int inputOutputTask(Cordinates c1,Cordinates c2) {
		assert (c1.x >= 0) && (c1.y >= 0) && (c2.x >= 0) && (c2.y >= 0) : "Cordinates should be >= than zero ";
		
		//return (double)System.out.format("%f.2",Math.sqrt((c2.x-c1.x)*(c2.x-c1.x) + (c2.y-c1.y)*(c2.y-c1.y)));
		
		return (int)Math.sqrt((c2.x-c1.x)*(c2.x-c1.x) + (c2.y-c1.y)*(c2.y-c1.y));
	}
	


	/**
	 * 
	 * @param k is square side
	 * @return perimeter
	 */
	
	
	/**
	 * 
	 * @param k is distance in cm
	 * @return distance in m
	 */

	public int integerNumbersTask(int hours) {
		assert ( hours >= 0) : "Hours should be more than zero ";
		return (int)(hours/3600);
	}

	/**
	 * 
	 * @param number
	 * @return true, if number is possitive
	 */
	public boolean booleanTask(int number) {
		assert number >0: "Argument should be more than zero";
		int[] arr = new int[3];
		int i = 0;
		while(number > 0) {
			arr[i] = number%10;
			number = number/10;
			i++;
		}
		if((arr[0] == arr[1])|| (arr[0] == arr[2]) || (arr[1] == arr[2]))
		{
			return false;
		}else {
			return true;	
		}
	}
	
	
	/**
	 * 
	 * @param parameter is integer number
	 * @return transformed number
	 */
	public int ifTask(Cordinates c1,Cordinates c2,Cordinates c3) {
		assert (c1.x >= 0) && (c1.y >= 0) && (c2.x >= 0) && (c2.y >= 0) && (c3.x >= 0) && (c3.y >= 0) : "Cordinates should be >= than zero ";
		int AB = inputOutputTask(c1,c2);
		int AC = inputOutputTask(c1,c3);
		if(AB > AC) {
			return AB;
		}else {
			return AC;	
		}
	}

	public class Data{
		public int day;
		public int month;
		public Data(int d,int m) {
			day = d;
			month = m;
		}
	}
	/**
	 * 
	 * @param number1
	 * @return day of week day represented number1
	 */
	public String switchTask(int d,int m) {
		assert(d > 0 ) &&( m > 0): "Arguments should be more than zero";
		String zodiac = "";
		switch(m) {
		case 1:
			if(d < 20) {
				zodiac = "Corpricon";
			}else {
				zodiac = "Vodoley";
			}
			break;
		case 2:
			if(d < 19) {
				zodiac = "Vodoley";
			}else {
				zodiac = "Fish";
			}
			break;
		case 3:
			if(d < 21) {
				zodiac = "Fish";
			}else {
				zodiac = "Oven";
			}
			break;
		case 4:
			if(d < 20) {
				zodiac = "Oven";
			}else {
				zodiac = "Telec";
			}
			break;
		case 5:
			if(d < 21) {
				zodiac = "Telec";
			}else {
				zodiac = "Twin";
			}
			break;
		case 6:
			if( d < 22) {
				zodiac = "Twin";
			}else {
				zodiac = "Lobster";
			}
			break;
		case 7: 
			if( d < 23) {
				zodiac = "Lobster";
			}else {
				zodiac = "Lion";
			}
			break;
		case 8:
			if( d < 23 ) {
				zodiac = "Lion";
			}else {
				zodiac = "Maiden";
			}
			break;
		case 9:
			if( d < 23) {
				zodiac = "Maiden";
			}else {
				zodiac = "Scorpion";
			}
			break;
		case 10:
			if( d < 23) {
				zodiac = "Scorpion";
			}else {
				zodiac = "Archer";
			}
			break;
		case 11:
			if( d < 22) {
				zodiac = "Archer";
			}else {
				zodiac = "Corpricon";
			}
			break;
		case 12: 
			if( d < 20) {
				zodiac = "Corpricon";
			}else {
				zodiac = "Vodoley";
			}
			break;
		}
		
	
		return zodiac;
	}


/**
 * 
 * @param n is integer number
 * @return approximated value of exp(1)
 */
	public double forTask(int N) {
		assert N >0: "Argument should be more than zero";
		double summa = 1;
		for(int i = 1 ; i <= N ; i++) {
			summa *= i;
		}
		return summa;
	}

	
	public boolean whileTask(int number) {
		assert ( number >0 ): "Argument should be more than zero";
		
		while( number > 0) {
			if(number%10 == 2) {
				return true;
			}
			number /= 10;
			
		}
		return false;
	}

	public int arrayTask(double[] array) {
		int count = 0;
		boolean f = true;
		for(int i  = 0 ; i < array.length-1;i++) {
			if((array[i] <= array[i+1]) && f ){
				count++;
				f = false;
			}else {
				f = true;
			}
		}
		
		return count;
	}

	/**
	 * 
	 * @param array
	 * @return return last column where all less then 0
	 */
	public double[][]  twoDimensionArrayTask(double[][] array) {
		int count = 0;
		int lastNegativeRow = 0;
		boolean todo = false;
		for(int k = 0; k <array.length;k++) {
			count = 0;
			for(int j = 0; j < array[k].length ;j++) {
				if(array[k][j] < 0) {
					count++;
				}
				if(count == array[k].length -1 ) {
					todo = true;
					lastNegativeRow = k;
				}
			}
		}
		if(todo) {
			
			double[][] array2 = new double[array.length-1][array[0].length];	
			for(int rowIndex = 0,i = 0; rowIndex < array.length ; rowIndex++) {
				if(rowIndex != lastNegativeRow) {
					for(int j = 0; j < array[rowIndex].length ; j++) {
						array2[i][j] = array[rowIndex][j];
					}
					i++;
				}	
			}
			return array2;
		}else {
			return array;
		}
		
	}

	public static void main(String... strings) {
		System.out.println("Start of zero lab");
		System.out.println("Almost done");
		
	}

}
