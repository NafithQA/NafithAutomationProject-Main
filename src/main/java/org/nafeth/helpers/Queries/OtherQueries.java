package org.nafeth.helpers.Queries;

public class OtherQueries {

    public static String dynamicRnnQuery(String amount) {

        String query = "SELECT TOP (1000) [receipt_id]\n" +
                "              FROM POS_TRANSACTIONS\n" +
                "               where  status_code    in ( 'PENDING')\n" +
                "              and created_by = 1\n" +
                "              and amount = " + amount + "";
        return query;
    }

    public static String validRnnQuery = "SELECT TOP (1000) [receipt_id]\n" +
            "              FROM POS_TRANSACTIONS\n" +
            "               where  status_code    in ( 'PENDING')\n" +
            "              and created_by = 1\n" +
            "              and amount = 5";

    public static String testsInformationsQuery = "SELECT TOP (1000) [id]\n" +
            "      ,[test_scenario_id]\n" +
            "      ,[test_case_id]\n" +
            "      ,[test_case_query]\n" +
            "      ,[test_type]\n" +
            "  FROM [QA_MAMS].[dbo].[Package_Cases_multi_location]";

    public static String paymentMethodsQuery(int paymentID) {

        String paymentMethodsQuery = "SELECT  * \n" +
                "  FROM [OmanTCS_QA].[dbo].[lt_payment_methods] WHERE id = " + paymentID + "";
        return paymentMethodsQuery;
    }

    public static String dynamicFleetRequestNumberQuery(String requestNumber) {

        String query = "SELECT TOP (1000) [FLEET_REQUEST_NUMBER]\n" +
                "              FROM FLEET_REQUEST\n" +
                "              where  SENDER_RELATED_ENTITY_RECORD_ID   =1\n" +
                "              and status_code  in ( 'APPROVED') " ;
        return query;
    }
    public static String dynamicOwnedFleetQuery(String OwnedFleet) {

        String query = "SELECT TOP (1000) [PLATE_NUMBER]\n" +
                "              [PLATE_CODE_AR]\n" +
                "              FROM trucks\n" +
                "              where  [RELATED_ENTITY_ID]   =11\n" +
                "              and    [RELATED_ENTITY_RECORD_ID]   =1\n" +
                "              and    [TRUCK_TYPE]   ='HEAVY'\n" +
                "              and    [STATUS_CODE]  in ('REGISTERED' , 'INCOMPLETE') \n";
         return query;
    }


}
