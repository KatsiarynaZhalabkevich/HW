package main.java.by.epam.web.unit2.validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.by.epam.web.unit2.bean.Point;

public class DataValidator {
	private static final String CUBE_SOURCE = "src\\main\\java\\by\\epam\\web\\unit2\\resourses\\data.txt";
	static final Logger logger = LogManager.getLogger();

	public List<Point> makeValidData() {

		List<String> dataList = new ArrayList<>();
		List<Point> pointList = new ArrayList<>();

		try {
			dataList = Files.readAllLines(Paths.get(CUBE_SOURCE));
		} catch (IOException e) {
			logger.info("Can't find file!!!"); // как это работает
		}

		for (String s : dataList) {
			String[] str = s.split(";"); //разбили на 4 точки строку 1-ого куба
			if (str.length == 4) {
				for (int i = 0; i < str.length; i+=3) {
					String[] num = str[i].split(" "); //каждую точку на 3 координаты
					if (num.length == 3) {
						try { //пытаемся создать точку по 3-ем координатам и записать ее в лист
							Point point = new Point(Integer.getInteger(num[0]), Integer.getInteger(num[1]),
									Integer.getInteger(num[2]));
							pointList.add(point);

						} catch (Exception e) {
							logger.info("Cannot create point");
						}
					}
				}
			}
		}
		
		return pointList;  //список точек (они не перемешаются в процессе???)

	}
}
