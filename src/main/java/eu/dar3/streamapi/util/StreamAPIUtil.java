package eu.dar3.streamapi.util;

import eu.dar3.streamapi.model.Specialist;
import eu.dar3.streamapi.model.Specialty;

import java.util.*;

public class StreamAPIUtil {
    // Get initial specialist list
    public static List<Specialist> getSpecialists() {
        return List.of(
                new Specialist("Petro Petrenko", 8000, Specialty.DEVOPS),
                new Specialist("Igor Igorenko", 80000, Specialty.DIRECTOR),
                new Specialist("Taras Tarasenko", 15000, Specialty.ENGINEER),
                new Specialist("Ivan Ivanenko", 10000, Specialty.ENGINEER),
                new Specialist("Vasyl Vasylenko", 10000, Specialty.DEVOPS),
                new Specialist("Stepan Stepanenko", 9000, Specialty.DEVOPS));
    }

    // Filter by speciality
    public static List<Specialist> filterBySpecialty(List<Specialist> list, Specialty specialty) {
        return list.stream()
                .filter(specialist -> specialist.getSpecialty().equals(specialty))
                .toList();
    }

    // Checking whether all fields match
    public static boolean allFieldsMatchSpecialty(List<Specialist> list, Specialty specialty) {
        return list.stream()
                .allMatch(specialist -> specialist.getSpecialty().equals(specialty));
    }

    // Check is there any Speciality
    public static boolean isThereAnySpecialty(List<Specialist> list, Specialty specialty) {
        return list.stream()
                .anyMatch(specialist -> specialist.getSpecialty().equals(specialty));
    }

    // Sorting Ascending
    public static List<Specialist> sortAscending(List<Specialist> list) {
        return list.stream()
                .sorted(Comparator.comparing(Specialist::getName))
                .toList();
    }

    // Sorting Descending
    public static List<Specialist> sortDescending(List<Specialist> list) {
        return list.stream()
                .sorted(Comparator.comparing(Specialist::getName).reversed())
                .toList();
    }

    // Min salary level
    public static int minSalary(List<Specialist> list) throws NullPointerException{
        int min = list.stream()
                .min(Comparator.comparing(Specialist::getSalary)).orElse(null).getSalary();
        return min;
    }

    // Max salary level
    public static int maxSalary(List<Specialist> list) throws NullPointerException{
        int max = list.stream()
                .max(Comparator.comparing(Specialist::getSalary)).orElse(null).getSalary();
        return max;
    }

    // Find specialist with min salary
    public static Specialist findSpecialistWithMinSalary(List<Specialist> list) {
        return list.stream()
                .min(Comparator.comparing(Specialist::getSalary)).orElse(null);
    }

    // Find specialist with max salary
    public static Specialist findSpecialistWithMaxSalary(List<Specialist> list) {
        return list.stream()
                .max(Comparator.comparing(Specialist::getSalary)).orElse(null);
    }


    // Check whether all have salary more than
    public static boolean areAllHaveSalaryMoreThan(List<Specialist> list, int salary) {
        return list.stream()
                .allMatch(specialist -> specialist.getSalary() > salary);
    }

    // No one with salary more than
    public static boolean isNoOneWithSalaryMoreThan(List<Specialist> list, int salary) throws IndexOutOfBoundsException {
        return !list.stream()
                .anyMatch(specialist -> specialist.getSalary() > salary);
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
