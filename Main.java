import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Validation v = new Validation();
        BankOperation b = new BankOperation();
        RecurringAccount r=new RecurringAccount();
        FixedAccount f=new FixedAccount();

        while (true) {
            System.out.println("\n------------------------");
            System.out.println("BANK    OF     FRESHERS");
            System.out.println("------------------------\n");
            System.out.println("********WELCOME*********\n");
            System.out.println("Press 1-CreateAccount 2-Existing_account 3-exit");

            String str = sc.nextLine();
            choice = v.choiceValidation(str);
            switch (choice) {
                case 1:
                    b.createAccount();
                    break;

                case 2:
                    boolean flag = true;
                    while (flag) {
                        System.out.println("\n\n******Slect Account Type******");
                        System.out.println("1-Savings_account 2-Current_account 3-Reccuring_account 4-Fixed_account 5-Go_back 6-exit");

                        str = sc.next();
                        choice = v.choiceValidation(str);
                        switch (choice) {
                            case 1:
                                String accountnum = b.checkAccount();
                                if (accountnum != null && accountnum.matches("10SB[0-9][0-9][0-9][0-9]")) {
                                    b.functionality(accountnum);
                                    flag = false;
                                }
                                else{
                                    System.out.println("your account number is invalid ...try again!!");
                                }
                                break;
                            case 2:
                                accountnum = b.checkAccount();
                                if (accountnum != null && accountnum.matches("10CA[0-9][0-9][0-9][0-9]")) {
                                    b.functionality(accountnum);
                                    flag = false;
                                }
                                else{
                                    System.out.println("your account number is invalid ...try again!!");
                                }
                                break;
                            case 3:
                                accountnum = b.checkAccount();
                                if (accountnum != null && accountnum.matches("10RD[0-9][0-9][0-9][0-9]")) {
                                    b.functionality(accountnum);
                                    flag = false;
                                }
                                else{
                                    System.out.println("your account number is invalid ...try again!!");
                                }
                                accountnum = b.checkAccount();
                                if (accountnum != null) {
                                    r.recurringAccount(accountnum);
                                    flag = false;
                                }
                                break;
                            case 4:
                                accountnum = b.checkAccount();
                                if (accountnum != null && accountnum.matches("10FD[0-9][0-9][0-9][0-9]")) {
                                    b.functionality(accountnum);
                                    flag = false;
                                }
                                else{
                                    System.out.println("your account number is invalid ...try again!!");
                                }
                                accountnum = b.checkAccount();
                                if (accountnum != null) {
                                    f.fixedAccount(accountnum);
                                    flag = false;
                                }
                                break;

                            case 5:
                                flag = false;
                                break;
                            case 6:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid Choice\n");
                                break;
                        }
                    }

                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice\n");
                    break;
            }
        }
    }
}

