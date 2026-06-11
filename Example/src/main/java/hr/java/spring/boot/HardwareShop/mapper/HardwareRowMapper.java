package hr.java.spring.boot.HardwareShop.mapper;

import hr.java.spring.boot.HardwareShop.domain.Hardware;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HardwareRowMapper implements RowMapper {

    @Override
    public Hardware mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hardware hardware = new Hardware();

        hardware.setId(rs.getInt("ID"));
        hardware.setCode(rs.getString("CODE"));
        hardware.setPrice(rs.getDouble("PRICE"));
        hardware.setType(rs.getString("TYPE"));

        return hardware;
    }
}
