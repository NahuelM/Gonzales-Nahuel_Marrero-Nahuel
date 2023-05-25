package dao.imp;

import entity.Odontologo;
import dao.IDao;

import java.util.List;
import java.util.logging.Logger;

public class OdontologoH2 implements IDao <Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoH2.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return null;
    }

    @Override
    public List<Odontologo> listartodos() {
        return null;
    }
}
