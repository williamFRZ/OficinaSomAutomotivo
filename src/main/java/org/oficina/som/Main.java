package org.oficina.som;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.oficina.som.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Cliente cliente = new Cliente("William", "99999-9999", "Rua Tal, 123");
            session.persist(cliente);

            Veiculo veiculo = new Veiculo("Ford Ka", "ABC-1234", 2003);
            veiculo.setCliente(cliente);
            session.persist(veiculo);

            OrdemServico os = new OrdemServico("Troca de som + instalação", veiculo);
            os.setStatus("Aberta");
            session.persist(os);

            Componente comp1 = new Componente("Alto-falante 6x9", "Par de 110W RMS", 10);
            Componente comp2 = new Componente("Módulo Taramps", "TS400X4", 5);

            session.persist(comp1);
            session.persist(comp2);

            OrdemServicoComponente osc1 = new OrdemServicoComponente(comp1, os, 2);
            OrdemServicoComponente osc2 = new OrdemServicoComponente(comp2, os, 1);

            session.persist(osc1);
            session.persist(osc2);

            os.getComponentes().add(osc1);
            os.getComponentes().add(osc2);

            comp1.getOrdemServicoComponentes().add(osc1);
            comp2.getOrdemServicoComponentes().add(osc2);

            transaction.commit();
            System.out.println("Tudo salvo!");
        } catch (Exception e) {
            System.out.println("Deu ruim dog:");
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
