package org.nafeth.helpers;

import org.nafeth.helpers.Queries.OtherQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    public static void main(String[] args) {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        ArrayList<String> testData = databaseHandler.getValidRnnFromDataBase(OtherQueries.dynamicRnnQuery("5"));
        System.out.println(testData.get(0));
    }

    // This hits the initial query to get Tests Informations and Queries             # 1 #
    public ArrayList<String> getTestsInformationsFromDataBase(String query) {
        // Build sql server jdbc connection url use sql server account authentication.
        String host = "82.212.90.190";
        String dbName = "QA_MAMS";
        String connectionUserName = "omantcs";
        String connectionPassword = "123456";

        String sqlServerConnectionUrl = "jdbc:sqlserver://" + host + ";databaseName=" + dbName + ";user=" + connectionUserName + ";password=" + connectionPassword + "";

        // Declare the JDBC objects.
        Connection dbConnection = null;
        Connection dbConnection1 = null;
        Statement statement = null;
        Statement statement1 = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;

        List<String> returnedResultSet = new ArrayList<String>();

        String id = null;
        String testScenarioId = null;
        String testCaseId = null;
        String testCaseQuery = null;
        String testType = null;

        try {
            // Get connection.
            dbConnection = DriverManager.getConnection(sqlServerConnectionUrl);
            dbConnection1 = DriverManager.getConnection(sqlServerConnectionUrl);

            // Execute sql and return data result.
            String SQL = query;
            statement = dbConnection.createStatement();
            statement1 = dbConnection1.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet1 = statement1.executeQuery(SQL);

            int rowCount = 0;
            int columnCount = 0;

            ResultSetMetaData resultSet_metaData = resultSet1.getMetaData();
            columnCount = resultSet_metaData.getColumnCount();

            // Get Row Count
            while (resultSet1.next()) {
                rowCount++;
            }

            System.out.println("Column Count is : " + columnCount);
            System.out.println("Row Count is : " + rowCount);

            // ArrayLists to store column's results sets
            ArrayList<String> idResultSet = new ArrayList<String>();
            ArrayList<String> testScenarioIdResultSet = new ArrayList<String>();
            ArrayList<String> testCaseIdResultSet = new ArrayList<String>();
            ArrayList<String> testCaseQueryResultSet = new ArrayList<String>();
            ArrayList<String> testTypeResultSet = new ArrayList<String>();

            // Loop the data result and display the data.
            while (resultSet.next()) {

                // Storing results sets into ArrayLists
                id = String.valueOf(idResultSet.add(resultSet.getString("id")));
                testScenarioId = String.valueOf(testScenarioIdResultSet.add(resultSet.getString("test_scenario_id")));
                testCaseId = String.valueOf(testCaseIdResultSet.add(resultSet.getString("test_case_id")));
                testCaseQuery = String.valueOf(testCaseQueryResultSet.add(resultSet.getString("test_case_query")));
                testType = String.valueOf(testTypeResultSet.add(resultSet.getString("test_type")));
            }

            // Adding all results sets into the main returnedResultSet to be returned to the requester
            int index = rowCount - 1;
            returnedResultSet.add(idResultSet.get(index));
            returnedResultSet.add(testScenarioIdResultSet.get(index));
            returnedResultSet.add(testCaseIdResultSet.get(index));
            returnedResultSet.add(testCaseQueryResultSet.get(index));
            returnedResultSet.add(testTypeResultSet.get(index));

            // Printing values of results sets
            System.out.println("ID : " + idResultSet.get(index));
            System.out.println("TEST_SCENARIO_ID : " + testScenarioIdResultSet.get(index));
            System.out.println("TEST_CASE_ID : " + testCaseIdResultSet.get(index));
            System.out.println("TEST_CASE_QUERY : " + testCaseQueryResultSet.get(index));
            System.out.println("TEST_TYPE : " + testTypeResultSet.get(index));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (resultSet1 != null) {
                try {
                    resultSet1.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return (ArrayList<String>) returnedResultSet;
    }

    // This hits the query taken from above to get Login & Test Data                 # 2 #
    public ArrayList<String> getTestDataUsingQuery(String query) {
        // Build sql server jdbc connection url use sql server account authentication.
//        String host = "192.168.6.24";
        String host = "82.212.90.190";
        String dbName = "OmanTCS_QA";
        String connectionUserName = "omantcs";
        String connectionPassword = "123456";

        String sqlServerConnectionUrl = "jdbc:sqlserver://" + host + ";databaseName=" + dbName + ";user=" + connectionUserName + ";password=" + connectionPassword + "";

        // Declare the JDBC objects.
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> returnedResultSet = new ArrayList<String>();

        String username = null;
        String password = null;
        String roleCode = null;
        String plateNumber = null;
        String plateCodeAr = null;
        String plateCodeEn = null;
        String packageCode = null;
        String planCode = null;
        String packageServiceCode = null;
        String packageServiceTotalPrice = null;
        String paymentMethod = null;
        String selectedServiceCode = null;
        String industrialEstateValue = null;

        try {
            // Get connection.
            dbConnection = DriverManager.getConnection(sqlServerConnectionUrl);

            // Execute sql and return data result.
            String SQL = query;
            statement = dbConnection.createStatement();
            resultSet = statement.executeQuery(SQL);

            // ArrayLists to store column's results sets
            ArrayList<String> usernameResultSet = new ArrayList<String>();
            ArrayList<String> passwordResultSet = new ArrayList<String>();
            ArrayList<String> roleCodeResultSet = new ArrayList<String>();
            ArrayList<String> plateNumberResultSet = new ArrayList<String>();
            ArrayList<String> plateCodeArResultSet = new ArrayList<String>();
            ArrayList<String> plateCodeEnResultSet = new ArrayList<String>();
            ArrayList<String> packageCodeResultSet = new ArrayList<String>();
            ArrayList<String> planCodeResultSet = new ArrayList<String>();
            ArrayList<String> packageServiceCodeResultSet = new ArrayList<String>();
            ArrayList<String> packageServiceTotalPriceResultSet = new ArrayList<String>();
            ArrayList<String> paymentMethodResultSet = new ArrayList<String>();
            ArrayList<String> selectedServiceCodeResultSet = new ArrayList<String>();
            ArrayList<String> industrialEstateValueSet = new ArrayList<String>();

            // Loop the data result and display the data.
            while (resultSet.next()) {

                // Storing results sets into ArrayLists
                username = String.valueOf(usernameResultSet.add(resultSet.getString("Username")));
                password = String.valueOf(passwordResultSet.add(resultSet.getString("password")));
                roleCode = String.valueOf(roleCodeResultSet.add(resultSet.getString("Rolecode")));
                plateNumber = String.valueOf(plateNumberResultSet.add(resultSet.getString("PLATE_NUMBER")));
                plateCodeAr = String.valueOf(plateCodeArResultSet.add(resultSet.getString("PLATE_CODE_AR")));
                plateCodeEn = String.valueOf(plateCodeEnResultSet.add(resultSet.getString("PLATE_CODE_EN")));
//                planCode = String.valueOf(planCodeResultSet.add(resultSet.getString("Plan_code")));
                packageCode = String.valueOf(packageCodeResultSet.add(resultSet.getString("c1")));
                packageServiceCode = String.valueOf(packageServiceCodeResultSet.add(resultSet.getString("c2")));
//                packageServiceTotalPrice = String.valueOf(packageServiceTotalPriceResultSet.add(resultSet.getString("package_service_total_price")));
                paymentMethod = String.valueOf(paymentMethodResultSet.add(resultSet.getString("c4")));
                selectedServiceCode = String.valueOf(selectedServiceCodeResultSet.add(resultSet.getString("c3")));
                industrialEstateValue = String.valueOf(industrialEstateValueSet.add(resultSet.getString("L")));
            }

            // Adding all results sets into the main returnedResultSet to be returned to the requester
            returnedResultSet.add(usernameResultSet.get(0));
            returnedResultSet.add(passwordResultSet.get(0));
            returnedResultSet.add(roleCodeResultSet.get(0));
            returnedResultSet.add(plateNumberResultSet.get(0));
            returnedResultSet.add(plateCodeArResultSet.get(0));
            returnedResultSet.add(plateCodeEnResultSet.get(0));
            returnedResultSet.add(paymentMethodResultSet.get(0));
            returnedResultSet.add(packageCodeResultSet.get(0));
            returnedResultSet.add(packageServiceCodeResultSet.get(0));
            returnedResultSet.add(selectedServiceCodeResultSet.get(0));
            returnedResultSet.add(industrialEstateValueSet.get(0));
//            returnedResultSet.add(packageServiceTotalPriceResultSet.get(0));
//            returnedResultSet.add(paymentMethodResultSet.get(0));

            // Printing values of results sets
            System.out.println("UserName : " + usernameResultSet.get(0));
            System.out.println("Password : " + passwordResultSet.get(0));
            System.out.println("Role Code : " + roleCodeResultSet.get(0));
            System.out.println("Plate Number : " + plateNumberResultSet.get(0));
            System.out.println("Plate Code AR : " + plateCodeArResultSet.get(0));
            System.out.println("Plate Code EN : " + plateCodeEnResultSet.get(0));
            System.out.println("Payment Method : " + paymentMethodResultSet.get(0));
            System.out.println("Package Code : " + packageCodeResultSet.get(0));
            System.out.println("Package Service Code : " + packageServiceCodeResultSet.get(0));
            System.out.println("Selected Service Code : " + selectedServiceCodeResultSet.get(0));
            System.out.println("Industrial Estate Value : " + industrialEstateValueSet.get(0));
//            System.out.println("Package Service Total Price : " + packageServiceTotalPriceResultSet.get(0));
//            System.out.println("Payment Method : " + paymentMethodResultSet.get(0));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return (ArrayList<String>) returnedResultSet;
    }

    // Pull Payment Methods
    public ArrayList<String> getPaymentMethods(String query) {
        // Build sql server jdbc connection url use sql server account authentication.
//        String host = "192.168.6.24";
        String host = "82.212.90.190";
        String dbName = "OmanTCS_QA";
        String connectionUserName = "omantcs";
        String connectionPassword = "123456";

        String sqlServerConnectionUrl = "jdbc:sqlserver://" + host + ";databaseName=" + dbName + ";user=" + connectionUserName + ";password=" + connectionPassword + "";

        // Declare the JDBC objects.
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> returnedResultSet = new ArrayList<String>();

        String id = null;
        String code = null;
        String nameEn = null;
        String nameAr = null;

        try {
            // Get connection.
            dbConnection = DriverManager.getConnection(sqlServerConnectionUrl);

            // Execute sql and return data result.
            String SQL = query;
            statement = dbConnection.createStatement();
            resultSet = statement.executeQuery(SQL);

            // ArrayLists to store column's results sets
            ArrayList<String> idResultSet = new ArrayList<String>();
            ArrayList<String> codeResultSet = new ArrayList<String>();
            ArrayList<String> nameEnResultSet = new ArrayList<String>();
            ArrayList<String> nameArResultSet = new ArrayList<String>();

            // Loop the data result and display the data.
            while (resultSet.next()) {

                // Storing results sets into ArrayLists
                id = String.valueOf(idResultSet.add(resultSet.getString("id")));
                code = String.valueOf(codeResultSet.add(resultSet.getString("code")));
                nameEn = String.valueOf(nameEnResultSet.add(resultSet.getString("name_en")));
                nameAr = String.valueOf(nameArResultSet.add(resultSet.getString("name_ar")));
            }

            // Adding all results sets into the main returnedResultSet to be returned to the requester
            returnedResultSet.add(idResultSet.get(0));
            returnedResultSet.add(codeResultSet.get(0));
            returnedResultSet.add(nameEnResultSet.get(0));
            returnedResultSet.add(nameArResultSet.get(0));

            // Printing values of results sets
            System.out.println("Payment ID : " + idResultSet.get(0));
            System.out.println("Payment Code : " + codeResultSet.get(0));
            System.out.println("Payment Name En : " + nameEnResultSet.get(0));
            System.out.println("Payment Name AR : " + nameArResultSet.get(0));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return (ArrayList<String>) returnedResultSet;
    }

    /* Use jdbc connection url to access sql server 1.*/
    public ArrayList<String> getLoginDataFromDataBaseUsingQuery(String query) {
        // Build sql server jdbc connection url use sql server account authentication.
//        String host = "192.168.6.24";
        String host = "82.212.90.190";
        String dbName = "OmanTCS_QA";
        String connectionUserName = "omantcs";
        String connectionPassword = "123456";

        String sqlServerConnectionUrl = "jdbc:sqlserver://" + host + ";databaseName=" + dbName + ";user=" + connectionUserName + ";password=" + connectionPassword + "";

        // Declare the JDBC objects.
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> returnedResultSet = new ArrayList<String>();

        String login = null;
        String password = null;
        String plateNumber = null;
        String plateCodeEn = null;
        String plateCodeAr = null;

        try {
            // Get connection.
            dbConnection = DriverManager.getConnection(sqlServerConnectionUrl);

            // Execute sql and return data result.
            String SQL = query;
            statement = dbConnection.createStatement();
            resultSet = statement.executeQuery(SQL);

            // ArrayLists to store column's results sets
            ArrayList<String> loginResultSet = new ArrayList<String>();
            ArrayList<String> passwordResultSet = new ArrayList<String>();
            ArrayList<String> plateNumberResultSet = new ArrayList<String>();
            ArrayList<String> plateCodeEnResultSet = new ArrayList<String>();
            ArrayList<String> plateCodeArResultSet = new ArrayList<String>();

            // Loop the data result and display the data.
            while (resultSet.next()) {

                // Storing results sets into ArrayLists
                login = String.valueOf(loginResultSet.add(resultSet.getString("login")));
                password = String.valueOf(passwordResultSet.add(resultSet.getString("password")));
                plateNumber = String.valueOf(plateNumberResultSet.add(resultSet.getString("PLATE_NUMBER")));
                plateCodeEn = String.valueOf(plateCodeEnResultSet.add(resultSet.getString("PLATE_CODE_EN")));
                plateCodeAr = String.valueOf(plateCodeArResultSet.add(resultSet.getString("PLATE_CODE_AR")));
            }

            // Adding all results sets into the main returnedResultSet to be returned to the requester
            returnedResultSet.add(loginResultSet.get(0));
            returnedResultSet.add(passwordResultSet.get(0));
            returnedResultSet.add(plateNumberResultSet.get(0));
            returnedResultSet.add(plateCodeEnResultSet.get(0));
            returnedResultSet.add(plateCodeArResultSet.get(0));

            // Printing values of results sets
            System.out.println("A : " + loginResultSet.get(0));
            System.out.println("B : " + passwordResultSet.get(0));
            System.out.println("C : " + plateNumberResultSet.get(0));
            System.out.println("D : " + plateCodeEnResultSet.get(0));
            System.out.println("E : " + plateCodeArResultSet.get(0));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return (ArrayList<String>) returnedResultSet;
    }

    // Pull UserName, Password and Fleet values from DataBase
    public ArrayList<String> getUserAndPassAndFleetFromDataBase(String query) {

        ArrayList<String> values = null;
        try {

            DatabaseHandler databaseHandler = new DatabaseHandler();
            values = databaseHandler.getLoginDataFromDataBaseUsingQuery(query);

            System.out.println("UserName is " + values.get(0));
            System.out.println("Pass is " + values.get(1));
            System.out.println("PlateNo is " + values.get(2));
            System.out.println("PlateCodeEn is " + values.get(3));
            System.out.println("PlateCodeAr is " + values.get(4));

            System.out.println("Full Plate No. is : " + values.get(2) + " " + values.get(3) + " " + values.get(4));

        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return values;
    }

    // Get Valid RNN
    public ArrayList<String> getValidRnnFromDataBase(String query) {
        // Build sql server jdbc connection url use sql server account authentication.
        String host = "192.168.6.48";
        String dbName = "OmanTCS_AUTOMATION";
        String connectionUserName = "qa";
        String connectionPassword = "QA123";

        String sqlServerConnectionUrl = "jdbc:sqlserver://" + host + ";databaseName=" + dbName + ";user=" + connectionUserName + ";password=" + connectionPassword + "";

        // Declare the JDBC objects.
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> returnedResultSet = new ArrayList<String>();

        String receiptNumber = null;

        try {
            // Get connection.
            dbConnection = DriverManager.getConnection(sqlServerConnectionUrl);

            // Execute sql and return data result.
            String SQL = query;
            statement = dbConnection.createStatement();
            resultSet = statement.executeQuery(SQL);

            // ArrayLists to store column's results sets
            ArrayList<String> receiptsResultSet = new ArrayList<String>();

            // Loop the data result and display the data.
            while (resultSet.next()) {

                // Storing results sets into ArrayLists
                receiptNumber = String.valueOf(receiptsResultSet.add(resultSet.getString("receipt_id")));
            }

            // Adding all results sets into the main returnedResultSet to be returned to the requester
            returnedResultSet.add(receiptsResultSet.get(1));

            // Printing values of results sets
            System.out.println("A : " + receiptsResultSet.get(1));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return (ArrayList<String>) returnedResultSet;
    }
}
