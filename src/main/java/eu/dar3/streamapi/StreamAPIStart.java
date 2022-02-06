package eu.dar3.streamapi;

import eu.dar3.streamapi.model.Specialist;
import eu.dar3.streamapi.model.Specialty;
import eu.dar3.streamapi.util.OldWayUtil;
import eu.dar3.streamapi.util.StreamAPIUtil;

import java.util.List;

public class StreamAPIStart {
    public static void main(String[] args) {

        List<Specialist> specialistsOld = OldWayUtil.getSpecialists();
        System.out.println("Old: Get whole list");
        OldWayUtil.printSpecialists(specialistsOld);

        List<Specialist> specialistsStream = StreamAPIUtil.getSpecialists();
        System.out.println("Stream: Get whole list");
        StreamAPIUtil.printSpecialists(specialistsStream);

        // Filter by specialties
        for (Specialty specialty: Specialty.values()
             ) {
        List<Specialist> filteredListBySpecialty = OldWayUtil.filterBySpecialty(specialistsOld, specialty);
        System.out.println("Old: Filter by specialties - " + specialty + ":");
            OldWayUtil.printSpecialists(filteredListBySpecialty);
        }

        // Checking whether all fields match
        for (Specialty specialty: Specialty.values()
             ) {
        boolean allFieldsMatch = OldWayUtil.allFieldsMatchSpecialty(specialistsOld, specialty);
        System.out.println("Old: All fields match to " + specialty + "? " + allFieldsMatch);
        }

        // Check is there any Speciality
        for (Specialty specialty: Specialty.values()
             ) {
        boolean isAny = OldWayUtil.isThereAnySpecialty(specialistsOld, specialty);
        System.out.println("Old: Is there any " + specialty + "? " + isAny);
        }


        // Sorting
        System.out.println("Ascending");
        OldWayUtil.printSpecialists(OldWayUtil.sortAscending(specialistsOld));

        System.out.println("Descending");
        OldWayUtil.printSpecialists(OldWayUtil.sortDescending(specialistsOld));



        // Max salary
//        List<Specialist> emptyList = OldWayUtil.filterBySpecialty(specialistsOld, Specialty.MANAGER);
        try {
            System.out.println("Min salary: " + OldWayUtil.minSalary(specialistsOld));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is empty list");
        }


        // Min salary
        try {
            System.out.println("Max salary: " + OldWayUtil.maxSalary(specialistsOld));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is empty list");
        }

        // Check whether all have salary more than
        int salaryLimit = 10000;
        try {
            System.out.println("Are all have salary more than " + salaryLimit + "? " + OldWayUtil.areAllHaveSalaryMoreThan(specialistsOld, salaryLimit));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is empty list");
        }

        // No one with salary more than
        int maxSalaryLimit = 90000;
        try {
            System.out.println("Is no one with salary more than " + maxSalaryLimit + "? " + OldWayUtil.isNoOneWithSalaryMoreThan(specialistsOld, maxSalaryLimit));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is empty list");
        }

        // Grouping
        System.out.println(OldWayUtil.gropingBySpecialty(specialistsOld));

    }
}
