/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.service;

import br.gov.sp.franciscomorato.contractmanager.model.Role;
import br.gov.sp.franciscomorato.contractmanager.model.User;
import br.gov.sp.franciscomorato.contractmanager.repository.UserDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinicius
 */
@Service
public class UserService implements UserDetailsService 
{

    @Autowired
    private UserDAO userDAO;
    
    /*metodos para salvar um usuario e incriptar a sua senha*/
    public User save
        (String username, String name, String password, Set<Role> roles)
    {
        User user = new User(username, new BCryptPasswordEncoder()
                .encode(password), name, roles );
        return userDAO.save(user);
    }
        
   
    public User save(User user)
    {
        user.setPassword(new BCryptPasswordEncoder()
               .encode(user.getPassword()));
        return userDAO.save(user);
    }

    /**
     * metodo para consultar e validadr se um usuario existe pelo username
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {
        User user = findByUsername(username);

        if (user == null) 
        {
            throw new UsernameNotFoundException("usuário não encontrado");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getUserAuthority(user.getRoles()));

    }

    /**
     * encontra usuário pelo nome de usuário
     *
     * @param username
     * @return se encontrar, retorna User, senao retorna nulo
     */

    public User findByUsername(String username)
    {
        return userDAO.findById(username).orElse(null);
    }
    
    /*verificando a Role de um usuario*/
    private List<GrantedAuthority> getUserAuthority(Set<Role> roles) 
    {
        Set<GrantedAuthority> granted = new HashSet<>();

        for (Role role : roles)
        {
            granted.add(new SimpleGrantedAuthority(role.getRole_name()));
        }

        return new ArrayList<>(granted);
    }
    
    
    /*Metodo para retornar todos os usuarios do banco*/
    public List<User> findAll()
    {
        return userDAO.findAll();
    }
    
    /*metodo para deletar um usuario pelo ID*/
    public void delete(String id)
    {
        userDAO.deleteById(id);
    }

}
