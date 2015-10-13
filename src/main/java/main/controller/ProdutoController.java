package main.controller;

import java.util.ArrayList;
import java.util.List;

import main.model.ProdutoEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	
	@RequestMapping(value="/produtos", method=RequestMethod.GET)
    public List<ProdutoEntity> getProdutos() {
		List<ProdutoEntity> produtos = new ArrayList<ProdutoEntity>();
		produtos.add(new ProdutoEntity(1, "lapis", 1.10));
		produtos.add(new ProdutoEntity(2, "borracha", 0.45));
        return produtos;
    }
}
