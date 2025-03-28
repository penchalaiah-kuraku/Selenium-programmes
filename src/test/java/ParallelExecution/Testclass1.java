package ParallelExecution;

import org.testng.annotations.Test;

public class Testclass1 {
@Test
public void Test1()
{
	System.out.println("Testclass1"+"Test1"+"-->"+Thread.currentThread().getId());
}
@Test
public void Test2()
{
	System.out.println("Testclass1"+"Test2"+"-->"+Thread.currentThread().getId());
}
@Test
public void Test3()
{
	System.out.println("Testclass1"+"Test3"+"-->"+Thread.currentThread().getId());
}
@Test
public void Test4()
{
	System.out.println("Testclass1"+"Test4"+"-->"+Thread.currentThread().getId());
}
}
