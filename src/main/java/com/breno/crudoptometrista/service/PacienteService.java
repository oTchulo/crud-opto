package com.breno.crudoptometrista.service;

import com.breno.crudoptometrista.model.Paciente;
import com.breno.crudoptometrista.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    public Paciente salvar(Paciente paciente) {
        if (pacienteRepository.existsByCpf(paciente.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return pacienteRepository.save(paciente);
    }
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }
    public Paciente atualizar(Long id, Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNome(pacienteAtualizado.getNome());
                    paciente.setCpf(pacienteAtualizado.getCpf());
                    paciente.setIdade(pacienteAtualizado.getIdade());
                    paciente.setEndereco(pacienteAtualizado.getEndereco());
                    paciente.setGrauOlhoDireito(pacienteAtualizado.getGrauOlhoDireito());
                    paciente.setGrauOlhoEsquerdo(pacienteAtualizado.getGrauOlhoEsquerdo());
                    paciente.setDoenca(pacienteAtualizado.getDoenca());
                    paciente.setDataConsulta(pacienteAtualizado.getDataConsulta());
                    return pacienteRepository.save(paciente);
                })
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }
    public void deletar(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado");
        }
        pacienteRepository.deleteById(id);
    }
}
