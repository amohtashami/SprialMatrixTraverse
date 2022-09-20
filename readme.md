## Spiral Matrix Traverse
A java based application to solve the following problem.

### Problem
Given a 2D array, Traverse the array in the pattern below and print the numbers along the path.

![boxplot_img](file:./assets/spiral.png) 

so for input 
```java
{  
	{1,2,3,4},  
	{5,6,7,8},  
	{9,10,11,12},  
	{13,14,15,16}  
} 
```
must print: **1,2,3,4, 8,12,16, 15,14,13, 9,5, 6,7, 11,10**  

### Instruction to install
- clone this repository from git
- to run tests you can run command **mvn clean test**
- run command **mvn clean install** to create `jar` file
- add the dependency to your project


### Sample to use
```java
	ITraverseService<Integer> traverseService = ServiceFactory.getTraverseService(EnumServiceName.SPIRAL);
	Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5, 10},
				{3, 2, 7, 12},
				{1, 8, 9, 11}}
	);
	System.out.println(traverseService.traverse(matrix)); //it will print : [2, 4, 5, 10, 12, 11, 9, 8, 1, 3, 2, 7]
```