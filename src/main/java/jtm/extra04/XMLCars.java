
package jtm.extra04;

// TODO #1
// Import necessary classes from javax.xml.* and, if necessary, org.w3c.dom.*

public class XMLCars {

	/*- TODO #2
	 * Declare variables to remember previously generated structure of XML
	 */


	public void addCar(int id, String model, String color, int year, float price, String notes) throws Exception {
		// TODO #3
		/*- Implement method which adds new car elements into XML structure.
		 * Note, that:
		 *   1. if method is called 1st time, one root element "car" should be
		 *      created, but if method is called again, just new "car" element is added into
		 *      "cars" tree.
		 *   2. Car id should be padded with leading zeroes if id is smaller than 1111.
		 *      E.g. if int id=33, then  attribute of XML should be id="0033".
		 *   3. At the end of car element XML comment should be added with value of passed notes
		 *      (This is not checked by validator using XSD schema,
		 *      but is checked when generated XML is produced as string.)
		 *      
		 * Hint:
		 *   Look at https://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilder.html and
		 *           https://docs.oracle.com/javase/7/docs/api/org/w3c/dom/package-summary.html
		 */


	}

	public String getXML() throws Exception {
		/*- TODO No. 4: Write a code that will create String containing XML as that matches car.xsd requirements.
		 * 
		 * HINT look at:
		 * https://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilder.html
		 * 
		 * Note, that XML should be "prettied" with line breaks and 
		 * indentations of 2 spaces for internal elements
		 * 
		 * HINT: look at:
		 * https://docs.oracle.com/javase/7/docs/api/javax/xml/transform/Transformer.html
		 */
		return "";

	}

	/*-
	 * @param schemaSource — String containing XSD schema definition from car.xsd file
	 * @param xmlSource — String containing XML for car
	 * @return — true, if xmlSource is valid
	 * @throws Exception — if xmlSource is invalid
	 *         (will be thrown by javax.xml.validation.Validator automatically)
	 */
	public static boolean validateXMLSchema(String schemaSource, String xmlSource) throws Exception {
		/*- TODO No. 2: Write a code to validate prepared XML source according to schema source
		 * Note that Exception should be thrown, if passed XML file is invalid.
		 * HINT:
		 * Use https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/Validator.html
		 */
		return false;
	}

}
