package user.dao;

import user.dto.EditUserDto;
import user.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

/**
 * @author Bungardean Tudor-Ionut
 * @since 19.1.2
 */

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager entityManager;


    /**
     * Extracts from the database the UserEntity that corresponds to the username
     * @param username
     * @return UserEntity
     */
    public UserEntity getUserByUsername(String username){
        try {
            return this.entityManager.createNamedQuery(UserEntity.GET_USER_BY_USERNAME, UserEntity.class)
                    .setParameter(UserEntity.USERNAME, username).getSingleResult();
        } catch(NoResultException ex){
            return null;
        }
    }

    /**
     * Merges the new userEntity with the old one from the database
     * @param userEntity merged
     */
    public void setCounter(UserEntity userEntity){
        this.entityManager.merge(userEntity);
    }

    public boolean checkIfEmailIsUsed(String email) {

       if (this.entityManager.createNamedQuery(UserEntity.CHECK_IF_EMAIL_EXISTS, UserEntity.class)
                .setParameter(UserEntity.EMAIL, email)
                .getResultList().size() >= 1) {

           return true;
       }
       return  false;

    }

    public boolean checkIfUsernameExists(String username) {
        if (entityManager.createNamedQuery(UserEntity.CHECK_IF_USERNAME_EXISTS, UserEntity.class)
                .setParameter(UserEntity.USERNAME, username)
                .getResultList().size() >= 1){
            return true;
        }
        return false;

    }


    public void createUser(UserEntity newUserEntity) {
        entityManager.persist(newUserEntity);
    }

    public void editUser(EditUserDto editUserDto) {
        entityManager.createNamedQuery(UserEntity.EDIT_USER)
                .setParameter(UserEntity.USERNAME, editUserDto.getUsername())
                .setParameter(UserEntity.FIRST_NAME, editUserDto.getFirstName())
                .setParameter(UserEntity.LAST_NAME, editUserDto.getLastName())
                .setParameter(UserEntity.EMAIL, editUserDto.getEmail())
                .setParameter(UserEntity.MOBLE_NUMBER, editUserDto.getMobileNumber())
                .setParameter(UserEntity.PASSWORD, editUserDto.getPassword())
                .setParameter(UserEntity.COUNTER, editUserDto.getCounter())
                .executeUpdate();
    }

    public List<UserEntity> getAllUsers(){
        return entityManager.createNamedQuery(UserEntity.GET_ALL_USERS, UserEntity.class).getResultList();
    }

}
