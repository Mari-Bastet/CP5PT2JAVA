package checkpointjava.cpjava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import checkpointjava.cpjava.domain.Brinquedo;
import checkpointjava.cpjava.repository.BrinquedoRepository;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoController {

	@Autowired
	BrinquedoRepository repo;
	
	
	@GetMapping
	public String retornaTodosBrinquedos(Model model){
		
	List<Brinquedo> brinquedos = (repo.findAll()).stream().filter(brinquedo -> brinquedo.getNome()!= null).toList();
	model.addAttribute("brinquedos",brinquedos);
	return "index";
		
	}
	
	@GetMapping("/{id}")
	public String retornaBrinquedoPorId(@PathVariable Long id, Model model) {

		try {
			Optional<Brinquedo> bri = repo.findById(id);

			if (bri.isPresent()) {

				Brinquedo brinquedo = bri.get();

				model.addAttribute("brinquedo", brinquedo);
				return "brinquedo/select"; // ResponseEntity.ok(brinquedoResource);

			} else {
				return "brinquedo/erro";

			}

		} catch (Exception e) {

			return e.getMessage();

		}

	}
	
	@GetMapping("/adicionarBrinquedo")
	public String retornaAdicionaBrinquedo(@ModelAttribute Brinquedo brinquedo) {

		try {

		  repo.save(brinquedo);

			return "brinquedo/insert";

		} catch (Exception e) {

			return "brinquedo/erro";
		}

	}

	@PostMapping("/adicionarBrinquedo")
	public String adicionaBrinquedo(@ModelAttribute Brinquedo brinquedo) {

		try {

		  repo.save(brinquedo);

			return "index";

		} catch (Exception e) {

			return "brinquedo/erro";
		}

	}

	@PostMapping("/excluir/{id}")
	public String deletarBrinquedoPorId(@PathVariable Long id) {

		try {
			repo.deleteById(id);
			return "index";
			

		} catch (Exception e) {

			return "brinquedo/erro";

		}

	}
//

	@GetMapping("/atualizarBrinquedo/{id}")
	public String mostraAlterarBrinquedo(@PathVariable("id") Long id, Model model) {
		Brinquedo brinquedo = repo.findById(id).orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
		model.addAttribute("brinquedo", brinquedo);
		return "brinquedo/update";
	}

	@PostMapping("/atualizarBrinquedo/{id}")
	public String alterarBrinquedoPorId(@PathVariable("id") Long id, @ModelAttribute Brinquedo brinquedo) {

		String retorno = null;
		try {
			Brinquedo brinquedoExistente = repo.findById(brinquedo.getId()).orElse(null);

			if (brinquedoExistente == null) {
				retorno = "brinquedo/erro";
			} else {

				brinquedoExistente.setNome(brinquedo.getNome());
				brinquedoExistente.setPreco(brinquedo.getPreco());
				brinquedoExistente.setTamanho(brinquedo.getTamanho());
				brinquedoExistente.setTipo(brinquedo.getTipo());
				brinquedoExistente.setClassificacao(brinquedo.getClassificacao());

				repo.save(brinquedoExistente);

				retorno = "brinquedo/update";

			}
			return retorno;

		} catch (Exception e) {
			return e.getMessage() ;
			//return "brinquedo/erro";
		}
	}

}
