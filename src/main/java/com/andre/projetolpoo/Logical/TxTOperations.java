package com.andre.projetolpoo.Logical;

import com.andre.projetolpoo.Models.Clinica;
import com.andre.projetolpoo.Models.Medico;
import com.andre.projetolpoo.Models.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxTOperations {
    public static void salvarTxt(String text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(text);
            writer.newLine(); // Adiciona uma nova linha
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static List<Clinica> lerTxtClinicas(String filePath) {
        List<Clinica> clinicas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 4) {
                    Clinica clinica = new Clinica(values[0], values[1], values[2], values[3]);
                    clinicas.add(clinica);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return clinicas;
    }

    public static List<Medico> lerTxtMedicos(String filePath) {
        List<Medico> medicos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 5) {
                    Medico medico = new Medico(values[0], values[1], values[2], values[3], values[4]);
                    medicos.add(medico);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return medicos;
    }

    public static List<Paciente> lerTxtPacientes(String filePath) {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 7) {
                    Paciente paciente = new Paciente(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
                    pacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return pacientes;
    }

    public static Paciente buscarPacientePorCPF(String filePath, String cpf) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 7 && values[1].equals(cpf)) {
                    return new Paciente(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }

    public static Medico buscarMedicoPorCPF(String filePath, String cpf) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 5 && values[1].equals(cpf)) {
                    return new Medico(values[0], values[1], values[2], values[3], values[4]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }

    public static Medico buscarMedicoPorCRM(String filePath, String crm) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 5 && values[3].equals(crm)) {
                    return new Medico(values[0], values[1], values[2], values[3], values[4]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }

    public static Clinica buscarClinicaPorCNPJ(String filePath, String cnpj) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 4 && values[1].equals(cnpj)) {
                    return new Clinica(values[0], values[1], values[2], values[3]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }

}

