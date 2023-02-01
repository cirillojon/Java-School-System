
// Coded by Jonathan Cirillo and Timothy Woodard 

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

abstract class Person{

private String Id;
private String fullName;

public Person(){}

public Person(String fullName, String Id) 
{
  
this.fullName = fullName;
this.Id = Id;

}

public String getFullName() 
{
return fullName;
}

public void setFullName(String fullName) 
{
this.fullName = fullName;
}

public String getId() 
{
return Id;
}

public void setId(String Id)
{
this.Id = Id;
}

abstract void printInfo();

}


class Student extends Person
 {
    private String fullName;
    private String       id;
    private double      gpa;
    private int creditHours;

  public Student(String fullName, String id, double gpa, int creditHours)
  {
                  this.fullName    =    fullName;
                  this.id          =          id;
                  this.gpa         =         gpa;
                  this.creditHours = creditHours;
        }

        public Student()
                {
                  fullName = null;
                     id =    null;
                    gpa =     0.0;
                 creditHours =  0;
                }

   public String getFullName()
  {
     return fullName;
     }

   public String getId()
  {
     return id;
     }

   public double getGpa()
  {
     return   gpa;
     }

        public int getCreditHours()
                {
                return  creditHours;
                }

    public void setFullName(String fullName)
  {
      this.fullName = fullName;
      }

    public void setId(String id)
  {
      this.id = id;
      }

    public void setGpa(double gpa)
  {
      this.gpa = gpa;
      }

        public void setCreditHours(int creditHours)
                {
                this.creditHours = creditHours;
                }

 public void printInfo()
  {
      double total;
      double discount = 0;
      System.out.println("Here is the tuition invoice for " + this.getFullName());
      System.out.println("---------------------------------------------------------------------------");
      System.out.println(this.getFullName() + "                    " + this.getId());
      System.out.println("Credit Hours:" + this.getCreditHours() + " ($236.45/credit hour)");
      System.out.println("Fees: $52");
      
  total = ((236.45 * this.creditHours)+ 52); 
 
  if(this.gpa >= 3.85)
{
discount = total * .25;
total = total - discount;
}
  
  System.out.printf("Total payment: $%6.2f            ($"+discount+" discount applied)\n", total);
  }

  }


class Faculty extends Person
 {
    private String  fullName;
    private String            id;
    private String      department;
    private String            rank;

  public Faculty(String fullName, String id, String department, String rank)
  {
                  this.fullName           =           fullName;
                  this.id                 =                 id;
                  this.department         =         department;
                  this.rank               =               rank;
                }

        public Faculty()
                {
                      fullName = null;
                         id =    null;
                   department  = null;
                          rank = null;
                }

   public String getFullName()
   {
     return fullName;
     }

   public String getId()
  {
     return id;
     }

   public String getDepartment()
  {
     return   department;
     }

        public String getRank()
                {
                return  rank;
                }

    public void setFullName(String fullName)
  {

      this.fullName = fullName;
      }

    public void setId(String id)
  {
      this.id = id;
      }

    public void setDepartment(String department)
  {

        this.department = department.toLowerCase();
      }

        public void setRank(String rank)
                {

                this.rank = rank;
                }



       public void printInfo()
                {
                System.out.print("\n\nPrinting Faculty Information\n");
                String facultyName;
                int facultyId;
                String department;
                String rank;

                System.out.printf("Name of faculty member: %s\n", this.getFullName());
                System.out.printf("ID: %s\n", this.getId());
                System.out.printf("Rank: %s\n", this.getRank());
                System.out.printf("Department: %s\n\n", this.getDepartment());
                }

    }


class IdException extends Exception {
  
  public IdException(String Message)
  {
   
    super(Message);
     
  }

}



class PersonnelSystem
 {

 public static void main( String args[] )
  {

  PersonnelSystem ps = new PersonnelSystem();
  
  ArrayList<Person> person = new ArrayList<>(100);
  
   
    Scanner sc = new Scanner(System.in);
    
    String     studentName;
    String     studentId;
    double      studentGpa;
    int studentCreditHours;
    int selection = 0;

   
   
   System.out.print("Welcome to the Personnel Management System\n\n");

   do
   {
   System.out.println("\n\nChoose one of the options:");
   System.out.print("1- Enter the information of the faculty\n");
   System.out.print("2- Enter the information of a student\n");
   System.out.print("3- Print tuition invoice\n");
   System.out.print("4- Print faculty information\n");
   System.out.print("5- Exit Program\n");
   System.out.print("Enter your selection: ");



    try {selection = sc.nextInt();} 
    catch (Exception e) 
   {System.out.println("Selection must be an integer\n");
   selection=0;

   }
  

  sc.nextLine();

   if(selection==1)
    {
      Faculty f  = new Faculty();
      System.out.print("Enter Faculty information\n");
      ps.setFacultyInfo(f, sc);
      person.add(f);
    }

   if(selection==2)
    {  
     Student s1 = new Student();         
     System.out.print("Enter student info\n");
     ps.setStudentInfo1(s1, sc);
     person.add(s1);
   }  
   
   if(selection==3)
  {

int num = 0;
boolean contained = false;
String id;
System.out.println("Enter the student's id:");
id = sc.next();
try{

 if( !id.matches("[a-zA-Z]{2}\\d{4}"))
    {
  
   throw new IdException("Sorry Invalid id format-It has to be LetterLetterDigitDigitDigitDigit");

    }
 

 else
{

for(int y=0; y< person.size(); y++)
{
  
  if(id.equalsIgnoreCase(person.get(y).getId()))
  {
    contained = true;
    num = y;
  }

}

if(contained)
{
  person.get(num).printInfo();
}

else 
{
  System.out.println("Sorry "+id+" doesn't exist \n");
}

}
 
}catch(IdException ex)
 {
  System.out.println(ex); 
 }

}
    
   
    
   if(selection==4)
     
    {

 int num = 0;
boolean contained = false;
String id;

System.out.println("Enter the faculty's id:");
id = sc.next();

try{

 if( !id.matches("[a-zA-Z]{2}\\d{4}"))
    {
        throw new IdException("Sorry Invalid id format-It has to be LetterLetterDigitDigitDigitDigit");
    }

 else
 {

for(int y=0; y< person.size(); y++)
{
  
if(id.equalsIgnoreCase(person.get(y).getId()))
{
contained = true;
num = y;
}

}

if(contained)
{
person.get(num).printInfo();
}
else 
{
System.out.println("Sorry "+id+" doesn't exist \n");
}

 }
 
}catch(IdException ex)
 {
  System.out.println(ex); 
 }
}
     

   if(selection==5){System.out.print("You entered 5, exiting.\n");}
   

   }
   while(selection!=5);

  }

    public void setFacultyInfo(Faculty f, Scanner sc)
  {

  String facultyName = "none";
  String facultyIdS  = "none";
  String facultyId  = "none";
  String department = "none";
  String rank       =" none";


    System.out.print("Name of faculty member: ");
    facultyName=sc.nextLine();

    System.out.print("ID: ");
    
    try{
    
    facultyId=sc.nextLine(); 
     if( !facultyId.matches("[a-zA-Z]{2}\\d{4}"))
    {
      throw new IdException("Sorry Invalid id format-It has to be LetterLetterDigitDigitDigitDigit");
    }
    else
    {
    
      
    do
  {
    System.out.print("Rank: ");
    rank=sc.nextLine();

  if( !rank.equalsIgnoreCase("adjunct") &&  !rank.equalsIgnoreCase("professor"))
  System.out.println("Sorry entered rank ("+rank+") is invalid");
  }
  while( !rank.equalsIgnoreCase("adjunct") &&  !rank.equalsIgnoreCase("professor"));
   

  do
  {
    System.out.print("Department: ");
    department=sc.nextLine();

  if(   !department.equalsIgnoreCase("mathematics") && 
        !department.equalsIgnoreCase("engineering") &&
        !department.equalsIgnoreCase("arts")        &&
        !department.equalsIgnoreCase("science"))
 System.out.println("Sorry entered Department ("+department+") is invalid");
  }
  while(
    !department.equalsIgnoreCase("mathematics") && 
    !department.equalsIgnoreCase("engineering") &&
    !department.equalsIgnoreCase("arts")        &&
    !department.equalsIgnoreCase("science"));


  System.out.print("Thanks!\n\n");


    f.setFullName(facultyName);
    f.setId(facultyId);
    f.setRank(rank);
    f.setDepartment(department);
    
   }
    
  }catch(IdException ex)
    {
      System.out.println(ex); 
    }
  }

    public void setStudentInfo1(Student s1,Scanner sc)
  {
  
  String studentName;
  String studentId;
  double studentGpa;
  int studentCreditHours;
    System.out.print("Name of Student:");
    studentName = sc.nextLine();
    s1.setFullName(studentName);

    System.out.print("ID: ");

    try{
    
    studentId=sc.nextLine();
    
    if( !studentId.matches("[a-zA-Z]{2}\\d{4}"))
    {
      throw new IdException("Sorry Invalid id format-It has to be LetterLetterDigitDigitDigitDigit");
    }
    
    else
    {
    s1.setId(studentId);

    System.out.print("Gpa: ");
    studentGpa=sc.nextDouble(); sc.nextLine();
    s1.setGpa(studentGpa);

    System.out.print("Credit hours: ");
    studentCreditHours=sc.nextInt();
  sc.nextLine();
    s1.setCreditHours(studentCreditHours);
  System.out.print("Thanks!\n\n");
    }

    
    }catch(IdException ex)
      
    {
      System.out.println(ex); 
    }
    
 }



}






