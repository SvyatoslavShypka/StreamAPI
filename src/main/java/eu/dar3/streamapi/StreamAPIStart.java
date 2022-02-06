package eu.dar3.streamapi;

import eu.dar3.streamapi.model.Specialist;
import eu.dar3.streamapi.model.Specialty;
import eu.dar3.streamapi.util.OldWayUtil;

import java.util.List;

public class StreamAPIStart {
    public static void main(String[] args) {

        List<Specialist> specialistsOld = OldWayUtil.getSpecialists();
        System.out.println("Old: Get whole list");
        System.out.println(specialistsOld);


        // Filter by specialties
        for (Specialty specialty: Specialty.values()
             ) {
        List<Specialist> filteredListBySpecialty = OldWayUtil.filterBySpecialty(specialistsOld, specialty);
        System.out.println("Old: Filter by specialties - " + specialty + ":");
        System.out.println(filteredListBySpecialty);
        }

        // Checking whether all fields match
        for (Specialty specialty: Specialty.values()
             ) {
        boolean allFieldsMatch = OldWayUtil.allFieldsMatchSpecialty(specialistsOld, specialty);
        System.out.println("Old: All fields match to " + specialty + "?");
        System.out.println(allFieldsMatch);
        }

        // Check is there any Speciality
        for (Specialty specialty: Specialty.values()
             ) {
        boolean isAny = OldWayUtil.isThereAnySpecialty(specialistsOld, specialty);
        System.out.println("Old: Is there any " + specialty + "?");
        System.out.println(isAny);
        }



        // Sorting


        // Max salary


        // Min salary


        // Grouping




        // No one with salary more then


    }
}
