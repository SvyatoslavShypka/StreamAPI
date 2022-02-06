package eu.dar3.streamapi.util;

import eu.dar3.streamapi.model.Specialist;
import eu.dar3.streamapi.model.Specialty;

import java.util.ArrayList;
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


    // Check whether all have salary more than


    // Print


    // Group specialists by specialty


}
