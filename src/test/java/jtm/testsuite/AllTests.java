package jtm.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import jtm.activity01.ConfigurationTest;
import jtm.activity02.ConfigAndHelloTest;
import jtm.activity03.ArrayTest;
import jtm.activity03.BlackKnightTest;
import jtm.activity03.RandomPersonTest;
import jtm.activity031.GitTest;
import jtm.activity04.TrafficManagementTest;
import jtm.activity05.EncapsulationTests;
import jtm.activity06.InterfaceTests;
import jtm.activity07.AnimalTests;
import jtm.activity08.SimpleCalcTests;
import jtm.activity09.OrdersTests;
import jtm.activity10.StreamEditorTest;
import jtm.activity11.TttCliTest;
import jtm.activity11.TttNetTest;
import jtm.activity12.ArrayFillerManagerTest;
import jtm.activity13.DatabaseTest;
import jtm.activity14.DatabaseUnitTest;
import jtm.activity15.WebTests;
import jtm.activity16.ColorSliderTests;
import jtm.activity18.GitMergeTest;
import jtm.extra01.GetOneTest;
import jtm.extra01.ZodiacTest;
import jtm.extra02.ArrayListMethodsTest;
import jtm.extra02.LetsRideTest;
import jtm.extra03.PracticalNumbersTest;
import jtm.extra04.XMLCarsTest;
import jtm.extra05.JsonCarsTest;
import jtm.extra06.GenericsTest;
import jtm.extra06.HolidayTest;
import jtm.extra06.RegExTest;
import jtm.extra08.InvoiceManagerTest;
import jtm.extra09.BoardTest;
import jtm.extra09.CrocodileTest;
import jtm.extra09.GameTest;
import jtm.extra10.LogTest;
import jtm.extra11.PersonMatcherTests;
import jtm.extra12.JNIClassTest;
import jtm.extra13.ChatServerTest;
import jtm.extra14.ChatClientTest;
import jtm.extra20.CodeWeightTest;

/**
 * 
 * Run all tests cases of the project and calculate total result
 *
 */
@RunWith(JtmSuite.class)
@SuiteClasses({

		// First week

		ConfigurationTest.class, // 1
		ConfigAndHelloTest.class, // 2
		ArrayTest.class, // 3
		BlackKnightTest.class, // 3
		RandomPersonTest.class, // 3
		GitTest.class, // 31
		TrafficManagementTest.class, // 4
		EncapsulationTests.class, // 5
		InterfaceTests.class, // 6
		AnimalTests.class, // 7
		SimpleCalcTests.class, // 8
		OrdersTests.class, // 9

		// Second week

		StreamEditorTest.class, // 10
		TttNetTest.class, // 11
		ArrayFillerManagerTest.class, // 12
		DatabaseTest.class, // 13
		DatabaseUnitTest.class, // 14
		WebTests.class, // 15
		ColorSliderTests.class, // 16
		// 17 — external project — Android application
		GitMergeTest.class, // 18

		// extra activities

		GetOneTest.class, // 1
		ZodiacTest.class, // 1
		ArrayListMethodsTest.class, // 2
		LetsRideTest.class, // 2
		PracticalNumbersTest.class, // 3
		XMLCarsTest.class, // 4
		JsonCarsTest.class, // 5
		GenericsTest.class, // 6
		HolidayTest.class, // 6
		RegExTest.class, // 6
		InvoiceManagerTest.class, // 8
		CrocodileTest.class, // 9
		GameTest.class, // 9
		LogTest.class, // 10
		PersonMatcherTests.class, // 11
		JNIClassTest.class, // 12
		ChatServerTest.class, // 13
		ChatClientTest.class, // 14
		CodeWeightTest.class // 20

})
public class AllTests {

}
