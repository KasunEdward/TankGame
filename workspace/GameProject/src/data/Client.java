package data;
import java.io.*;
import java.net.*;

public class Client {

   
    public static void main(String[] args) throws IOException {
  	Client c=new Client();
  	
  	
c.send();
c.receive();
    }
public void send(){
          try{
    // TODO code application logic here
            Socket client=new Socket("localhost",6000);
            System.out.println("Just connected to " 
		 + client.getRemoteSocketAddress());
         OutputStream os = client.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
 
           
            String sendMessage ="JOIN#";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : "+sendMessage);
         client.close();
    }catch(Exception e){
     e.printStackTrace();
    }
}
public void receive(){


try{

ServerSocket  s=new ServerSocket(7000);
ServerParsing se=new ServerParsing();

 
 // now I know how many bytes to read
while(true){
Socket server=s.accept();
DataInputStream din=new DataInputStream(server.getInputStream());  
try{
byte[] theBytes = new byte[1000];

String str2;
str2=new String(theBytes,0,din.read(theBytes));
se.identifyString(str2);
System.out.println("Server says: "+str2);  
}finally{
server.close();
}
}


}catch(Exception e){
e.printStackTrace();
}




}


}
