package eu.dar3.streamapi;

import eu.dar3.streamapi.model.Specialist;
import eu.dar3.streamapi.model.Specialty;
import eu.dar3.streamapi.util.OldWayUtil;

import java.util.List;

public class StreamAPIStart {
    public static void main(String[] args) {

        List<Specialist> specialistsOld = OldWayUtil.getSpecialists();
        System.out.println("Old");
        System.out.println(specialistsOld);


        // Filter by specialties
        for (Specialty specialty: Specialty.values()
             ) {
        List<Specialist> filteredListBySpecialty = OldWayUtil.filterBySpecialty(specialistsOld, specialty);
        System.out.println("Old filter by specialties - " + specialty + ":");
        System.out.println(filteredListBySpecialty);
        }

        // Sorting


        // Max salary


        // Min salary


        // Grouping


        // Any specialist


        // No one with salary more then


    }
}
