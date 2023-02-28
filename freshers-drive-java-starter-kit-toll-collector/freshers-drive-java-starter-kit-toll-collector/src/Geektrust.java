import model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by Jitendra on 15/01/2023.
 * Geektrust.java
 *
 */
public class Geektrust {

    /**
     * @Variable : Maintains FastTag Amount for each Vehicle
     * @Key : Key stored in the HashMap is a vehicle number
     * @Value : Value stored in the HashMap is FastTag Account For the vehicle
     */
    private static HashMap<String , FastTagVehicleDetails> fastTagDetails = new HashMap<>() ;
    /**
     * @Variable : List of all the vehicles which are currently in the Toll Plaza and waiting for the Toll
     */
    private static List<TollCollect> listOfTollCollectData = new ArrayList<>();
    /**
     * @Variable : The maintains all the Payment Details form all vehicle
     */
    private static PaymentSummaryDetails paymentSummaryDetails = new PaymentSummaryDetails();
    private static HashSet<String> passedVehicleDetails = new HashSet<>();


    public static void main(String[] args)  {

        try {

            FileInputStream fis = new FileInputStream( args[0] );
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {

                String inputCommand = sc.nextLine();

                String[] command = inputCommand.split(" ");
                String output = "";

                switch (command[0]) {
                    case "FASTAG":
                        fastTagDetails.put( command[1], new FastTagVehicleDetails( command[1], Integer.parseInt( command[2] )) );
                        break;
                    case "COLLECT_TOLL":

                        String vehicleNumber = command[2];

                        FastTagVehicleDetails fastTagVehicleDetails = fastTagDetails.get( command[2] );
                        VehicleType vehicleType = Enum.valueOf(VehicleType.class, command[1]);

                        listOfTollCollectData.add(
                                new TollCollect( vehicleType , vehicleNumber , fastTagVehicleDetails, passedVehicleDetails.contains( command[2] )  )
                        );

                        if ( passedVehicleDetails.contains( vehicleNumber ) ) passedVehicleDetails.remove( vehicleNumber );
                        else passedVehicleDetails.add(vehicleNumber);

                        break;

                    case "PRINT_COLLECTION":
                        output = printDetailsHandler(fastTagDetails, listOfTollCollectData);
                        System.out.print( output );
                        break;
                }



            }

            sc.close();

        } catch (IOException e) {

            System.out.println("in exception");

        }

    }

    private static String printDetailsHandler(HashMap<String, FastTagVehicleDetails> fastTagData, List<TollCollect> listOfTollCollect) {

        for ( TollCollect car : listOfTollCollect ) {

            paymentSummaryDetails.collectToll( car );

        }

        return paymentSummaryDetails.getSummary();

    }









}
