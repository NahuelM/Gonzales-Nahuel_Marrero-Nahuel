package Test;
import dao.imp.OdontologoH2;
import dao.imp.OdontologoLocalMemory;
import entity.Odontologo;
import org.apache.log4j.Logger;
import org.junit.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TestOdontologo {
    private static final Logger LOGGER = Logger.getLogger(TestOdontologo.class);
    private OdontologoService pacienteServiceH2 = new OdontologoService(new OdontologoH2());
    private OdontologoService pacienteServiceLocalMemory = new OdontologoService(new OdontologoLocalMemory());


/*
     @BeforeAll
     static void doBefore() throws ClassNotFoundException, SQLException {
         Connection connectionH2 = null;
         try {
             Class.forName("org.h2.Driver");
             connectionH2 = DriverManager.getConnection("jdbc:h2:~/Eval1Nahuel;INIT=RUNSCRIPT FROM 'Script.sql'", "sa", "sa");
         } catch (SQLException | ClassNotFoundException e){
             e.printStackTrace();
         } finally {
             try {
                 connectionH2.close();
             } catch (Exception ex){
                 ex.printStackTrace();
             }
         }
     }
     */
    @Test
    public void sePudoGuardarEnH2(){
        Odontologo odontologo = new Odontologo(555444, "Nahuel", "Marrero");

        Odontologo pacienteResult = pacienteServiceH2.guardarOdontologo(odontologo);

        assertNotNull(pacienteResult);
        assertEquals(555444, pacienteResult.getMatricula());
    }

    @Test
    public void listarTodosLosOdontologosEnH2(){
        List<Odontologo> odontologoList = pacienteServiceH2.listarOdontologos();
        assertFalse(odontologoList.isEmpty());


    }

    @Test
    public void sePudoGuardarEnLocalMem(){
        Odontologo odontologo = new Odontologo(555444, "Nahuel", "Marrero");

        Odontologo pacienteResult = pacienteServiceLocalMemory.guardarOdontologo(odontologo);

        assertNotNull(pacienteResult);
        assertEquals(555444, pacienteResult.getMatricula());
    }

    @Test
    public void listarTodosLosOdontologosEnLocalMem(){
        List<Odontologo> odontologoList = pacienteServiceLocalMemory.listarOdontologos();
        assertTrue(odontologoList.isEmpty());
        Odontologo newOdontologo1 = new Odontologo(123456, "odon1", "apellido1");
        Odontologo newOdontologo2 = new Odontologo(128456, "odon2", "apellido2");

        pacienteServiceLocalMemory.guardarOdontologo(newOdontologo1);
        pacienteServiceLocalMemory.guardarOdontologo(newOdontologo2);
        assertTrue(pacienteServiceLocalMemory.listarOdontologos().size() == 2);


    }
}
