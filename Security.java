import java.text.ParseException;

public class Security {


        int part[]=new int[100];
        String encrypted="", decrypted="";
        public String encryption (String password)
        {

            char[] chars=password.toCharArray();
            System.out.println(chars);

            for (int i = 0; i < password.length(); i++)
            {
               // System.out.println(chars[i]);
                int ascii = (int) chars[i];

               part[i] = ((ascii + 3) % 256);
                //System.out.println((char)(part[i]));

               encrypted = encrypted + (char)(part[i]);

            }

            return encrypted;
        }

        public String decryption (String password)
        {
            char[] chars=password.toCharArray();
            System.out.println(chars);

            for (int i = 0; i < password.length(); i++)
            {
                //System.out.println(chars[i]);
                int ascii = (int) chars[i];

                part[i] = ((ascii - 3) % 256);
               // System.out.println((char)(part[i]));

                decrypted = decrypted + (char)(part[i]);

            }

            return decrypted;
        }


}
