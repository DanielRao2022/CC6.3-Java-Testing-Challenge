package com.java;
import com.java.basic.challenge.teller.CC_4_1.test.TellerTest;
import com.java.code.challenge.tshirt.CC_5_1.test.TestsSuiteTShirt;
import com.java.data.structures.coding.challenge.CC_7_4.test.TestSuiteLibraryKeywordSearch;
import com.java.interfaces.code.challenge.bank.CC_6_1.test.TestsSuiteBank;
import com.java.object.oriented.java.challenge.automobile.CC_6_2.test.TestsSuiteAutomobile;
import com.java.stacks.queues.CC_7_2.test.EvenQueueOddStackTest;
import com.java.string.matching.algorithm.CC_7_3.test.TestsSuiteMatchingAlgorithm;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        TellerTest.class,
        TestsSuiteTShirt.class,
        TestsSuiteBank.class,
        TestsSuiteAutomobile.class,
        EvenQueueOddStackTest.class,
        TestSuiteLibraryKeywordSearch.class,
        TestsSuiteMatchingAlgorithm.class
})

public class MasterAllTestsSuite {

}
