package com.testng;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class RunTestNG {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add(System.getProperty("user.dir")+"/testng.xml");
        testNG.setTestSuites(suites);
        testNG.run();

    }
}
