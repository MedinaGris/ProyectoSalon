
package com.salon.dao;

import com.salon.dao.exceptions.NonexistentEntityException;
import com.salon.dao.exceptions.PreexistingEntityException;
import com.salon.entity.UsuarioJPA;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Griselda Medina Avendaño
 * Creado: 9 Mayo 2022
 * Actualizado: 
 */
public class UsuarioJPAJpaController implements Serializable {
private EntityManagerFactory emf = null;

    public UsuarioJPAJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_proyectoEstetica_war_1.0-SNAPSHOTPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void createUsuario(UsuarioJPA usuarioJPA) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioJPA);//para crear o actualizar 
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioJPA(usuarioJPA.getId()) != null) {//
                throw new PreexistingEntityException("UsuarioJPA " + usuarioJPA + " already exists.", ex);
            }
            throw ex;
        } finally {
            
            if (em != null) {
                em.close();
            }
        }
    }

    public void editUsuario(UsuarioJPA usuarioJPA) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioJPA = em.merge(usuarioJPA);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuarioJPA.getId();
                if (findUsuarioJPA(id) == null) {
                    throw new NonexistentEntityException("The usuarioJPA with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteUsuario(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioJPA usuarioJPA;
            try {
                usuarioJPA = em.getReference(UsuarioJPA.class, id);
                usuarioJPA.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioJPA with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioJPA);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioJPA> listarUsuarios() {
        return findUsuarioJPAEntities(true, -1, -1);
    }

    public List<UsuarioJPA> findUsuarioJPAEntities(int maxResults, int firstResult) {
        return findUsuarioJPAEntities(false, maxResults, firstResult);
    }

    private List<UsuarioJPA> findUsuarioJPAEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioJPA.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public UsuarioJPA findUsuarioJPA(int id) {
        
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioJPA.class, id);
        } finally {
            em.close();
        }
    }
    
    
    public UsuarioJPA login(String email, String contraseña) {

        List<UsuarioJPA> usuarios = listarUsuarios();
        for (UsuarioJPA usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    public int getUsuarioJPACount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioJPA> rt = cq.from(UsuarioJPA.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void desconectar(){
        emf.close();
    }
    
}
