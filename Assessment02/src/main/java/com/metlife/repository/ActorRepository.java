package com.metlife.repository;

import com.metlife.db.connection.FactoryStatement;
import com.metlife.db.connection.MysqlConnection;
import com.metlife.model.ActorModel;
import com.metlife.model.MoviesAndActor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ActorRepository {
    private static List<MoviesAndActor> moviesAndActors=new ArrayList<>();

    public void addBooking(List<ActorModel> actorModels){
        try(Connection connection=new MysqlConnection().getConnection();
            PreparedStatement preparedStatement= FactoryStatement.getPreparedStatement
                    (connection,"insert into actor (first_name,last_name,last_update,flg_deleted) values (?,?,?,?)");
        ){
            final int[] count = {0};
            if (actorModels!=null){
                actorModels.forEach(actorModel -> {
                if (Objects.nonNull(actorModel) && Objects.nonNull(preparedStatement)) {
                    try {
                        LocalDate localDate = LocalDate.now();
                        java.sql.Date sqlDate = Date.valueOf(localDate);
                        preparedStatement.setString(1, actorModel.getFirstName());
                        preparedStatement.setString(2, actorModel.getLastName());

                        preparedStatement.setDate(3,sqlDate);
                        preparedStatement.setBoolean(4,false);
                         count[0] += preparedStatement.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }
                });
                if (count[0]> 0)
                    System.out.println("Actor details updated successfully..");
                else
                    System.out.println("OOPs !! try latter....");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void displayActorAndMoviesDetails() {
        try (Connection connection = new MysqlConnection().getConnection();
             CallableStatement callableStatement = FactoryStatement.getCallableStatement(connection,"viewActorMoviesDetails()");
             ResultSet resultSet =callableStatement.executeQuery();
        ) {
            while (resultSet.next()){
                MoviesAndActor moviesAndActor=
                        new MoviesAndActor(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                moviesAndActors.add(moviesAndActor);
            }
            moviesAndActors.forEach(moviesAndActor -> System.out.println(moviesAndActor.getMoviesName() +" "+moviesAndActor.getActorName() +" "+moviesAndActor.getAvaliableLanguage()+" "+moviesAndActor.getMoviesCategory()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<MoviesAndActor> searchBaseOnType(int typeId,String type) {
        List<MoviesAndActor> moviesAndActorList=new ArrayList<>();
        try (Connection connection = new MysqlConnection().getConnection();

        ) {
            CallableStatement callableStatement  = null;
            ResultSet resultSet=null;
           switch (typeId){
               case 1: {
                   callableStatement = FactoryStatement.getCallableStatement(connection, "searchActorName('%" + type + "%')");
                   break;
               }
               case 2: {
                   callableStatement = FactoryStatement.getCallableStatement(connection, "searchByLanuage('%" + type + "%')");
                   break;
               }
               case 3: {
                   callableStatement = FactoryStatement.getCallableStatement(connection, "searchByCategory('%" + type + "%')");
                   break;
               }
           }
           if (callableStatement!=null) {
               resultSet = callableStatement.executeQuery();
               while (resultSet.next()) {
                   MoviesAndActor moviesAndActor =
                           new MoviesAndActor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                   moviesAndActorList.add(moviesAndActor);

               }
           }

            moviesAndActorList.forEach(System.out::println);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return moviesAndActorList;
    }
    public void updateBooking(ActorModel actorModel ){
        try(Connection connection=new MysqlConnection().getConnection();
            PreparedStatement preparedStatement= FactoryStatement.getPreparedStatement(connection,"update actor set first_name=?, last_name=? where actor_id=? ");
        ){
            if (Objects.nonNull(preparedStatement)) {
                preparedStatement.setString(1, actorModel.getFirstName());
                preparedStatement.setString(2, actorModel.getLastName());
                preparedStatement.setInt(3,actorModel.getActorId());
                int count=preparedStatement.executeUpdate();
                if (count> 0)
                    System.out.println("Actor details update successfully..");
                else
                    System.out.println("OOPs !! try latter....");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void deleteActorAccount(int actorId){
        try(Connection connection=new MysqlConnection().getConnection();
            CallableStatement callableStatement= FactoryStatement.getCallableStatement(connection,"deleteByActorId("+actorId+")");
        ){
            callableStatement.executeQuery();
          /*  ResultSet resultSet=callableStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
            }
*/
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
