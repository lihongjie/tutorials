package com.github.lihongjie.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class DateTimeTest {

    public static void main(String[] args) {

        LocalDate date1 = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate date2 = LocalDate.of(2017, Month.JUNE, 1);
        Period p = Period.between(date1, date2);
        System.out.print(p.getYears() + ":" + p.getMonths() + ":" + p.getDays());

    }
}
