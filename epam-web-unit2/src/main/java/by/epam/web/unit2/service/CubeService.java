package main.java.by.epam.web.unit2.service;

import java.util.List;

import main.java.by.epam.web.unit2.bean.Cube;
import main.java.by.epam.web.unit2.bean.Point;

public interface CubeService {

	List<Cube> createCubes(List<Point> pointLst);

	boolean isCube(Cube cube);

	double cubeSquare(Cube cube);

	double cubeVolume(Cube cube);

	boolean isBaseOnPlot(Cube cube);

	double volumeRatio(Cube cube);

}
