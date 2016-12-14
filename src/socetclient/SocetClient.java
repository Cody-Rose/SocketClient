package socetclient;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocetClient {

    public static void main(String[] args) 
    {
    String r;
    String a;
    Scanner inputStream = null;
    PrintWriter outputStream = null;
    try
    {
        //connects to server on same machine, port6661
        Socket clientSocket = new Socket("", 6662);
        //Set up streams to sent/receove data
        inputStream = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
        outputStream = new PrintWriter(new DataOutputStream(clientSocket.getOutputStream()));
        
        //Send first line of data
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter first line of code.");
        r = keyboard.nextLine();
        outputStream.println(r);
        outputStream.flush();
        
        //receives message
        a = inputStream.nextLine();
        while(!(a.equalsIgnoreCase("end")))
        {
            System.out.println(a);
            r = keyboard.nextLine();
            outputStream.println(r);
            outputStream.flush();
            a = inputStream.nextLine();
        }
        
        System.out.println("Chat closed.");
        inputStream.close();
        outputStream.close();
    }
    catch (Exception e)
    {
        //If any exception occurs, display it.
        System.out.println("Error " + e);
    }
    }
    
}
