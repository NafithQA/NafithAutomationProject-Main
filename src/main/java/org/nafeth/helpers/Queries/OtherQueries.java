package org.nafeth.helpers.Queries;

public class OtherQueries {

    public static String validRnnQuery = "SELECT TOP (1000) [receipt_id]\n" +
            "  FROM [OmanTCS_QA].[dbo].[POS_TRANSACTIONS]\n" +
            "   where  status_code    in ( 'PENDING') \n" +
            "  and created_by = 1\n" +
            "  and amount = 35";

    public static String testsInformationsQuery = "SELECT TOP (1000) [id]\n" +
            "      ,[test_scenario_id]\n" +
            "      ,[test_case_id]\n" +
            "      ,[test_case_query]\n" +
            "      ,[test_type]\n" +
            "  FROM [QA_MAMS].[dbo].[Package_Cases_multi_location]";

    public static String paymentMethodsQuery(int paymentID){

        String paymentMethodsQuery = "SELECT  * \n" +
                "  FROM [OmanTCS_QA].[dbo].[lt_payment_methods] WHERE id = "+paymentID+"";
        return paymentMethodsQuery;
    }
}
