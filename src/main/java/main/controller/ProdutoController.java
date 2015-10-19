package main.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.model.ProdutoEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("webapp");
    private static EntityManager em = emf.createEntityManager();

    @RequestMapping(value="/produtos", method=RequestMethod.GET)
    public List<ProdutoEntity> getProdutos() {
        List<ProdutoEntity> prod = em.createQuery("select p from ProdutoEntity p").getResultList();
        return prod;
    }

	@RequestMapping(value="/produto", method=RequestMethod.GET)
    public String setProduto(String name, Double value) {
		try {
			final ProdutoEntity prod = new ProdutoEntity(name, value);
			em.getTransaction().begin();
			em.persist(prod);
			em.getTransaction().commit();
			return "OK";
		} catch (Exception e) {
			return "ERRO: " + e.getMessage();
		}
    }
}
