package dao.imp;


import dao.IDao;
import entity.Odontologo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OdontologoLocalMemory implements IDao<Odontologo> {
    private HashSet<Odontologo> odontologos = new HashSet();
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Odontologo newOdontologo = new Odontologo(odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());
        odontologos.add(newOdontologo);
        return newOdontologo;
    }

    @Override
    public List<Odontologo> listartodos() {
        List<Odontologo> resList = new ArrayList<>();
        for (Odontologo odontologo:odontologos)
            resList.add(odontologo);

        return resList;

    }
}
