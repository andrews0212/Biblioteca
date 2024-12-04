package modelo.memoria;

import modelo.DAO.DAOGN;
import modelo.DTO.Ejemplar;
import modelo.DTO.Libro;
import modelo.DTO.Prestamo;
import modelo.DTO.Usuario;

import java.util.List;

public class MemoriaGN<T,ID> {
    private List<T> list;
    private Class<T> entityClass;
    private DAOGN<T,ID> dao;

    public MemoriaGN(Class<T> entityClass) {
        this.entityClass = entityClass;
        dao = new DAOGN<>(entityClass);
        list = dao.findAll();
    }
    public void add(T t){
        dao.add(t);
        list.add(t);
    }
    public void remove(T t){
        dao.delete(t);
        list.remove(t);
    }
    public void update(T t){
        dao.update(t);
        list.remove(t);
        list.add(t);
    }
    public T findById(ID id){
        for(T t : list){
            if(entityClass.equals(Libro.class)){
                Libro libro = (Libro) t;
                if (libro.getIsbn().equals(id)){
                    return t;
                }
            }else if(entityClass.equals(Ejemplar.class)){
                Ejemplar ejemplar = (Ejemplar) t;
                if (ejemplar.getId().equals(id)){
                    return t;
                }
            } else if (entityClass.equals(Usuario.class)){
                Usuario usuario = (Usuario) t;
                if (usuario.getId().equals(id)){
                    return t;
                }
            } else if (entityClass.equals(Prestamo.class)){
                Prestamo prestamo = (Prestamo) t;
                if (prestamo.getId().equals(id)){
                    return t;
                }
            }
        }
        return null;
    }
    public List<T> findAll(){
        return list;
    }

    public DAOGN<T, ID> getDao() {
        return dao;
    }

    public void setDao(DAOGN<T, ID> dao) {
        this.dao = dao;
    }



}
