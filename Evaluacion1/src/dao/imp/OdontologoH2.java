package dao.imp;

import dao.H2Connection;
import entity.Odontologo;
import dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoH2 implements IDao <Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoH2.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);


            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, odontologo.getMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                odontologo.setMatricula(rs.getInt(1));
            }

            connection.commit();
            LOGGER.info("Se ha registrado el Odontologo: " + odontologo);

        }catch (Exception e){
            LOGGER.info(e.getMessage());
            e.printStackTrace();
            if(connection != null){
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception){
                    LOGGER.info(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                LOGGER.info("Ha ocurrido un error al intentar cerrar la bdd. " + e.getMessage());
                e.printStackTrace();
            }
        }

        return odontologo;
    }
    @Override
    public List<Odontologo> listartodos() {

        Connection connection = null;
        List<Odontologo> odontologos= new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3));
                odontologos.add(odontologo);
            }

            LOGGER.info("Listado de todos los odontologos: " + odontologos);

        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.info("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologos;
    }
}
