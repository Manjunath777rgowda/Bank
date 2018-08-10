import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

@Entity
@Table(name="UserDetails")

public class Details {
    @Id
    @Column(name="accountNumber")
    private String accountNumber;

    @Column(name="status")
    private int status;

    @Column(name="name")
    private String accountName;

    @Column(name="DOB")
    private Date dob;

    @Column(name="adress")
    private String address;

    @Column(name="adharNumber")
    private long adharNumber;

    @Column(name="PANnumber")
    private String panNumber;

    @Column(name="contactNumber")
    private int phoneNumber;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String emailId;

    @Column(name="balance")
    float initialamount;

    ///////////////////////////////////

    private  String nominee;

    private  String rel;

    ///////////////////////////////////


    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setInitialamount(float initialamount) {
        this.initialamount = initialamount;
    }

    public float getInitialamount() {
        return initialamount;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdharNumber(long adharNumber) {
        this.adharNumber = adharNumber;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDob() {
        return dob;
    }

    public long getAdharNumber() {
        return adharNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAddress() {
        return address;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }


    public String getInputDetails()
    {
        Validation v=new Validation();
        Scanner sc=new Scanner(System.in);
        String temp;
        boolean flag=false;
        String accType="";
        String numberAsString;
        Details sd=new Details();


        Random rand=new Random();
        int number = rand.nextInt(999)+1000 ;
        float limit=0;
        int choice=0;
        do{
            System.out.println("enter account type:( 1-Savings 2-Current 3-Recurring 4-Fixed)");

            temp=sc.next();
            flag=v.typeValidation(temp);
            if(flag){
                accType=temp;
                choice=Integer.parseInt(temp);
            }

            else System.out.println("enter valid account type");

            if(accType.equals("1")){
                numberAsString = String.valueOf(number);
                numberAsString="10SB"+numberAsString;
                sd.setAccountNumber(numberAsString);
            }
            else if(accType.equals("2")){
                numberAsString = String.valueOf(number);
                numberAsString="10CA"+numberAsString;
                sd.setAccountNumber(numberAsString);
                limit=1000;
            }

            else if(accType.equals("3")){
                numberAsString = String.valueOf(number);
                numberAsString="10RD"+numberAsString;
                sd.setAccountNumber(numberAsString);
            }
            else if(accType.equals("4")){
                numberAsString = String.valueOf(number);
                numberAsString="10FD"+numberAsString;
                sd.setAccountNumber(numberAsString);
            }


        }while(!flag);
/*
        do {
            System.out.println("Enter Account Name");
            temp = sc.next();
            flag=v.nameValidation(temp);
            if (flag)
            {
                sd.setAccountName(temp);
            }
            else System.out.println("Enter valid Name");
        }while (!flag);


        do {
            System.out.println("Enter pan number");
            temp = sc.next();
            flag=v.panValidation(temp);
            if (flag)
            {
               sd.setPanNumber(temp);
            }
            else System.out.println("Enter valid pan number");
        }while (!flag);

        do {
            System.out.println("Enter email id");
            temp = sc.next();
            flag=v.emailValidation(temp);
            if (flag)
            {
                sd.setEmailId(temp);
            }
            else System.out.println("Enter valid email");
        }while (!flag);


        do {
            System.out.println("Enter date of birth (yyyy-mm-dd)");
            temp = sc.next();
            flag=v.dateValidation(temp);
            if (flag)
            {
                try
                {
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
                    Date date=format.parse(temp);
                    sd.setDob(date);

                }
                catch(Exception e){
                    System.out.println("Invalid date");
                }
            }
            else System.out.println("Invalid date");
        }while (!flag);

        System.out.println("Enter Address");
        temp=sc.next();
        sd.setAddress(temp);

        do {
            System.out.println("Enter Phone Number");
            temp = sc.next();
            flag=v.PhoneNumberValidation(temp);
            if (flag)
            {
                sd.setPhoneNumber(Integer.parseInt(temp));
            }
        }while (!flag);


        do {
            System.out.println("Enter Adhar Number");
            temp = sc.next();
            flag=v.AdharNumberValidation(temp);
            if (flag)
            {
                sd.setAdharNumber(Long.parseLong(temp));
            }
        }while (!flag);
*/
        do {
            System.out.println("Create your Password");
            temp = sc.next();

            System.out.println("Re-Enter your Password");
            String temp1 = sc.next();

            if (temp.equals(temp1)) {
                System.out.println("Password created Successfully");
                sd.setPassword(temp);
                flag = true;
            }
            else
            {
                System.out.println("Password not Matched");
                flag = false;
            }

        }while(!flag);


        if (choice==1 || choice==2) {
            while (flag) {
                System.out.println("Enter Initial Amount");
                String str = sc.next();
                sd.setInitialamount(v.choiceValidation(str));
                if (sd.getInitialamount() > 0 && sd.getInitialamount() >= limit) {
                    flag = false;
                } else System.out.println("Please enter Initial Balance");
            }
        }

        //////////////////////////////////////////////////////

        if(choice==1) {
            Scanner input = new Scanner(System.in);
            String n;
            String r;
            do {
                System.out.println("Who is your nominee?");
                n = input.next();
            } while (!v.nameValidation(n));
           // System.out.println("Nominee            : "+n);
            setNominee(n);
            do {
                System.out.println("What is the relationship with the nominee?");
                r = input.next();
            } while (!v.nameValidation(r));
            setRel(r);
        }
      //  System.out.println("Nominee            : "+sd.getNominee());
        //////////////////////////////////////////////////////////




        if (setInputDetails(sd))
        {
            connectJDBC con=new connectJDBC();
            sd.setStatus(1);
            if (con.insert(sd)) {
                Transaction t=new Transaction();
                LocalDate depositeDate=java.time.LocalDate.now();
                t.updateTransaction(sd.getInitialamount(),depositeDate,"Deposite",sd.getAccountNumber(),sd.getInitialamount());
                return sd.getAccountNumber();
            }
            else
                return null;
        }

        return null;
    }

    public boolean setInputDetails( Details sd) {

        Scanner sc=new Scanner(System.in);
        String str;
        int choice;
        boolean flag=true;

        System.out.println("-----------------------------------Verify your details------------------------------");
        System.out.println("Account Number      : "+sd.getAccountNumber());
        System.out.println("Account Name        : "+sd.getAccountName());
        System.out.println("Pan number          : "+sd.getPanNumber());
        System.out.println("Email id            : "+sd.getEmailId());
        System.out.println("Adress              : "+sd.getAddress());
        System.out.println("Date Of Birth       : "+sd.getDob());
        System.out.println("Phone Number        : "+sd.getPhoneNumber());
        System.out.println("Adhar Number        : "+sd.getAdharNumber());
//////////////////////////////////////////////////////////
        String accountnum = sd.getAccountNumber();
        String match = accountnum.substring(2, 4);
       // System.out.println("Nominee            : "+sd.getNominee());
        if (match == "SB")
            System.out.println("Nominee            : "+sd.getNominee());
        /////////////////////////////////////////////////////
        System.out.println("Initial Amount      : "+sd.getInitialamount());
        System.out.println("------------------------------------------------------------------------------------");
        while (flag)
        {
            System.out.println("Please Enter your Choice");
            System.out.println("1-Done 2-Cancel");
            str=sc.next();
            Validation v=new Validation();
            choice=v.choiceValidation(str);
            switch (choice)
            {
                case 1:
                    return true;
                case 2:return false;
                default:System.out.println("Invalid choice");
                    break;
            }
        }

        return false;
    }


}