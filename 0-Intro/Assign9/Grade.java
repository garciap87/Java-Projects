package Assign9;

public interface Grade 
{
	int toPercent();
	String nativeFormat();
	boolean isPass();
	boolean includeInAverage();
}