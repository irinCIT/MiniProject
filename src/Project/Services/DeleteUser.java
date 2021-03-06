package Project.Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteUser {

    /*
    a void method, that reads the lines from the text file, from each line, stores its value in the 3rd index (which is the userCode),
    and stores it into an array of strings, checks if the code (a parameter), is in the array of strings,
    and then writes all the lines that do not contain the code
     */
    public static void deleteFromFIle(String code){
        try{
            FileReader fileReader = new FileReader("C:\\Users\\User\\eclipse-workspace\\MiniProject\\src\\Project\\Services\\storage.txt");
            BufferedReader br = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            int count = 0;
            while ((line = br.readLine()) != null){
                lines.add(line);
                count++;
            }
            br.close();

            String[] parts ;
            String[] codes = new String[count];
            int x = 0;
            for (String token: lines){
                parts = token.split(" ");
                codes[x] = parts[3];
                x++;
            }

            int y = 0;
            if (Arrays.asList(codes).contains(code)){
                System.out.println("------ Code Found! ------");
            }else {
                while (y < 1) {
                    System.err.println("------ Code Not Found! ------");
                    y++;
                }
                Loops.loop();
            }

            FileWriter file = new FileWriter(("C:\\Users\\User\\eclipse-workspace\\MiniProject\\src\\Project\\Services\\storage.txt"));
            for (String str: lines){
                if (!str.contains(code)){
                    file.write(str + "\r\n");
                }
            }
            file.close();
            AddUser.displayList();

        }catch (IOException | Error e){
            System.out.println(e.getMessage());
        }
    }
}
