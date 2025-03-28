package ParallelExecution;

import org.testng.annotations.Test;

public class Testclass2 {
	@Test
	public void Test5()
	{
		System.out.println("Testclass2"+"Test5"+"-->"+Thread.currentThread().getId());
	}
	@Test
	public void Test6()
	{
		System.out.println("Testclass2"+"Test6"+"-->"+Thread.currentThread().getId());
	}
	@Test
	public void Test7()
	{
		System.out.println("Testclass2"+"Test7"+"-->"+Thread.currentThread().getId());
	}
	@Test
	public void Test8()
	{
		System.out.println("Testclass2"+"Test8"+"-->"+Thread.currentThread().getId());
	}
	}
