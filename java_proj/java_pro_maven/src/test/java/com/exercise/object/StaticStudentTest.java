package com.exercise.object;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaticStudentTest {
    @Test
    public void test_static(){
        StaticStudent st1 = new StaticStudent("lili",23);

        StaticStudent st2 = new StaticStudent("mimi",18);
        StaticStudent.room = "110";
        System.out.println(st1.room);
        System.out.println(st2.room);
        System.out.println("================");

        st1.room = "0010";

        System.out.println(st1.room);
        System.out.println(st2.room);
        System.out.println(StaticStudent.room);
    }



}