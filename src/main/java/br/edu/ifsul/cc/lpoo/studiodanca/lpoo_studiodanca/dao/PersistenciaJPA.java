/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.dao;

import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Modalidade;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author saimon-rocha
 */
public class PersistenciaJPA implements InterfacePersistencia {

    public EntityManagerFactory factory;    //fabrica de gerenciadores de entidades
    public EntityManager entity;            //gerenciador de entidades JPA

    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory = Persistence.createEntityManagerFactory("pu_studio_danca");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        EntityManager em = getEntityManager();
        return em.find(c, id);//encontra um determinado registro 
    }

    public void persist(Object o) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    /*
    Todos os métodos agora chamam getEntityManager() para garantir que o EntityManager esteja sempre aberto e pronto para uso.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public void remover(Object o) throws Exception {
//        No método remover, antes de chamar remove, usamos merge se o objeto não estiver gerenciado.
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                o = em.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    public List<Modalidade> getModalidades() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Modalidade> query = 
                    em.createQuery("SELECT m FROM Modalidade m", Modalidade.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Professor> getProfessores() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Professor> query = 
                    em.createQuery("SELECT m FROM Professor m", 
                            Professor.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
