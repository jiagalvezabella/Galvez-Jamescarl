import java.util.Scanner;

class Student 
{
    private int studentID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private int age;
    private int yearLevel;
    private String phoneNumber;
    private String email;

    public Student(){
   
   
    } 
   
    
    public Student(int studentID, String firstName, String middleName, String lastName, String suffix, int age, int yearLevel, String phoneNumber, String email) 
    {
        this.studentID = studentID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.age = age;
        this.yearLevel = yearLevel;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getStudentID() 
    {
        return studentID;
    }

    public void setStudentID(int studentID) 
    {
        this.studentID = studentID;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getMiddleName() 
    {
        return middleName;
    }

    public void setMiddleName(String middleName) 
    {
        this.middleName = middleName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getSuffix() 
    {
        return suffix;
    }

    public void setSuffix(String suffix) 
    {
        this.suffix = suffix;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public int getYearLevel() 
    {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) 
    {
        this.yearLevel = yearLevel;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public void displayStudentDetails() 
    {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + firstName + " " + middleName + " " + lastName + " " + suffix);
        System.out.println("Age: " + age);
        System.out.println("Year Level: " + yearLevel);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}

public class StudentPersonalRec 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        System.out.println("Student Record Management");
        while (true) 
        {
            System.out.println("Choose an option:");
            System.out.println("(F1) Create a Student Record");
            System.out.println("(F2) Update Student Record");
            System.out.println("(F3) Update Course");
            System.out.println("(F4) Display Student Details");
            System.out.println("(Exit) Exit");

            String option = scanner.nextLine();

            if (option.equals("F1")) 
            {
                
                System.out.print("Enter Student ID: ");
                student.setStudentID(scanner.nextInt());
                scanner.nextLine(); 
                
                System.out.print("Enter First Name: ");
                student.setFirstName(scanner.nextLine());
                
                System.out.print("Enter Middle Name: ");
                student.setMiddleName(scanner.nextLine());
                
                System.out.print("Enter Last Name: ");
                student.setLastName(scanner.nextLine());
                
                System.out.print("Enter Suffix: ");
                student.setSuffix(scanner.nextLine());
                
                System.out.print("Enter Age: ");
                student.setAge(scanner.nextInt());
                scanner.nextLine(); 
                
                System.out.print("Enter Year Level: ");
                student.setYearLevel(scanner.nextInt());
                scanner.nextLine(); 
                
                System.out.print("Enter Phone Number: ");
                student.setPhoneNumber(scanner.nextLine());
                
                System.out.print("Enter Email: ");
                student.setEmail(scanner.nextLine());

                System.out.println("Student record created successfully.");
            } 
            else if (option.equals("F2")) 
            {
                
                System.out.println("Updating student record...");
                
            } 
            else if (option.equals("F3")) 
            {
                
                System.out.println("Updating course information...");
                
            } 
            else if (option.equals("F4")) 
            {
                if (student.getStudentID() != 0) 
                {
                    student.displayStudentDetails();
                } 
                else 
                {
                    System.out.println("No student record found. Please create a student record first.");
                }
            } 
            else if (option.equals("Exit")) 
            {
                System.out.println("Exiting the application.");
                break;
            } 
            else 
            {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
