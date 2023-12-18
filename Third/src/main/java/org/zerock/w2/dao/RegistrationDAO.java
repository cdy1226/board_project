package org.zerock.w2.dao;
import lombok.Cleanup;
import org.zerock.w2.domain.Registration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {
    public void insert(Registration reg) throws Exception{
        String sql = "insert into tbl_meminfo(mid,mpw,mname,age,Email) values(?,?,?,?,?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, reg.getMid());
        preparedStatement.setString(2, reg.getMpw());
        preparedStatement.setString(3, reg.getMname());
        preparedStatement.setInt(4, reg.getAge());
        preparedStatement.setString(5, reg.getEmail());
        preparedStatement.executeUpdate();
    }

    public List<Registration> selectAll() throws Exception{
        String sql = "select * from tbl_meminfo";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<Registration> list = new ArrayList<>();
        while(resultSet.next()){
            Registration vo = Registration.builder()
                    .mid(resultSet.getString("mid"))
                    .mpw(resultSet.getString("mpw"))
                    .mname(resultSet.getString("mname"))
                    .age(Integer.valueOf(resultSet.getString("age")))
                    .email(resultSet.getString("Email"))
                    .build();
            list.add(vo);
        }
        return list;
    }
}
