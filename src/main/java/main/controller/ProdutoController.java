package main.controller;

import java.util.List;

import javax.persistence.EntityManager;

import main.ConAdmin;
import main.model.ProdutoEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @RequestMapping(value="/produto", method=RequestMethod.GET)
    public List<ProdutoEntity> getProduto() {
        List<ProdutoEntity> prod = ConAdmin.getEM().createQuery("select p from ProdutoEntity p").getResultList();
        return prod;
    }

	@RequestMapping(value="/produto", method=RequestMethod.POST)
    public String setProduto(String name, Double value) {
		try {
			final ProdutoEntity prod = new ProdutoEntity(name, value);
			final EntityManager em = ConAdmin.getEM();
			em.getTransaction().begin();
			em.persist(prod);
			em.getTransaction().commit();
			return "OK";
		} catch (Exception e) {
			return "ERROR: " + e.getMessage();
		}
    }

	@RequestMapping(value="/produto", method=RequestMethod.DELETE)
	public String deleteProduto(Integer id){
		try {
			final EntityManager em = ConAdmin.getEM();
			em.getTransaction().begin();
			final ProdutoEntity prod = em.find(ProdutoEntity.class, id);
			ConAdmin.getEM().remove(prod);
			em.getTransaction().commit();
		} catch (Exception e) {
			return "ERROR: " + e.getMessage();
		}
		return "OK";
	}
}
