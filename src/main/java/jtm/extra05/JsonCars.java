package jtm.extra05;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


public class JsonCars {

	/*- TODO #1
	 * Implement method, which returns list of cars from generated JSON string
	 */
	public List<Car> getCars(String jsonString) {
		/*- HINTS:
		 * You will need to use:
		 * - https://stleary.github.io/JSON-java/org/json/JSONObject.html
		 * - https://stleary.github.io/JSON-java/org/json/JSONArray.html
		 * You will need to initialize JSON array from "cars" key in JSON string
		 */

		return null;
	}

	/*- TODO #2
	 * Implement method, which returns JSON String generated from list of cars
	 */
	public String getJson(List<Car> cars) {
		/*- HINTS:
		 * You will need to use:
		 * - https://docs.oracle.com/javase/8/docs/api/index.html?java/io/StringWriter.html
		 * - http://static.javadoc.io/org.json/json/20180130/index.html?org/json/JSONWriter.html
		 * (You could use JSONArray, but tests require entries in specific order, which you
		 * can manage with JSONWriter.) 
		 * Remember to add "car" key as a single container for array of car objects in it.
		 */
		return null;
	}

}