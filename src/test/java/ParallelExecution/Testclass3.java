package ParallelExecution;

import org.testng.annotations.Test;

public class Testclass3 {
	@Test
	public void Test9()
	{
		System.out.println("Testclass3"+"Test9"+"-->"+Thread.currentThread().getId());
	}
	@Test
	public void Test10()
	{
		System.out.println("Testclass3"+"Test10"+"-->"+Thread.currentThread().getId());
	}
	@Test
	public void Test11()
	{
		System.out.println("Testclass3"+"Test11"+"-->"+Thread.currentThread().getId());
	}
	@Test
	public void Test12()
	{
		System.out.println("Testclass3"+"Test12"+"-->"+Thread.currentThread().getId());
	}
	}
