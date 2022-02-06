package eu.dar3.streamapi.util;

import eu.dar3.streamapi.model.Specialist;
import eu.dar3.streamapi.model.Specialty;

import java.util.*;

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
        list.sort(Comparator.comparing(Specialist::getName));
        return list;
    }

    // Sorting Descending
    public static List<Specialist> sortDescending(List<Specialist> list) {
        list.sort((u1, u2) -> u2.getName().compareTo(u1.getName()));
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

    // Find specialist with min salary
    public static Specialist findSpecialistWithMinSalary(List<Specialist> list) throws IndexOutOfBoundsException {
        int min = list.get(0).getSalary();
        Specialist result = list.get(0);
        for (Specialist specialist: list
        ) {
            if (min > specialist.getSalary()) {
                min = specialist.getSalary();
                result = specialist;
            }
        }
        return result;
    }

    // Find specialist with max salary
    public static Specialist findSpecialistWithMaxSalary(List<Specialist> list) throws IndexOutOfBoundsException {
        int max = list.get(0).getSalary();
        Specialist result = list.get(0);
        for (Specialist specialist: list
        ) {
            if (max < specialist.getSalary()) {
                max = specialist.getSalary();
                result = specialist;
            }
        }
        return result;
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
    public static Map<Specialty, List<Specialist>> gropingBySpecialty(List<Specialist> list){
        Map<Specialty, List<Specialist>> result = new HashMap<>();
        for (Specialist x: list
             ) {
            result.putIfAbsent(x.getSpecialty(), filterBySpecialty(list, x.getSpecialty()));
        }
        return result;
    }

}
