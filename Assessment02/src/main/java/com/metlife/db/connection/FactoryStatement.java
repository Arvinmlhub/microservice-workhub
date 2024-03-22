package com.metlife.db.connection;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Logger;

public class FactoryStatement {

    static Logger log = Logger.getLogger(FactoryStatement.class.toString());
    public static Statement getStatement(Connection con){
        Statement statement = null;
        try{
            if (con!=null)
                statement=con.createStatement();

        }catch (Exception e){
            log.info("Exception occurred while creating statement");
        }
        return statement;
    }

    public static PreparedStatement getPreparedStatement(Connection con, String query){
        PreparedStatement preparedStatement = null;
        try{
            if (con!=null)
                preparedStatement=con.prepareStatement(query);


        }catch (Exception e){
            log.info("Exception occurred while creating statement");
        }
        return preparedStatement;
    }

    public static CallableStatement getCallableStatement(Connection con, String procedure){
        CallableStatement callableStatement = null;
        try{
            StringBuffer query=new StringBuffer("{call ");
            query.append(procedure);
            query.append("};");


            if (con!=null)
                callableStatement = con.prepareCall(query.toString());

        }catch (Exception e){
            log.info("Exception occurred while creating statement");
        }
        return callableStatement;
    }



}
