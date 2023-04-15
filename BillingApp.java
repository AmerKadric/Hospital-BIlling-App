import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char choice = 'y';
        String s = "empty";
      while(choice =='y') {
          // Ask user for patient id and name
          System.out.print("Enter patient's ID: ");
          int id = input.nextInt();
          System.out.print("Enter patient's first name: ");
          String FirstName = input.next();
          System.out.print("Enter patient's last name: ");
          String LastName = input.next();

          System.out.println();

          // Ask user for doctor name and specialty
          System.out.print("Enter doctor's first name: ");
          String DocFirstName = input.next();
          System.out.print("Enter doctor's last name: ");
          String DocLastName = input.next();
          System.out.print("Enter doctor's specialty: ");
          String specialty = input.next();
          System.out.println();

          // Ask user for date admitted
          System.out.print("Enter Admit Question2.Date (day/month/year): ");
          String AdDate = input.next();
          String[] helper = new String[3];
          helper = AdDate.split("/");
          int AdDateMonth = Integer.parseInt(helper[0]);
          int AdDateDay = Integer.parseInt(helper[1]);
          int AdDateYear = Integer.parseInt(helper[2]);

          //Ask user for date discharged
          System.out.print("Enter Discharged Question2.Date (day/month/year): ");
          String DisDate = input.next();
          String[] helper1 = new String[3];
          helper1 = DisDate.split("/");
          int DisDateMonth = Integer.parseInt(helper1[0]);
          int DisDateDay = Integer.parseInt(helper1[1]);
          int DisDateYear = Integer.parseInt(helper1[2]);

          // ask user for pharmacy charges
          System.out.print("Enter pharmacy Charges, room Rent, and doctor Fee: ");
          double PharmCharge = input.nextDouble();
          double Rent = input.nextDouble();
          double Docfee = input.nextDouble();
          System.out.println();

          // create doctor object
          Doctor doctor = new Doctor(DocFirstName, DocLastName, specialty);

          // Create a patient object
          Patient patient = new Patient(FirstName, LastName, id, new Date(1, 1, 1111), doctor, new Date(AdDateMonth, AdDateDay ,AdDateYear), new Date(DisDateMonth, DisDateDay, DisDateYear));

          // Create bill object
          Bill bill = new Bill(patient.GetPatient_ID(), PharmCharge, Docfee, Rent);

          // print the data to console
          System.out.println(patient);
          System.out.println();
          System.out.println("\n" + bill);

          try {
              PrintWriter fw = new PrintWriter(patient.getFirstName() + patient.getLastName() + ".txt");
              fw.write(patient.toString() + "\n");
              fw.write("\n" + bill);
              fw.close();
          } catch (FileNotFoundException e) {
              System.out.println("Exception Thrown");
          }
          System.out.println("Do you want to continue? Enter 'y' for yes, 'n' for no: ");
          s = input.next();
          choice = s.charAt(0);

      }

    }

    static class Person {
        // DATA MEMBERS
        private String firstName;
        private String lastName;

        // CONSTRUCTOR
        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        Person() {
            firstName = "No first name";
            lastName = "No last name";
        }

        // SETTERS
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        // GETTERS
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        //toString Operator
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    static class Patient extends Person {
        private int Patient_ID;
        private Date DateOfBirth;
        private Doctor Physician;
        private Date PatientAdmitted;
        private Date PatientDischarged;

        //Constructors
        Patient(String firstName, String lastName, int Patient_ID, Date DateofBirth, Doctor Physician, Date PatientAdmitted, Date PatientDischarged) {
            setFirstName(firstName);
            setLastName(lastName);
            this.Patient_ID = Patient_ID;
            this.DateOfBirth = DateofBirth;
            this.Physician = Physician;
            this.PatientAdmitted = PatientAdmitted;
            this.PatientDischarged = PatientDischarged;
        }


        //Setters
        public void SetPatient_ID(int Patient_ID) {
            this.Patient_ID = Patient_ID;
        }

        public void SetDateOfBirth(Date dob) {
            DateOfBirth = dob;
        }

        public void SetDoctor(Doctor Physician) {
            this.Physician = Physician;
        }

        public void PatientAdmitted(Date pa) {
            DateOfBirth = pa;
        }

        public void PatientDischarged(Date ps) {
            PatientDischarged = ps;
        }
    //Getters

        public int GetPatient_ID() {
            return Patient_ID;
        }

        public Date GetDateOfBirth() {
            return DateOfBirth;
        }

        public Doctor GetDoctor() {
            return Physician;
        }

        public Date GetPatientAdmitted() {
            return PatientAdmitted;
        }

        public Date GetPatientDisCharged() {
            return PatientDischarged;
        }

        //ToString
        @Override
        public String toString() {
            return "Question2.Patient: " + super.toString() +
                    "\nID: " + Patient_ID +
                    "\n" + Physician.toString() +
                    "\nAdmit Question2.Date: " + PatientAdmitted +
                    "\nDischarge Question2.Date: " + PatientDischarged;
        }


    }

    static class Doctor extends Person {
        private String specialty;

        //Constructor
        Doctor(String firstName, String lastName, String specialty) {
            super(firstName, lastName);
            this.specialty = specialty;
        }

        Doctor() {
            super("No first name", "No last name");
            specialty = "No specialty";
        }

        //Setter
        public void SetSpecialty(String specialty) {
            this.specialty = specialty;
        }

        //Getter
        public String GetSpecialty() {
            return specialty;
        }

        //ToString
        @Override
        public String toString() {
            return "Attending Physician: " + super.toString() +
                    " " + specialty;
        }
    }

    static class Date {

        private int Month;
        private int Day;
        private int Year;
        private String Date;

        //Constructor
        Date(int Month, int Day, int Year) {
            this.Month = Month;
            this.Day = Day;
            this.Year = Year;
            SetDate();
        }

        Date() {
            Month = 0;
            Day = 0;
            Year = 0;
            SetDate();
        }

        //Setter
        public void SetMonth(int Month) {
            this.Month = Month;
        }

        public void SetDay(int Day) {
            this.Day = Day;
        }

        public void SetYear(int Year) {
            this.Year = Year;
        }

        public void SetDate() {
            Date = Month + "/" + Day + "/" + Year;
        }

        //Getter
        public int GetMonth() {
            return Month;
        }

        public int GetDay() {
            return Day;
        }

        public int GetYear() {
            return Year;
        }

        public String GetDate() {
            return Date;
        }

        //ToString
        @Override
        public String toString() {
            return Date;
        }
    }

    static class Bill {
        private int Patient_ID;
        private double Medicine;
        private double DoctorFee;
        private double RoomCharge;
        private double TotalCharge;

        //Constructor
        Bill(int Patient_ID, double Medicine, double DoctorFee, double RoomCharge) {
            this.Patient_ID = Patient_ID;
            this.Medicine = Medicine;
            this.DoctorFee = DoctorFee;
            this.RoomCharge = RoomCharge;
            TotalCharge = Medicine + DoctorFee + RoomCharge;
        }

        Bill() {
            Patient_ID = 0;
            Medicine = 0;
            DoctorFee = 0;
            RoomCharge = 0;
        }

        //Setters
        public void SetPatient_ID(int Patient_ID) {
            this.Patient_ID = Patient_ID;
        }

        public void SetMedicine(double Medicine) {
            this.Medicine = Medicine;
        }

        public void SetDoctorFee(double DoctorFee) {
            this.DoctorFee = DoctorFee;
        }

        public void SetRoomCharge(double RoomCharge) {
            this.RoomCharge = RoomCharge;
        }

        //Getters
        public int GetPatient_ID() {
            return Patient_ID;
        }

        public double GetMedicine() {
            return Medicine;
        }

        public double GetDoctorFee() {
            return DoctorFee;
        }

        public double GetRoomCharge() {
            return RoomCharge;
        }

        //ToString
        @Override
        public String toString() {
            return "Pharmacy Charges: $" + Medicine +
                    "\nRoom Charges: $" + RoomCharge +
                    "\nQuestion2.Doctor's Fees: $" + DoctorFee +
                    "\n____________________________" +
                    "\nTotal Charges: $" + TotalCharge;
        }
    }
}
