/**
 * Авторо программы - HomeWork_6, СергейЯ. Дата создания: 24.10.16.
 * Файлы, чтение и запись
 */
import java.util.*;
import java.io.*;

class HomeWork_6{

    public static void main(String[] args) {
        String str[] = { "Javadoc is a tool which comes with JDK and it is used for generating Java code documentation.", 
                         "Following is a simple example where the lines inside /*….*/ are Java multi-line comments."
        };

        for ( int i=0; i < str.length; i++){
            try {
                FileOutputStream fout = null;
                fout = new FileOutputStream("F_test-"+i+".txt");
                for ( int j=0; j < str[i].length(); j++)  
                    fout.write(j);
                fout.close();
            } catch (IOException e){
                System.out.println("Error from work with files.");
            }

        }

            
        // fout = new FileOutputStream(1.txt)

        // for (Animal i : Animals) {
        //     i.show();
        //     System.out.println(i.Run());
        //     System.out.println(i.Swim());
        //     System.out.println(i.Jump());
        // }
    }
}















