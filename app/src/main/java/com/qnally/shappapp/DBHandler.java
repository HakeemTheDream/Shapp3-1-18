package com.qnally.shappapp;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.sql.Statement;

/**
 * Created by hakeem on 2/15/2018.
 */

public class DBHandler extends AsyncTask<Void,Void,Void> {


    private static final String url="jdbc:mysql://sql9.freesqldatabase.com";
    private static final String user= "sql9223671";
    private static final String pass= "1U66YtaWyJ";
    private static final String DATABASE_NAME="sql9223671";
    private static  String TABLE_NAME="";
    public static String dbString;
    public static SQLInput sqlInput;
    public static SQLOutput sqlOutput;

    //retrieves dbString
    public static String getDBString(){
        return dbString;
    }

    //Prints database results in string format
    public String dataBaseToString(){

        String query= "SELECT * from "+ DATABASE_NAME +" WHERE 1 ";
        return dbString;
    }

    //Creates a connection to the database and uses a resultSet and it's metaData to get info from the table
    @Override
    protected Void doInBackground(Void... voids) {
        try{
            TABLE_NAME="personal_account_info_table";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,pass);
            String queryString= "SELECT * FROM "+ DATABASE_NAME + "."+TABLE_NAME+" WHERE 1";
         Statement statement= (PreparedStatement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //Enters personal account info to the database
            String insertPersonalInfoQuery="INSERT INTO `"+DATABASE_NAME+"`.`"+TABLE_NAME+"` (`first_name`, `last_name`,`street_address`,`city`,`state`,`zipcode`,`email_address`,`password`,`phone_number`) " +
                    "VALUES ('"+RegistrationPersonalInfo.newAccount.getFirstName()+"', '"+RegistrationPersonalInfo.newAccount.getLastName()+"','"+RegistrationPersonalInfo.newAccount.getShipping().getAddress()
                    +"','"+RegistrationPersonalInfo.newAccount.getShipping().getCity()+"','"+RegistrationPersonalInfo.newAccount.getShipping().getState()+"','"+RegistrationPersonalInfo.newAccount.getShipping().getZip()+"'," +
                    "'"+RegistrationPersonalInfo.newAccount.getEmail()+"','"+RegistrationPersonalInfo.newAccount.getPass()+"','"+RegistrationPersonalInfo.newAccount.getPhoneNumber()+"')";

            statement.executeUpdate(insertPersonalInfoQuery);

            //Enters card info to the database
            Statement statement2= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            TABLE_NAME="card_info_table";
            String insertCardInfoQuery="INSERT INTO `"+DATABASE_NAME+"`.`"+TABLE_NAME+"` (`name_on_card`, `card_number`,`card_cvv`,`card_expiration_date`,`phone_number`) " +
                    "VALUES ('"+RegistrationPersonalInfo.newAccount.getFinance().getCredit().getHolder()+"','"+RegistrationPersonalInfo.newAccount.getFinance().getCredit().getNum()+"','"+
                    RegistrationPersonalInfo.newAccount.getFinance().getCredit().getCode()+"','"+RegistrationPersonalInfo.newAccount.getFinance().getCredit().getYear()+"/"+
                    RegistrationPersonalInfo.newAccount.getFinance().getCredit().getMonth()+"','"+RegistrationPersonalInfo.newAccount.getPhoneNumber()+"')";
             statement2.executeUpdate(insertCardInfoQuery);
            statement.close();
            statement2.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
            dbString= "Database connection failure"+"\n"+e.toString();
        }
        return null;

         /*   Statement statement= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String insertPersonalInfoQuery="INSERT INTO `"+DATABASE_NAME+"`.`"+TABLE_NAME+"` (`first_name`, `last_name`,`street_address`,`city`,`state`,`zipcode`,`email_address`,`password`,`phone_number`) " +
                    "VALUES ('"+"yop"+"', '"+"kramer"+"','"+"5452 yimdy ccowa lane"
                    +"','"+"Atlanta"+"','"+"Georgia"+"','"+"90210"+"'," +
                    "'"+"hitemup@gmail.com"+"','"+"thispasswordTHO"+"','"+"6789998212"+"')";

            statement.executeUpdate(insertPersonalInfoQuery);
            Statement statement2= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            TABLE_NAME="card_info_table";
            String insertCardInfoQuery="INSERT INTO `"+DATABASE_NAME+"`.`"+TABLE_NAME+"` (`name_on_card`, `card_number`,`card_cvv`,`card_expiration_date`,`phone_number`) " +
                    "VALUES ('"+"Yop L Kramer"+"','"+"678596857463"+"','"+
                    "697"+"','"+"04/20"+"','"+"6789998212"+"')";
            statement2.executeUpdate(insertCardInfoQuery);
            // statement.close();
            statement2.close();
            conn.close();
            dbString= "Good shitt";

        }catch (Exception e){
            e.printStackTrace();
            dbString= "Database connection failure"+"\n"+e.toString();
        }
        return null;
        */
    }


//This method will later set the database results to be viewed in the text box
    protected void onPostExecute(Void aVoid) {

       RegistrationPersonalInfo.city.setText(Account.db.getDBString());
    }



}
