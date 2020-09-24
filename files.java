package ru.geekbrains.files;

import java.io.*;

public class files {

    //метод для первого задания
    private static void writer(String filename, String filetext)
    {
        try{
            PrintStream fps = new PrintStream(new FileOutputStream(filename,true));
            fps.println(filetext);
            fps.close();

        }
        catch (IOException error)
        {
            error.printStackTrace();
        }

    }

    //метод  склеивания содержимого 2х файлов и сохранения в третий

    private static void reader(String filename1, String filename2)
    {
        String t1=""; //текст первого файла
        String t2=""; //текст второго файла
        //читаем первый файл
        try{
          //  PrintStream fps = new PrintStream(String.valueOf(new FileInputStream(filename))); вот тут что-то мне idea пыталась помочь, но не очень разобрался... поэтому сделал как на уроке)            System.out.println(fps) Выводи какую-то дичь...

                FileInputStream fis = new FileInputStream(filename1);
                   int i;
                   while ((i=fis.read()) != -1){
                    System.out.print((char) i);
                    t1=(""+(char)i);
                   }
                   //System.out.println(t1);
            writer("s3.txt",t1); //почему-то не работает... третий файл пуст
                              fis.close();


        }
        catch (FileNotFoundException error2)
        {
           System.out.println(error2.getMessage());
        }
        catch (IOException error)
        {
            System.out.println(error.getMessage());
        }


        //читаем второй файл
        try{

            FileInputStream fis = new FileInputStream(filename2);
            int i;
            while ((i=fis.read()) != -1){
                System.out.print((char) i);
                t2=(""+(char)i);
            }
           // System.out.println(t2);
            writer("s3.txt",t2); //не работает...
            fis.close();
        }
        catch (FileNotFoundException error2)
        {
            System.out.println(error2.getMessage());
        }
        catch (IOException error)
        {
            System.out.println(error.getMessage());
        }
        // а вот на моменте склеивания у меня дилема... почему-то к этому моменту кода, у меня уже пусто в t1 и t2... соответственно тут нечего уже делать...
      }


      //задание  понял только про полное сравнение строк, а как искать отдельные кусочки...что-то никак...
    private static boolean wordsfinder(String file, String word){
        String t="";
        try{

            FileInputStream fis = new FileInputStream(file);
            int i;
            while ((i=fis.read()) != -1){
                System.out.print((char) i);
                t=(""+(char)i);

            }
            fis.close();



        }
        catch (FileNotFoundException error2)
        {
            System.out.println(error2.getMessage());
        }
        catch (IOException error)
        {
            System.out.println(error.getMessage());
        }
        if(t.equals(word)  )
        {
            return true;
        }
        else {
            return false;

        }

    }



    public static void main (String[] args){
        String filepath = "s1.txt";
        String text="My first java code for write info to file, and i check exceptions";
       writer(filepath, text);
        //меняем значения переменных для второго файла
        filepath = "s2.txt";
        text="Lorem Ipsum etc... My second code for write info to file";
        writer(filepath, text);

        //выполняем второе задание, но чувствую накостылил я как мог))

        reader("s1.txt", "s2.txt");
        System.out.println(wordsfinder("s1.txt","first"));



    }
}
