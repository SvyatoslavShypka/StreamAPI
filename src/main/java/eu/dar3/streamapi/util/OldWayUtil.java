package eu.dar3.streamapi.util;

import eu.dar3.streamapi.model.Specialist;
import eu.dar3.streamapi.model.Specialty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OldWayUtil {

    // Get initial specialist list
    public static List<Specialist> getSpecialists() {
        List<Specialist> list = new ArrayList<>();
        list.add(new Specialist("Petro Petrenko", 8000, Specialty.DEVOPS));
        list.add(new Specialist("Igor Igorenko", 80000, Specialty.DIRECTOR));
        list.add(new Specialist("Taras Tarasenko", 15000, Specialty.ENGINEER));
        list.add(new Specialist("Ivan Ivanenko", 10000, Specialty.ENGINEER));
        list.add(new Specialist("Vasyl Vasylenko", 10000, Specialty.DEVOPS));
        list.add(new Specialist("Stepan Stepanenko", 9000, Specialty.DEVOPS));

        return list;
    }

    // Filter by speciality
    public static List<Specialist> filterBySpecialty(List<Specialist> list, Specialty specialty) {
        List<Specialist> result = new ArrayList<>();
        for (Specialist specialist: list
             ) {
            if (specialist.getSpecialty().equals(specialty)) {
                result.add(specialist);
            }
        }
        return result;
    }

    // Checking whether all fields match
    public static boolean allFieldsMatchSpecialty(List<Specialist> list, Specialty specialty) {
        for (Specialist specialist: list
             ) {
            if (!specialist.getSpecialty().equals(specialty)) {
                return false;
            }
        }
        return true;
    }

    // Check is there any Speciality
    public static boolean isThereAnySpecialty(List<Specialist> list, Specialty specialty) {
        for (Specialist specialist: list
             ) {
            if (specialist.getSpecialty().equals(specialty)) {
                return true;
            }
        }
        return false;
    }

    // Sorting Ascending
    public static List<Specialist> sortAscending(List<Specialist> list) {
        Collections.sort(list, new Comparator<Specialist>() {
            @Override
            public int compare(Specialist u1, Specialist u2) {
                return u1.getName().compareTo(u2.getName());
            }
        });
        return list;
    }

    // Sorting Descending
    public static List<Specialist> sortDescending(List<Specialist> list) {
        Collections.sort(list, new Comparator<Specialist>() {
            @Override
            public int compare(Specialist u1, Specialist u2) {
                return u2.getName().compareTo(u1.getName());
            }
        });
        return list;
    }

    // Min salary
    public static int minSalary(List<Specialist> list) throws IndexOutOfBoundsException {
        int min = list.get(0).getSalary();
        for (Specialist specialist: list
             ) {
            min = min > specialist.getSalary() ? specialist.getSalary() : min;
        }
        return min;
    }

    // Max salary
    public static int maxSalary(List<Specialist> list) throws IndexOutOfBoundsException {
        int max = list.get(0).getSalary();
        for (Specialist specialist: list
             ) {
            max = max < specialist.getSalary() ? specialist.getSalary() : max;
        }
        return max;
    }

    // Check whether all have salary more than
    public static boolean areAllHaveSalaryMoreThan(List<Specialist> list, int salary) throws IndexOutOfBoundsException {
        for (Specialist specialist: list
             ) {
            if (specialist.getSalary() <= salary) {
                return false;
            }
        }
        return true;
    }

    // No one with salary more than
    public static boolean isNoOneWithSalaryMoreThan(List<Specialist> list, int salary) throws IndexOutOfBoundsException {
        for (Specialist specialist: list
             ) {
            if (specialist.getSalary() > salary) {
                return false;
            }
        }
        return true;
    }


    // Print
    public static void printSpecialists(List<Specialist> list) {
        list.forEach(System.out::println);
    }


    // Group specialists by specialty


}
