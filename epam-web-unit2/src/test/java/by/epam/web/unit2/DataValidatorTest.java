package test.java.by.epam.web.unit2;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import main.java.by.epam.web.unit2.bean.Point;
import main.java.by.epam.web.unit2.validator.DataValidator;

public class DataValidatorTest {

	@Test
	public void makeValidDataTest() {
		DataValidator dataValid = new DataValidator();
		List<Point> lst = dataValid.makeValidData();
		Assert.assertNotNull(lst);
		
	}
	@Test
	public void makeValidDataTest2() {
		DataValidator dataValid = new DataValidator();
		List<Point> lst = dataValid.makeValidData();
		System.out.println(lst.size());
		Assert.assertEquals(3, lst.size());;
		
	}

}
