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

    public static String dynamicApprovalNumberQuery = " SELECT *\n" +
            "                             FROM FLEET_REQUEST \n" +
            "                             where  SENDER_RELATED_ENTITY_RECORD_ID   =1 \n" +
            "                             and SENDER_RELATED_ENTITY_ID = 11\n" +
            "                             and status_code in ( 'APPROVED')  ";

    public static String dynamicOwnedFleetQuery = "select Distinct F.PLATE_NUMBER , F.PLATE_CODE_EN\n" +
            "from FLEET_VIEW f , USERS u , COMPANIES_VIEW SH , PERMITS_VIEW P\n" +
            "where u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id\n" +
            " and f.RELATED_ENTITY_RECORD_ID=1\n" +
            " and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID\n" +
            " and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID\n" +
            " and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            " and f.PLATE_CODE_EN is not null  \n" +
            " and p.status_code not in ('PLND','READY_TO_ENTER','TOWARDFACILITY','WAITING_PAY')\n" +
            " and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED','INCOMPLETE')\n" +
            " and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            " and f.ENTITY_RECORD_ID not in ( select ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where\n" +
            " sv.SERVICE_CODE in ( 'WEIGH','Access' ) and sv.fleet_entity_id = 8 and sv.status_code in ('EXPIRED' , 'INACTIVE' ))";
}
