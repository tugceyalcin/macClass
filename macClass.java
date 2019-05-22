import org.apache.log4j.Logger;             //log4j lib including

import  java.io.BufferedReader;             //buffer lib
import  java.io.InputStreamReader;          //input stream reader lib

public class macClass {

    private static final Logger logger2 = Logger.getLogger(macClass.class);


    public static void runningCmdPrompter(String cmdMessage){

        try{
            Process p =  Runtime.getRuntime().exec(cmdMessage); // reaching cmd
            BufferedReader newBuffer = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String logMessage;

            while ((logMessage= newBuffer.readLine())!= null) {
                logger2.debug(logMessage); // if there is no exception or something ,message can be sent to debug
            }

        }catch (Exception iex){ // if there is an exception , it is caught and it is showed
            logger2.warn("Exception handled!!!");
            iex.printStackTrace();
        }
    }




    public static void main(String[] args){

        String ip ="ping google.com";
        String ipconfig ="ipconfig";
        String macID = "getmac /fo csv /nh";

        logger2.debug("Google Address Pinging");
        runningCmdPrompter(ip); // sending ıp which is pinged to method
        logger2.debug("--------------------------------------------------------");
        logger2.debug("PC IPv4: ");
        runningCmdPrompter(ipconfig); // sending ipconfig to method
        logger2.debug("--------------------------------------------------------");
        logger2.debug("PC macID: "); // sending PCmacID to method
        runningCmdPrompter(macID);
        logger2.debug("--------------------------------------------------------");

    }
}
