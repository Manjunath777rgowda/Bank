
public class Validation {
    public int choiceValidation(String str) {
        try {

            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }


    public boolean PhoneNumberValidation(String str) {
        try {
            int phoneNumber = Integer.parseInt(str);
            int length = String.valueOf(str).length();
            if (length == 10) {
                return true;
            } else {
                System.out.println("Phone number should be 10 digits");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Invalid Phone Number");
            return false;
        }
    }

    public boolean typeValidation(String str) {
        if (str.matches("^([1-4])$")) {
            return true;
        }
        else return false;
    }

    public boolean AdharNumberValidation(String str) {
        try {
            Long.parseLong(str);
            int length = String.valueOf(str).length();
            if (length == 12) {
                return true;
            } else {
                System.out.println("Adhar number should be 12 digits");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Invalid Adhar Number");
            return false;
        }
    }

    public boolean nameValidation(String str) {
        if (str.matches("[a-zA-Z]+$")) {
            return true;
        }
        else return false;
    }

    public boolean dateValidation(String str)  {
        if (str.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            String[] parts = str.split("-");

            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int date=Integer.parseInt(parts[2]);
            if(year<1900 || year>=2018){
              //  System.out.println("invalid year");
                return false;
            }
            if(month<=0 || month>12)
            {
               // System.out.println("invalid month");
                return false;
            }
            if(date<0 || date>31 || (date>30 && (month==2 || month==4 || month==6 || month==9 || month==11)) || (date>29 && month==2) || (date>28 && month==2 && year%4!=0)){
               // System.out.println("invalid date");
                return false;
            }


            return true;
        }
        else return false;

    }






        public boolean passwordValidation(String str)    {
        if (str.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}$")) {
            return true;
        }
        else return false;
    }

    public boolean panValidation(String str)    {
        if (str.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            return true;
        }
        else return false;
    }

    public boolean emailValidation(String str) {
        if (str.matches("^([A-Za-z0-9._%+]*)[@]([A-Za-z]*)[.]([A-Za-z]*)$")) {
            return true;
        }
        else return false;
    }

    public boolean amountValidation(String str) {
        try{
            if (Float.parseFloat(str)>0 && Float.parseFloat(str)< Math.pow(10,20))
            {
                return true;
            }
            else
            {
                System.out.println("\n\nInvalid Amount");
                return false;
            }
        }
        catch(Exception e)
        {
            System.out.println("\n\nInvalid Amount");
            return false;
        }
    }
}