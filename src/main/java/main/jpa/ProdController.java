package main.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class ProdController {

  @Autowired ProdRepository repository;

  @RequestMapping(value = "/prods", method = RequestMethod.GET)
  public List<Prod> getProds(){
    List<Prod> prods = repository.findByNome("a");
    return prods;
  }
}
