import java.time.LocalDate;
import java.util.Scanner;

public class BankOperation {
    String str;
    float amount;
    Scanner sc = new Scanner(System.in);
    Validation v = new Validation();

    public void functionality(String accnumber) {
        boolean flag = true;
        int choice;
        if (accnumber != null) {
            do {
                System.out.println("\n1) Deposit \n2) Withdraw\n3) Balance " +
                        "\n4) Print account information \n5) Statement  \n6) Close any account \n7)logout\nEnter choice [1-7]: ");
                String temp = sc.next();
                choice = v.choiceValidation(temp);
                switch (choice)
                {
                    case 1:
                        Deposit(accnumber);
                        break;
                    case 2:
                        Withdraw(accnumber);
                        break;
                    case 3:
                        Balance(accnumber, 0);
                        break;
                    case 4:
                        AccountDetails(accnumber);
                        break;
                    case 5:
                        statement(accnumber);
                        break;
                    case 6:
                        closeAccount(accnumber);
                        flag = false;
                    case 7:
                        flag = false;
                        break;
                    default:
                        System.out.println("invalid choice");
                        break;
                }
            } while (flag);
        }
    }

    public void statement(String accnumber) {
        Transaction t = new Transaction();
        t.statement(accnumber);
    }

    public void createAccount() {
        Details d = new Details();
        String accnumber = d.getInputDetails();
        if (accnumber != null)
            System.out.println("*****----Account created Successfully----*****");
    }

    public String checkAccount()
    {
        Details d = new Details();
        System.out.println("enter your account number");
        String accno=sc.next();
        System.out.println("enter your account password");
        String password = sc.next();

        connectJDBC con=new connectJDBC();
        d=con.retrive(d,accno);

        if (d!=null) {
            String pass = d.getPassword();
            String accnum = d.getAccountNumber();
            if (accnum.equals(accno))
                if (password.equalsIgnoreCase(pass))
                    return accno;
        }
        System.out.println("Invalid Account number or password!!!!!\n Please Enter valid Account number and password");
        return null;
    }

    public void closeAccount(String accnumber){
        connectJDBC con=new connectJDBC();
        Details d=new Details();
        d=con.retrive(d,accnumber);
        System.out.println("Rs."+d.getInitialamount()+"withdraw Succesfully");
        d.setInitialamount(0);
        d.setStatus(0);
        con.update(d,accnumber);
        System.out.println("Account has been deActivated");
    }

    public void AccountDetails(String accnumber){
        connectJDBC con=new connectJDBC();
        Details sd = new Details();
        sd=con.retrive(sd,accnumber);

        System.out.println("-------------------------------------- Your details------------------------------");
        System.out.println("Account Number      : "+sd.getAccountNumber());
        System.out.println("Account Name        : "+sd.getAccountName());
        System.out.println("Pan number          : "+sd.getPanNumber());
        System.out.println("Email id            : "+sd.getEmailId());
        System.out.println("Adress              : "+sd.getAddress());
        System.out.println("Date Of Birth       : "+sd.getDob());
        System.out.println("Phone Number        : "+sd.getPhoneNumber());
        System.out.println("Adhar Number        : "+sd.getAdharNumber());
        System.out.println("------------------------------------------------------------------------------------");

    }

    public void Balance(String accnumber,int choice) {
        connectJDBC con=new connectJDBC();
        Details d=new Details();
        d=con.retrive(d,accnumber);
        float bal=d.getInitialamount();

        Transaction t=new Transaction();
        LocalDate depositeDate=java.time.LocalDate.now();
        if (choice==1)
        {
            String type="Deposit";
            t.updateTransaction(amount,depositeDate,type,accnumber,bal);
        }
        else if(choice==2)
        {
            String type="Withdraw";
            t.updateTransaction(amount,depositeDate,type,accnumber,bal);
        }
        else System.out.println("Your current Balance is: Rs."+bal);
    }

    public void Deposit(String accnumber) {
        connectJDBC con=new connectJDBC();
        Details d=new Details();
        d=con.retrive(d,accnumber);
        float balance=d.getInitialamount();
        try {
            System.out.println("\nEnter amount to deposit");
            str = sc.next();
            if (v.amountValidation(str))
            {
                amount = Float.parseFloat(str);
                balance = balance + amount;
                d.setInitialamount(balance);
                con.update(d,accnumber);
                System.out.println("\n\nRS." + amount + " Deposited Successfully");
                Balance(accnumber,1);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("TRANSACTION FAILURE");
        }
    }

    public void Withdraw(String accnumber) {

        connectJDBC con=new connectJDBC();
        Details d=new Details();
        d=con.retrive(d,accnumber);
        float balance=d.getInitialamount();
        try {
            System.out.println("\nEnter amount to Withdraw");
            str = sc.next();
            if (v.amountValidation(str)) {
                amount = Float.parseFloat(str);
                if (0 < amount && balance > amount) {
                    balance = balance - amount;
                    d.setInitialamount(balance);
                    con.update(d,accnumber);
                    System.out.println("\n\nRS." + amount + " Withdraw Successfully");
                    Balance(accnumber,2);
                }
                else
                    System.out.println("Insufficient Balance");
            }
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("TRANSACTION FAILURE");
        }
    }
}
