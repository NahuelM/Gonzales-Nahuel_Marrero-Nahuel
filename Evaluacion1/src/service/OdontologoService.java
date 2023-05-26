package service;

import dao.IDao;
import entity.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> pacienteIDao) {
        this.odontologoIDao = pacienteIDao;
    }

    public Odontologo guardarPaciente(Odontologo paciente){
        return odontologoIDao.guardar(paciente);
    }



    public List<Odontologo> listarPacientes(){
        return odontologoIDao.listartodos();
    }
}
