package Lab0;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lab0.Variant20;
import Lab0.Variant20.Cordinates;


public class TestVariant {

	public static double EPS = 0.0000001;
	
//	@Test
//	public void MassTest(){
//		AssertJUnit.assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
//	}
//
//	@Test(enabled = false)
//	public void loginOld() {
//
//		AssertJUnit.assertEquals(new Variant1().booleanTask(3), false);
//
//	}

	//////////////////////////////////
	@Test(dataProvider = "inputProvider")
	public void inputTest(Cordinates c1,Cordinates c2,int res) {
		AssertJUnit.assertEquals(new Variant20().inputOutputTask(c1,c2), res);
	}

	@DataProvider
	public Object[][] inputProvider() {
		Cordinates c = new Cordinates(2,5);
		Cordinates c1 = new Cordinates(12,3);
		Cordinates c2 = new Cordinates(3,8);
		Cordinates c3 = new Cordinates(9,5);
		Cordinates c4 = new Cordinates(13,14);
		Cordinates c5 = new Cordinates(25,17);
		return new Object[][] { { c, c1, 10 }, { c2, c3, 6 },{c4, c5, 12 },{ new Cordinates(0, 0), new Cordinates(1, 1), 1} };
	}
	/////////////////////////////////////////

//	@Test(expectedExceptions = AssertionError.class)
//	public void negativeInputTest() {
//		new Variant1().inputOutputTask(-2);
//	}

	////////////////////////////////////////////////

	@Test(dataProvider = "integerProvider")
	public void inputTest(int sec, int hours) {
		AssertJUnit.assertEquals(new Variant20().integerNumbersTask(sec), hours);
	}

	@DataProvider
	public Object[][] integerProvider() {
		return new Object[][] { { 7150, 1 }, { 10800, 3 }, { 7222, 2 } };
	}
//
//	@Test(expectedExceptions = AssertionError.class)
//	public void negativeIntegerTest() {
//		new Variant1().integerNumbersTask(-2);
//	}

	////////////////////////////////////////////////

	@Test(dataProvider = "ifProvider")
	public void ifTest(Cordinates A,Cordinates B,Cordinates C,int res) {
		AssertJUnit.assertEquals(new Variant20().ifTask(A,B,C), res);
	}

	@DataProvider
	public Object[][] ifProvider() {
		Cordinates A = new Cordinates(2,5);
		Cordinates B = new Cordinates(12,3);
		Cordinates C = new Cordinates(3,8);
		Cordinates A1 = new Cordinates(9,5);
		Cordinates B1 = new Cordinates(13,14);
		Cordinates C1 = new Cordinates(25,17);
		return new Object[][] { { A , B, C ,10 }, { A1 , B1 , C1 , 20 }};
	}

	//////////////////////////////////////////////////

	@Test(dataProvider = "booleanProvider")
	public void booleanTest(int number, boolean res) {
		AssertJUnit.assertEquals(new Variant20().booleanTask(number), res);
	}

	@DataProvider
	public Object[][] booleanProvider() {
		return new Object[][] { { 123, true }, { 113, false }, { 215, true } };
	}

	//////////////////////////////////////////////////

	@Test(dataProvider = "switchProvider")
	public void switchTest(int d,int m,String result) {
		AssertJUnit.assertEquals(new Variant20().switchTask(d,m), result);
	}

	@DataProvider
	public Object[][] switchProvider() {
		return new Object[][] { { 25, 3 , "Oven" }, { 6, 6,"Twin" } };
	}

//	@Test(expectedExceptions = AssertionError.class)
//	public void switchNegativeTest() {
//		new Variant1().forTask(10);
//	}

	///////////////////////////////////////////////////

	@Test(dataProvider = "forProvider")
	public void forTest(int n, double p2) {
		AssertJUnit.assertEquals(new Variant20().forTask(n), p2, EPS);
	}

	@DataProvider
	public Object[][] forProvider() {
		return new Object[][] { { 8, 40320 }, {15 ,1.307674368E12 }};
	}

	///////////////////////////////////////////////////

		//////////////////////////////////////////

	@Test(dataProvider = "whileProvider")
	public void whileTest(int N,boolean result) {
		AssertJUnit.assertEquals(new Variant20().whileTask(N), result);
	}

	@DataProvider
	public Object[][] whileProvider() {
		return new Object[][] { { 222, true }, { 13, false }, { 1323 , true }, { 13367 , false },{20,true} };
	}

	@Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
//	public void negativeWhileTest(int a, int b) {
//		new Variant1().whileTask(a, b);
//	}

	@DataProvider
	public Object[][] negativeWhileProvider() {
		return new Object[][] { { 1, 2 }, { -2, 1 }, { 2, -1 } };
	}

	//////////////////////////////////////////
	@Test(dataProvider = "arrayProvider")
	public void arrayTest(double[] array, int result) {
		AssertJUnit.assertEquals(new Variant20().arrayTask(array), result);
	}

	@DataProvider
	public Object[][] arrayProvider() {
		return new Object[][] { { new double[] { 10, 2, 3 , 3 ,1 ,1 , 4 }, 2 }, { new double[] { 10, 2, 1 }, 0 },
				{ new double[] { 4, 3, 5, -4, 9, 9 ,2 }, 2 } };
	}

	

	//////////////////////////////////////////
	
	@Test(dataProvider = "matrixProvider")
	public void twoDimensionArrayTest(double[][] input,double[][] output) {
		//AssertJUnit.assertEquals(new Variant1().twoDimensionArrayTask(input), output);
		double[][] array= new Variant20().twoDimensionArrayTask(input);
		for(int i=0;i<array.length;i++) {
			for(int j = 0 ;j<array[i].length;j++) {
				assertEquals(array[i][j], output[i][j]);
			}
		}
	}

	@DataProvider
	public Object[][] matrixProvider() {
		double[][] input = {{2, 3, 6, 9, -9},
				{-34, -98, -9, -2,-1},
				{4, 2, 1, 6, 1},
				{98, 8,1, 5, 3}};
		
		double[][] res =  {{2, 3, 6, 9, -9},
				{4, 2, 1, 6, 1},
				{98, 8,1, 5, 3}};
		
		double[][] input2 = {{-98, 8, 1, 5, 3},
				{-4, 2, 1, 6, 1},
				{34, 98, -9, 2, 1},
				{-2, -3, -6, -9, -9}};
		double[][] res2 ={{-98, 8, 1, 5, 3},
				{-4, 2, 1, 6, 1},
				{34, 98, -9, 2, 1}
				};
		double[][] input3 = {{-98, 8, 1, 5, 3},
				{-4, 2, 1, 6, 1},
				{34, 98, -9, 2, 1},
				{-2, -3, -6, -9, -9}};
		double[][] res3 = {{-98, 8, 1, 5, 3},
				{-4, 2, 1, 6, 1},
				{34, 98, -9, 2, 1},
				{-2, -3, -6, -9, -9}};
		
		return new Object[][] { {input, res},{ input2, res2 },{ input3, res3 } };
		
	}
	
//	@Test
//	public void arrayTest2(){
//		AssertJUnit.assertEquals(new int[]{2, 3}, new int[]{2, 3});
//	}
	
}
