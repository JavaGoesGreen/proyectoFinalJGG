package com.rest.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.spring.dao.MensajeDao;
import com.rest.spring.model.Mensaje;

@Service
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	MensajeDao mensajeDao;

	public List<Mensaje> getMensajes() {
		return mensajeDao.findAll();
	}

	@Override
	public Mensaje addMensajes(Mensaje mensaje) {
		return mensajeDao.save(mensaje);
	}

	@Override
	public Mensaje updateMensajes(Mensaje mensaje) {
		return mensajeDao.save(mensaje);
	}

	@Override
	public Mensaje getMensajeById(Integer id) {
		List<Mensaje> listaMensajes = this.getMensajes();
		for (Mensaje p : listaMensajes) {
			if (p.getIdmensaje() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void deleteMensaje(Integer id) {

		mensajeDao.deleteById(id);

	}
}
