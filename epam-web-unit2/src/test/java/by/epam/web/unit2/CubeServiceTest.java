package test.java.by.epam.web.unit2;



import org.junit.Assert;
import org.junit.Test;

import main.java.by.epam.web.unit2.bean.Cube;
import main.java.by.epam.web.unit2.bean.Point;
import main.java.by.epam.web.unit2.service.impl.CubeServiceImpl;

public class CubeServiceTest {
	//можно ли данные делать одинаковые для всех, если это возможно?
	CubeServiceImpl cubeService = new CubeServiceImpl();
	Cube cube = new Cube(new Point(0,0,0),new Point(1,0,0),new Point(0,1,0),new Point(0,0,1) );
	
	@Test
	public void isCubeTest() {
			
		Assert.assertTrue(cubeService.isCube(cube));
	}
	@Test
	public void cubeSquareTest() {
		double result = cubeService.cubeSquare(cube);
		System.out.println(result);
		Assert.assertEquals(6.0, cubeService.cubeSquare(cube),0.1);
	}
	@Test
	public void cubeVolumeTest() {
		double result = cubeService.cubeVolume(cube);
		System.out.println(result);
		Assert.assertEquals(1.0, cubeService.cubeVolume(cube),0.1);
	}
	
	@Test
	public void isBaseOnPlot() {
		Assert.assertTrue(cubeService.isBaseOnPlot(cube));
	}
	
	@Test
	public void volumeRatioTest() {
		
	}
	
	
	
	

}
