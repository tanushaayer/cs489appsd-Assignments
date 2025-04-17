package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.*;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.DentistService;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AdSdentalSurgeryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdSdentalSurgeryManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            DentistService dentistService,
            PatientService patientService
    ) {
        return args -> {
            // Shared Surgeries (prevent duplicate address insert)
            SurgeryRequestDto s10 = new SurgeryRequestDto(
                    "Surgery Room 10", "S10", "5550000010",
                    new AddressRequestDto("10A", "Main St", "Dallas", "TX", 75201)
            );

            SurgeryRequestDto s13 = new SurgeryRequestDto(
                    "Surgery Room 13", "S13", "5550000013",
                    new AddressRequestDto("13B", "Elm St", "Dallas", "TX", 75201)
            );

            SurgeryRequestDto s15 = new SurgeryRequestDto(
                    "Surgery Room 15", "S15", "5550000015",
                    new AddressRequestDto("15C", "Oak Ave", "Dallas", "TX", 75201)
            );

            // Dentists
            DentistRequestDto tonySmith = new DentistRequestDto(
                    "Tony", "Smith", "tony.smith@ads.com", "1111111111", "General Dentist",
                    List.of(
                            new AppointmentRequestDto("APT-001", LocalDate.of(2013, 9, 12), "Scheduled", s15),
                            new AppointmentRequestDto("APT-002", LocalDate.of(2013, 9, 12), "Scheduled", s15)
                    )
            );

            DentistRequestDto helenPearson = new DentistRequestDto(
                    "Helen", "Pearson", "helen.pearson@ads.com", "2222222222", "Endodontist",
                    List.of(
                            new AppointmentRequestDto("APT-003", LocalDate.of(2013, 9, 12), "Scheduled", s10),
                            new AppointmentRequestDto("APT-004", LocalDate.of(2013, 9, 14), "Scheduled", s10)
                    )
            );

            DentistRequestDto robinPlevin = new DentistRequestDto(
                    "Robin", "Plevin", "robin.plevin@ads.com", "3333333333", "Orthodontist",
                    List.of(
                            new AppointmentRequestDto("APT-005", LocalDate.of(2013, 9, 14), "Scheduled", s15),
                            new AppointmentRequestDto("APT-006", LocalDate.of(2013, 9, 15), "Scheduled", s13)
                    )
            );

            // Patients
            PatientRequestDto gillianWhite = new PatientRequestDto(
                    "Gillian", "White", "9990000001", "gillian.white@ads.com", LocalDate.of(1985, 1, 1),
                    new AddressRequestDto("1", "Pine St", "Dallas", "TX", 75201),
                    List.of(
                            new AppointmentRequestDto("APT-001", LocalDate.of(2013, 9, 12), "Scheduled", s15)
                    )
            );

            PatientRequestDto jillBell = new PatientRequestDto(
                    "Jill", "Bell", "9990000002", "jill.bell@ads.com", LocalDate.of(1988, 2, 15),
                    new AddressRequestDto("2", "Cedar Ave", "Dallas", "TX", 75201),
                    List.of(
                            new AppointmentRequestDto("APT-002", LocalDate.of(2013, 9, 12), "Scheduled", s15),
                            new AppointmentRequestDto("APT-005", LocalDate.of(2013, 9, 14), "Scheduled", s15)
                    )
            );

            PatientRequestDto ianMacKay = new PatientRequestDto(
                    "Ian", "MacKay", "9990000003", "ian.mackay@ads.com", LocalDate.of(1990, 3, 20),
                    new AddressRequestDto("3", "Birch Blvd", "Dallas", "TX", 75201),
                    List.of(
                            new AppointmentRequestDto("APT-003", LocalDate.of(2013, 9, 12), "Scheduled", s10),
                            new AppointmentRequestDto("APT-004", LocalDate.of(2013, 9, 14), "Scheduled", s10)
                    )
            );

            PatientRequestDto johnWalker = new PatientRequestDto(
                    "John", "Walker", "9990000004", "john.walker@ads.com", LocalDate.of(1992, 6, 5),
                    new AddressRequestDto("4", "Willow Rd", "Dallas", "TX", 75201),
                    List.of(
                            new AppointmentRequestDto("APT-006", LocalDate.of(2013, 9, 15), "Scheduled", s13)
                    )
            );

            // Save
            System.out.println("🦷 Creating Dentists...");
            System.out.println(dentistService.createDentist(tonySmith));
            System.out.println(dentistService.createDentist(helenPearson));
            System.out.println(dentistService.createDentist(robinPlevin));

            System.out.println("🧑‍⚕️ Creating Patients...");
            System.out.println(patientService.createPatient(gillianWhite));
            System.out.println(patientService.createPatient(jillBell));
            System.out.println(patientService.createPatient(ianMacKay));
            System.out.println(patientService.createPatient(johnWalker));
        };
    }


}


