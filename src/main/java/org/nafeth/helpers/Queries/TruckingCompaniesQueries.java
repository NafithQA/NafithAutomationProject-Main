package org.nafeth.helpers.Queries;

public class TruckingCompaniesQueries {

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_1 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , COMPANIES_VIEW SH\n" +
            "where  u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  \n" +
            " and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in (  select  ISNULL(sv.fleet_entity_record_id ,0)  from subscriptions_view sv where   \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and sv.status_code    in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  )) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_2 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , COMPANIES_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in  ( select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and sv.status_code in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_3 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , COMPANIES_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0)  from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and sv.status_code in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_4 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , COMPANIES_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  (select  ISNULL(sv.fleet_entity_record_id ,0)  from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and sv.status_code  in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_5 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , COMPANIES_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  (select  ISNULL(sv.fleet_entity_record_id ,0)  from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and sv.status_code in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_6 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , COMPANIES_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0)  from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and sv.status_code   in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_7 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , COMPANIES_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  (select  ISNULL(sv.fleet_entity_record_id ,0)  from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and sv.status_code in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  )) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_8 = "SELECT\n" +
            "u.login,\n" +
            "'123456' as password,\n" +
            "f.PLATE_NUMBER,\n" +
            "f.[PLATE_CODE_EN],\n" +
            "           f.[PLATE_CODE_AR]\n" +
            "FROM   FLEET_VIEW f , USERS u , COMPANIES_VIEW SH \n" +
            "\n" +
            "where  u.RELATED_ENTITY_ID = 11 and u.RELATED_ENTITY_RECORD_ID = SH.id and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID and f.RELATED_ENTITY_ID = 11 and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )and F.ENTITY_ID IN ('8' ) and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )and f.ENTITY_RECORD_ID not in \n" +
            "  (select  ISNULL(sv.fleet_entity_record_id ,0)  from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and sv.status_code   in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  order by f.ENTITY_ID , f.ENTITY_RECORD_ID desc";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_9 = "select \n" +
            " u.login,\n" +
            " '123456' as password,\n" +
            " f.PLATE_NUMBER,\n" +
            " f.[PLATE_CODE_EN],\n" +
            " f.[PLATE_CODE_AR]\n" +
            " from FLEET_VIEW f , USERS u , COMPANIES_VIEW SH , stakeholder_balances B\n" +
            "  where\n" +
            "  b.stakeholder_entity_id = 11 \n" +
            "  and b.stakeholder_entity_record_id = sh.id\n" +
            "  and u.RELATED_ENTITY_ID = 11 \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = SH.id \n" +
            "  and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID \n" +
            "  and f.RELATED_ENTITY_ID = 11 \n" +
            "  and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )\n" +
            "  and F.ENTITY_ID IN ('8' ) \n" +
            "  and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0)  from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and sv.status_code    in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  and b.balance > 35";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_10 = "select \n" +
            " u.login,\n" +
            " '123456' as password,\n" +
            " f.PLATE_NUMBER,\n" +
            " f.[PLATE_CODE_EN],\n" +
            " f.[PLATE_CODE_AR]\n" +
            " from FLEET_VIEW f , USERS u , COMPANIES_VIEW SH , stakeholder_balances B\n" +
            "  where\n" +
            "  b.stakeholder_entity_id = 11 \n" +
            "  and b.stakeholder_entity_record_id = sh.id\n" +
            "  and u.RELATED_ENTITY_ID = 11 \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = SH.id \n" +
            "  and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID \n" +
            "  and f.RELATED_ENTITY_ID = 11 \n" +
            "  and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )\n" +
            "  and F.ENTITY_ID IN ('8' ) \n" +
            "  and f.STATUS_CODE in ('REGISTERED') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in \n" +
            "  ( select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and sv.status_code in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  and b.balance > 35";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_11 = "select \n" +
            " u.login,\n" +
            " '123456' as password,\n" +
            " f.PLATE_NUMBER,\n" +
            " f.[PLATE_CODE_EN],\n" +
            " f.[PLATE_CODE_AR]\n" +
            " from FLEET_VIEW f , USERS u , COMPANIES_VIEW SH , stakeholder_balances B\n" +
            "  where\n" +
            "  b.stakeholder_entity_id = 11 \n" +
            "  and b.stakeholder_entity_record_id = sh.id\n" +
            "  and u.RELATED_ENTITY_ID = 11 \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = SH.id \n" +
            "  and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID \n" +
            "  and f.RELATED_ENTITY_ID = 11 \n" +
            "  and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )\n" +
            "  and F.ENTITY_ID IN ('8' ) \n" +
            "  and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in \n" +
            "  (  select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'ACCESS' ) and sv.fleet_entity_id = 8 and sv.status_code   in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  and b.balance > 35";

    public static String MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_12 = "select \n" +
            " u.login,\n" +
            " '123456' as password,\n" +
            " f.PLATE_NUMBER,\n" +
            " f.[PLATE_CODE_EN],\n" +
            " f.[PLATE_CODE_AR]\n" +
            " from FLEET_VIEW f , USERS u , COMPANIES_VIEW SH , stakeholder_balances B\n" +
            "  where\n" +
            "  b.stakeholder_entity_id = 11 \n" +
            "  and b.stakeholder_entity_record_id = sh.id\n" +
            "  and u.RELATED_ENTITY_ID = 11 \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = SH.id \n" +
            "  and u.RELATED_ENTITY_ID = f.RELATED_ENTITY_ID \n" +
            "  and u.RELATED_ENTITY_RECORD_ID = f.RELATED_ENTITY_RECORD_ID \n" +
            "  and f.RELATED_ENTITY_ID = 11 \n" +
            "  and u.role_code = 'COMPANIES_ADMIN'\n" +
            "  and f.property_value in ( 'HEAVY' )\n" +
            "  and F.ENTITY_ID IN ('8' ) \n" +
            "  and f.STATUS_CODE in ('INCOMPLETE') \n" +
            "  and f.ENTITY_RECORD_ID not in (select TRUCK_ID from AFFILIATION where FLEET_ENTITY_ID IN('8') )\n" +
            "  and f.ENTITY_RECORD_ID not in \n" +
            "  (  select  ISNULL(sv.fleet_entity_record_id ,0) from subscriptions_view sv where \n" +
            "  sv.SERVICE_CODE in ( 'WEIGH' ) and sv.fleet_entity_id = 8 and sv.status_code in (  'ACTIVE'  , 'PLANNED' , 'PENDING'  ) ) \n" +
            "  and b.balance > 35";
}
