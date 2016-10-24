import java.io.*;
import java.util.Arrays;

/**
 * Авторо программы - HomeWork_6, СергейЯ. Дата создания: 24.10.16.
 * Файлы, чтение и запись
 */


class HomeWork_6{

    public static void main(String[] args) {
        String strAr[] = { "Javadoc is a tool which comes with JDK and it is used for generating Java code documentation.\n",
                "Following is a simple example where the lines inside /*...*/ are Java multi-line comments.\n"
        };

        // Create files
        new createFileForomArry(strAr, "F_test-");

        // task 2
        String All_text = "";
        for ( int i=0; i < strAr.length; i++){
            All_text += new readFile("F_test-"+i).readF();
        }

        System.out.println("Text from all files:\n" + All_text);
        // write in file full text
        new createFile (All_text, "F_test-All");

        // task 3*
        findWordInFile FindW = new findWordInFile("tool", "F_test-All");
        FindW.find();
    }
}

class findWordInFile {

    String nameFile;
    String wordForFind;
    String text;

    findWordInFile (String wordForFind, String nameFile){
        this.nameFile = nameFile;
        this.wordForFind = wordForFind;
        text = new readFile(nameFile).readF();
    }

    boolean   find () {
        try {
            FileInputStream fin=new FileInputStream(nameFile);

            int i=-1;
            int j=0;
            while((i=fin.read())!=-1) {
                if ( wordForFind.charAt(j) == (char) i ) {
                    if ( j == (wordForFind.length()-1) ) {
                        System.out.println("\n"+wordForFind+" - Find is OK \n" );
                        return true;
                    }
                    j++;
                } else  j=0;
            }
            fin.close();
        } catch (IOException e) { System.out.println("Error from work with files."); }
        return false;
    }
}

class createFile {
    String nameFile;
    String textForFile;
    createFile (String textForFile, String nameFile ) {
        this.textForFile = textForFile;
        this.nameFile = nameFile;
        createF ();
    }

    void createF () {
        try {
            FileOutputStream fout =  new FileOutputStream(nameFile);
            fout.write( textForFile.getBytes() );
            fout.close();
        } catch (IOException e){ System.out.println("Error from work with files.");  }
        System.out.println("File created - " + nameFile);
    }
}

class  createFileForomArry  {
    String[] textForFileArray;
    String nameFile;
    createFileForomArry (String[] textForFileArray, String nameFile) {
        this.textForFileArray = textForFileArray;
        this.nameFile = nameFile;
        createF();
    }

    void createF() {
        for ( int i=0; i < textForFileArray.length; i++){
            new createFile( textForFileArray[i], nameFile+i);
        }
    }
}


class readFile {
    String textFromFile = "";
    String nameFile;
    readFile (String nameFile ) {
        this.nameFile = nameFile;
    }

    String readF () {
        try {
            FileInputStream fin=new FileInputStream(nameFile);

            int i=-1;
            while((i=fin.read())!=-1)
                textFromFile += (char)i;

            fin.close();
        } catch (IOException e) { System.out.println("Error from work with files."); }
        return textFromFile;
    }
}




