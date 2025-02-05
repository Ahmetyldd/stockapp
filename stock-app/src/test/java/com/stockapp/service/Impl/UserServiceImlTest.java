/*package com.stockapp.service.Impl;

import com.stockapp.domain.TYProduct;
import com.stockapp.domain.User;
import com.stockapp.enums.Role;
import com.stockapp.repository.ProductRepository;
import com.stockapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.stockapp.util.TestConstants.FIRST_NAME;
import static com.stockapp.util.TestConstants.USER_EMAIL;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImlTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void findUserById() {
        User user = new User();
        user.setId(122L);

        when(userRepository.findById(122L)).thenReturn(java.util.Optional.of(user));
        userService.getUserById(122L);
        assertEquals(122L, user.getId());
        verify(userRepository, times(1)).findById(122L);
    }

    @Test
    public void getUserInfo() {
        User user = new User();
        user.setEmail(USER_EMAIL);

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.of(user));
        userService.getUserInfo(USER_EMAIL);
        assertEquals(USER_EMAIL, user.getEmail());
        verify(userRepository, times(1)).findByEmail(USER_EMAIL);
    }

    @Test
    public void findAllUsers() {
        Pageable pageable = PageRequest.of(0, 20);
        List<User> usersList = new ArrayList<>();
        usersList.add(new User());
        usersList.add(new User());
        userService.getAllUsers(pageable);
        Page<User> users = new PageImpl<>(usersList, pageable, 20);

        when(userRepository.findAllByOrderByIdAsc(pageable)).thenReturn(users);
        assertEquals(2, usersList.size());
        verify(userRepository, times(1)).findAllByOrderByIdAsc(pageable);
    }

    @Test
    public void getCart() {
        List<Long> productIds = new ArrayList<>(Arrays.asList(2L, 4L));
        TYProduct firstTYProduct = new TYProduct();
        firstTYProduct.setId(2L);
        TYProduct secondTYProduct = new TYProduct();
        secondTYProduct.setId(4L);
        List<TYProduct> TYProductList = new ArrayList<>(Arrays.asList(firstTYProduct, secondTYProduct));
        userService.getCart(productIds);

        when(productRepository.findByIdIn(productIds)).thenReturn(TYProductList);
        assertEquals(2, TYProductList.size());
        assertEquals(2, productIds.size());
        assertNotNull(TYProductList);
        verify(productRepository, times(1)).findByIdIn(productIds);
    }

    @Test
    public void loadUserByUsername() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setActive(true);
        user.setFirstName(FIRST_NAME);
        user.setRoles(Collections.singleton(Role.USER));

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.of(user));
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertTrue(user.isActive());
    }

    @Test
    public void updateUserInfo() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.of(user));
        userService.updateUserInfo(USER_EMAIL, user);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
    }
}
*/