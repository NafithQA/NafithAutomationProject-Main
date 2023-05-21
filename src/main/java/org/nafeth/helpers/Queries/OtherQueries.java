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

    public static String staticApprovalNumberQuery = " SELECT *\n" +
            "                             FROM FLEET_REQUEST \n" +
            "                             where  SENDER_RELATED_ENTITY_RECORD_ID   =1 \n" +
            "                             and SENDER_RELATED_ENTITY_ID = 11\n" +
            "                             and status_code in ( 'APPROVED')  ";

    public static String dynamicApprovalNumberQuery(int SENDER_RELATED_ENTITY_RECORD_ID, int SENDER_RELATED_ENTITY_ID) {
        String query = " SELECT *\n" +
                "                             FROM FLEET_REQUEST \n" +
                "                             where  SENDER_RELATED_ENTITY_RECORD_ID   =" + SENDER_RELATED_ENTITY_RECORD_ID + " \n" +
                "                             and SENDER_RELATED_ENTITY_ID = " + SENDER_RELATED_ENTITY_ID + "\n" +
                "                             and status_code in ( 'APPROVED')  ";
        return query;
    }

    public static String dynamicOwnedFleetQuery(int RELATED_ENTITY_ID, int RELATED_ENTITY_RECORD_ID){


    String dynamicOwnedFleet = "select Distinct f.PLATE_NUMBER , f.PLATE_CODE_EN  \n" +
            "             from FLEET_VIEW f , USERS u ,   PERMITS_VIEW P \n" +
            "             where f.RELATED_ENTITY_ID = "+RELATED_ENTITY_ID+"  \n" +
            "              and  f.RELATED_ENTITY_RECORD_ID="+RELATED_ENTITY_RECORD_ID+" \n" +
            "              and f.RELATED_ENTITY_ID = p.stakeholder_entity_id\n" +
            "              and f.RELATED_ENTITY_RECORD_ID = p.stakeholder_entity_record_id\n" +
            "              and f.PLATE_CODE_EN is not null  \n" +
            "              and p.status_code not in ('CLOSED' ) \n" +
            "              and p.status_code not in ('PLND','READY_TO_ENTER','TOWARDFACILITY','WAITING_PAY','REVOKED') \n" +
            "              and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED','INCOMPLETE') \n" +
            "              and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') ) \n" +
            "              and f.ENTITY_RECORD_ID not in ( select ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "              sv.SERVICE_CODE in ( 'WEIGH','Access' ) and sv.fleet_entity_id = 8 and sv.status_code  not in ('EXPIRED' , 'INACTIVE' ))";
        return dynamicOwnedFleet;
    }
    public static String dynamicPermitNafithQuery = " select Distinct f.PLATE_NUMBER , f.PLATE_CODE_EN  \n" +
            "             from FLEET_VIEW f , USERS u ,   PERMITS_VIEW P \n" +
            "             where  \n" +
            "                f.RELATED_ENTITY_ID = p.stakeholder_entity_id\n" +
            "              and f.RELATED_ENTITY_RECORD_ID = p.stakeholder_entity_record_id\n" +
            "              and f.PLATE_CODE_EN is not null  \n" +
            "              and p.status_code not in ('CLOSED' ) \n" +
            "              and p.status_code not in ('PLND','READY_TO_ENTER','TOWARDFACILITY','WAITING_PAY','REVOKED') \n" +
            "              and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED','INCOMPLETE') \n" +
            "              and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') ) \n" +
            "              and f.ENTITY_RECORD_ID not in ( select ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "              sv.SERVICE_CODE in ( 'WEIGH','Access' ) and sv.fleet_entity_id = 8 and sv.status_code  not in ('EXPIRED' , 'INACTIVE' ))";
}