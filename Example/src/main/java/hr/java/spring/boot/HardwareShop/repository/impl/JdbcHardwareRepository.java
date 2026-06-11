package hr.java.spring.boot.HardwareShop.repository.impl;

import hr.java.spring.boot.HardwareShop.domain.Hardware;
import hr.java.spring.boot.HardwareShop.mapper.HardwareRowMapper;
import hr.java.spring.boot.HardwareShop.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
@AllArgsConstructor
public class JdbcHardwareRepository implements HardwareRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Hardware> getAllHardware() {
        return jdbcTemplate.query("SELECT * FROM HARDWARE", new HardwareRowMapper());
    };

    @Override
    public List<Hardware> getHardwareByType(String type) {
        return jdbcTemplate.query("SELECT * FROM HARDWARE WHERE TYPE = ?", new HardwareRowMapper(), type);
    };

    @Override
    public int saveNewHardware(Hardware hardware) {
        return jdbcTemplate.update("INSERT INTO EMPLOYEE (CODE, PRICE, TYPE) VALUES (?, ?, ?)", hardware.getCode(), hardware.getPrice(), hardware.getType());
    };

    @Override
    public boolean deleteHardwareById(int id) {
        if (hardwareByIdExists(id)) {
            jdbcTemplate.update("DELETE FROM HARDWARE WHERE ID = ?", id);
            return true;
        } else {
            return false;
        }
    };

    @Override
    public Optional<Hardware> updateHardware(Hardware hardware, int id) {
        if (hardwareByIdExists(id)) {
            String statement = "UPDATE HARDWARE SET CODE = ?, PRICE = ?, TYPE = ? WHERE ID = ?";

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(statement);
                ps.setString(1, hardware.getCode());
                ps.setDouble(2, hardware.getPrice());
                ps.setString(3, hardware.getType());
                ps.setInt(4, id);

                return ps;
            });
        }
        return Optional.empty();
    };

    @Override
    public boolean hardwareByIdExists(int hardwareId) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM HARDWARE WHERE ID = ?", Integer.class, hardwareId
        );
        return count > 0;
    };
}
