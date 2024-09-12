package br.com.animals.animal_service.controllers;

import br.com.animals.animal_service.entities.repositories.FuncionarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private FuncionarioRepository repository;

    public FuncionarioController(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/animais-resgatados")
    private List<Object[]> countAnimaisResgatadosPorFuncionarioNoIntervalo(@RequestParam Date dataInicial,
                                                                           @RequestParam Date dataFinal) {
        LocalDate localDateInicial = dataInicial.toLocalDate();
        LocalDate localDateFinal = dataFinal.toLocalDate();
        if (localDateInicial.plusYears(1).isBefore(localDateFinal)) {
            throw new IllegalArgumentException("Prazo máximo entre datas é de 1 ano");
        }

        return repository.countAnimaisResgatadosPorFuncionarioNoIntervalo(dataInicial, dataFinal);
    }
}
