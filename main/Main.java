package academiaDev.main;

import academiaDev.model.*;
import academiaDev.service.*;
import academiaDev.util.InitialData;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, Course> courses = InitialData.loadCourses();
        Map<String, User> users = InitialData.loadUsers();

        CourseService courseService = new CourseService(courses);
        EnrollmentService enrollmentService = new EnrollmentService();
        ReportService reportService = new ReportService();

        Scanner sc = new Scanner(System.in);
        System.out.println("--- BEM-VINDO À ACADEMIA DEV ---");
        System.out.print("Digite seu e-mail para entrar: ");
        String email = sc.nextLine();

        User user = users.get(email);

        if (user == null) {
            System.out.println("Erro: Usuário não encontrado.");
            return;
        }

        System.out.println("\nOlá, " + user.getName() + "! Você logou como: " + user.getClass().getSimpleName());

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- MENU DE OPÇÕES ---");

            if (user instanceof Admin) {
                System.out.println("1. Listar todos os cursos");
                System.out.println("2. Alterar status de um curso");
                System.out.println("3. Ver instrutores únicos (Relatório)");
            } else if (user instanceof Student) {
                System.out.println("1. Ver cursos disponíveis");
                System.out.println("2. Matricular-se em um curso");
                System.out.println("3. Ver meu progresso");
            }

            System.out.println("0. Sair do sistema");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- LISTA DE CURSOS ---");
                    courseService.listCourses().forEach(c ->
                            System.out.println("- " + c.getTitle() + " [" + c.getStatus() + "]"));
                    break;

                case 2:
                    if (user instanceof Admin) {
                        System.out.print("Nome do curso: ");
                        String titulo = sc.nextLine();
                        System.out.print("Novo Status (ACTIVE/INACTIVE): ");
                        String novoStatus = sc.nextLine().toUpperCase();

                        try {
                            // Converte String pra enum antes de enviar pro service
                            CourseStatus statusEnum = CourseStatus.valueOf(novoStatus);
                            courseService.changeStatus(titulo, statusEnum);
                            System.out.println("Status atualizado com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: Status inválido.");
                        }
                    } else if (user instanceof Student) {
                        System.out.print("Digite o nome exato do curso para matrícula: ");
                        String nomeCurso = sc.nextLine();
                        Course cursoAlvo = courses.get(nomeCurso);

                        try {
                            enrollmentService.enroll((Student) user, cursoAlvo);
                            System.out.println("Matrícula realizada com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro na matrícula: " + e.getMessage());
                        }
                    }
                    break;

                case 3:
                    if (user instanceof Admin) {
                        Set<String> instrutores = reportService.uniqueInstructors(new ArrayList<>(courses.values()));
                        System.out.println("Instrutores ativos: " + instrutores);
                    } else {
                        System.out.println("Funcionalidade de progresso em desenvolvimento...");
                    }
                    break;

                case 0:
                    continuar = false;
                    System.out.println("Encerrando... Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}