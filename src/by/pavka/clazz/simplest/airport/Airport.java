package by.pavka.clazz.simplest.airport;
/*
* Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString().
* Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль.

Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:

a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного

 */

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private Airline[] airlines;

    public Airport(Airline[] airlines) {
        this.airlines = airlines;
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public void setAirlines(Airline[] airlines) {
        this.airlines = airlines;
    }

    public static void main(String[] args) {
        Airline[] airlines = new Airline[] {
                new Airline("London", 222, "Boeing-747", new DepartureTime(12, 11), 2),
                new Airline("Kiev", 111, "MIG-29", new DepartureTime(04, 16), 3),
                new Airline("London", 444, "Ju-88", new DepartureTime(22, 10), 4),
                new Airline("Vitebsk", 8761, "TU-134", new DepartureTime(15, 00), 2),
        };
        Airport airport = new Airport(airlines);
        //airport.byDestination("Moscow");
        //airport.byDestination("London");
        //airport.byWeekDay(2);
        airport.byDayAndTime(2, new DepartureTime(11, 59));

    }

    public List<Airline> byDestination(String destination) {
        List<Airline> dest = new ArrayList<>();
        for(Airline a: airlines) {
            if(destination.equals(a.getDestination())) {
                dest.add(a);
            }
        }
        System.out.println(dest);
        return dest;
    }

    public List<Airline> byWeekDay(int day) {
        List<Airline> lines = new ArrayList<>();
        for(Airline a: airlines) {
            if(day == a.getWeekDay()) {
                lines.add(a);
            }
        }
        System.out.println(lines);
        return lines;
    }
    public List<Airline> byDayAndTime(int day, DepartureTime time) {
        List<Airline> times = new ArrayList<>();
        for(Airline a: airlines) {
            if(day == a.getWeekDay() && a.getTime().isLater(time)) {
                times.add(a);
            }
        }
        System.out.println(times);
        return times;
    }
}

