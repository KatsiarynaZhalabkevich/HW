package main.java.by.epam.web.unit2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.by.epam.web.unit2.bean.Cube;
import main.java.by.epam.web.unit2.bean.Point;
import main.java.by.epam.web.unit2.service.CubeService;
import main.java.by.epam.web.unit2.service.util.CubeUtil;

public class CubeServiceImpl implements CubeService {

	static final Logger logger = LogManager.getLogger();

	@Override
	public boolean isCube(Cube cube) {

		double sideAB = 0;
		double sideAC = 0; // почему нельзя прописать private
		double sideAD = 0;
		double sideBC = 0;
		double sideBD = 0;
		double sideCD = 0;

		sideAB = CubeUtil.solveSide(cube.getPointA(), cube.getPointB());
		sideAC = CubeUtil.solveSide(cube.getPointA(), cube.getPointC());
		sideAD = CubeUtil.solveSide(cube.getPointA(), cube.getPointD());

		if (sideAB == sideAC && sideAC == sideAD) {
			logger.info("The cube exists");
			return true;
		} else {
			sideBC = CubeUtil.solveSide(cube.getPointB(), cube.getPointC());
			sideBD = CubeUtil.solveSide(cube.getPointB(), cube.getPointD());
			if (sideBC == sideBD && sideBD == sideAB) {
				logger.info("The cube exists");
				return true;
			} else {
				sideCD = CubeUtil.solveSide(cube.getPointC(), cube.getPointD());
				if (sideCD == sideBC && sideBC == sideAC) {
					logger.info("The cube exists");
					return true;
				} else {
					if (sideCD == sideAD && sideAD == sideBD) {
						logger.info("The cube exists");
						return true;
					} else {
						logger.info("The cube doesn't exist");
						return false;
					}
				}
			}
		}

	}

	@Override
	public double cubeSquare(Cube cube) {

		double square = -1;

		if (isCube(cube)) {

			cube.setSide(CubeUtil.solveSide(cube.getPointA(), cube.getPointB()));
			square = 6 * Math.pow(cube.getSide(), 2);
		}
		return square;
	}

	@Override
	public double cubeVolume(Cube cube) {

		double volume = -1;
		if (isCube(cube)) {

			cube.setSide(CubeUtil.solveSide(cube.getPointA(), cube.getPointB()));
			volume = Math.pow(cube.getSide(), 3);
		}
		return volume;
	}

	@Override
	public boolean isBaseOnPlot(Cube cube) {
		// тк по условию куб ориентирован параллельно осям, то достаточно 1 точки с
		// координатой 0
		// достаточно ли ответа да/нет

		// тк изначально точки не закинули в лист, то закинем сейчас

		List<Point> list = new ArrayList<Point>();
		list.add(cube.getPointA());
		list.add(cube.getPointB());
		list.add(cube.getPointC());
		list.add(cube.getPointD());

		// проверка ZOY x=0

		for (Point point : list) {
			if (point.getX() == 0) {
				logger.info(" Base of the cube belongs to the plane ZOY");
				return true;
			}
		}

		for (Point point : list) {
			if (point.getY() == 0) {
				logger.info(" Base of the cube belongs to the plane ZOX");
				return true;
			}
		}

		for (Point point : list) {
			if (point.getZ() == 0) {
				logger.info(" Base of the cube belongs to the plane XOY");
				return true;
			}
		}

		logger.info("No bases of the cube belongs to the plane!");
		return false;
	}

	@Override
	public double volumeRatio(Cube cube) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cube> createCubes(List<Point> pointLst) {
		List <Cube> cubeLst = new ArrayList<>();
		for(int i=0;i<pointLst.size()-4;i+=4) {
			Cube cube = new Cube(pointLst.get(i),pointLst.get(i+1), pointLst.get(i+2),pointLst.get(i+3) );
			cubeLst.add(cube);
		}
		
		return cubeLst;
	}

}
