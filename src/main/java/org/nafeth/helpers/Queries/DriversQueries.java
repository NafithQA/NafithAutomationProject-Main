package org.nafeth.helpers.Queries;

public class DriversQueries {

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_1 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , OWNERS_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 10 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 10 and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select   ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and sv.status_code    in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  )) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_2 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , OWNERS_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 10 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 10 and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_3 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , OWNERS_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 10 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 10 and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_4 = "select u.login,'123456' as password,f.PLATE_NUMBER,f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "\n" +
            "from   FLEET_VIEW f , USERS u , OWNERS_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 10 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 10 and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_5 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , OWNERS_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 10 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 10 and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_6 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , OWNERS_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 10 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 10 and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_7 = "select u.login,'123456' as password,f.PLATE_NUMBER,f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "\n" +
            "from   FLEET_VIEW f , USERS u , OWNERS_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 10 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 10 and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_8 = "select u.login,'123456' as password,f.PLATE_NUMBER,f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "\n" +
            "from   FLEET_VIEW f , USERS u , OWNERS_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 10 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 10 and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select   ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and ( sv.status_code in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_9 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM FLEET_VIEW f , USERS u , OWNERS_VIEW SH , stakeholder_balances B\n" +
            "  where\n" +
            "  b.stakeholder_entity_id = 10 \n" +
            "  and b.stakeholder_entity_record_id = sh.id\n" +
            "  and u.RELATED_ENTITY_ID = 10\n" +
            "  and u.RELATED_ENTITY_RECORD_ID = SH.id \n" +
            "  and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID \n" +
            "  and f.RELATED_ENTITY_ID = 10 \n" +
            "  and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )\n" +
            "  and F.ENTITY_ID IN ('8' ) \n" +
            "  and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in \n" +
            "  ( select   ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and ( sv.status_code in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  and b.balance > 10";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_10 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM FLEET_VIEW f , USERS u , OWNERS_VIEW SH , stakeholder_balances B\n" +
            "  where\n" +
            "  b.stakeholder_entity_id = 10 \n" +
            "  and b.stakeholder_entity_record_id = sh.id\n" +
            "  and u.RELATED_ENTITY_ID = 10\n" +
            "  and u.RELATED_ENTITY_RECORD_ID = SH.id \n" +
            "  and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID \n" +
            "  and f.RELATED_ENTITY_ID = 10 \n" +
            "  and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )\n" +
            "  and F.ENTITY_ID IN ('8' ) \n" +
            "  and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in \n" +
            "  ( select   ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  and b.balance > 10";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_11 = "select \n" +
            " u.login,\n" +
            " '123456' as password,\n" +
            " f.PLATE_NUMBER,\n" +
            " f.[PLATE_CODE_EN],\n" +
            " f.[PLATE_CODE_AR]\n" +
            " from FLEET_VIEW f , USERS u , OWNERS_VIEW SH , stakeholder_balances B\n" +
            "  where\n" +
            "  b.stakeholder_entity_id = 10 \n" +
            "  and b.stakeholder_entity_record_id = sh.id\n" +
            "  and u.RELATED_ENTITY_ID = 10\n" +
            "  and u.RELATED_ENTITY_RECORD_ID = SH.id \n" +
            "  and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID \n" +
            "  and f.RELATED_ENTITY_ID = 10 \n" +
            "  and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )\n" +
            "  and F.ENTITY_ID IN ('8' ) \n" +
            "  and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in \n" +
            "  ( select   ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  and b.balance > 10";

    public static String MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_12 = "select \n" +
            " u.login,\n" +
            " '123456' as password,\n" +
            " f.PLATE_NUMBER,\n" +
            " f.[PLATE_CODE_EN],\n" +
            " f.[PLATE_CODE_AR]\n" +
            " from FLEET_VIEW f , USERS u , OWNERS_VIEW SH , stakeholder_balances B\n" +
            "  where\n" +
            "  b.stakeholder_entity_id = 10 \n" +
            "  and b.stakeholder_entity_record_id = sh.id\n" +
            "  and u.RELATED_ENTITY_ID = 10\n" +
            "  and u.RELATED_ENTITY_RECORD_ID = SH.id \n" +
            "  and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID \n" +
            "  and f.RELATED_ENTITY_ID = 10 \n" +
            "  and u.role_code = 'OWNERS_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )\n" +
            "  and F.ENTITY_ID IN ('8' ) \n" +
            "  and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and ( sv.status_code  in ( 'ACTIVE' , 'PLANNED' , 'PENDING' ) ) ) \n" +
            "  and b.balance > 10";
}
