// package com.johanCardenas.TPS.services;

// import com.johanCardenas.TPS.models.User;
// import com.johanCardenas.TPS.models.User.Role;
// import com.johanCardenas.TPS.repositories.UserRepository;
// import jakarta.persistence.EntityNotFoundException;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;

// import java.util.*;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// class UserServiceTest {

//     private UserRepository userRepository;
//     private UserService userService;

//     private User testUser;

//     @BeforeEach
//     void setUp() {
//         userRepository = mock(UserRepository.class);
//         userService = new UserService();
//         userService.userRepository = userRepository;

//         testUser = new User();
//         testUser.setUserId(1);
//         testUser.setUserName("juan");
//         testUser.setPassword("123456");
//         testUser.setEmail("juan@email.com");
//         testUser.setRole(Role.CUSTOMER);
//         testUser.setIsFrequent(true);
//     }

//     @Test
//     void createUser_ShouldReturnSavedUser() {
//         when(userRepository.save(any(User.class))).thenReturn(testUser);
//         User saved = userService.createUser(testUser);

//         assertNotNull(saved);
//         assertEquals("juan", saved.getUserName());
//         verify(userRepository, times(1)).save(testUser);
//     }

//     @Test
//     void getAllUsers_ShouldReturnListOfUsers() {
//         List<User> mockList = Arrays.asList(testUser);
//         when(userRepository.findAll()).thenReturn(mockList);

//         List<User> result = userService.getAllUsers();
//         assertEquals(1, result.size());
//         assertEquals("juan", result.get(0).getUserName());
//     }

//     @Test
//     void getUserById_ShouldReturnUser_WhenExists() {
//         when(userRepository.findById(1)).thenReturn(Optional.of(testUser));
//         User user = userService.getUserById(1);

//         assertNotNull(user);
//         assertEquals("juan", user.getUserName());
//     }

//     @Test
//     void getUserById_ShouldThrow_WhenNotFound() {
//         when(userRepository.findById(2)).thenReturn(Optional.empty());

//         assertThrows(EntityNotFoundException.class, () -> {
//             userService.getUserById(2);
//         });
//     }

//     @Test
//     void deleteUser_ShouldReturnTrue_WhenSuccess() {
//         doNothing().when(userRepository).deleteById(1);
//         boolean deleted = userService.deleteUser(1);

//         assertTrue(deleted);
//         verify(userRepository, times(1)).deleteById(1);
//     }

//     @Test
//     void deleteUser_ShouldReturnFalse_WhenExceptionThrown() {
//         doThrow(new RuntimeException("error")).when(userRepository).deleteById(2);
//         boolean deleted = userService.deleteUser(2);

//         assertFalse(deleted);
//         verify(userRepository, times(1)).deleteById(2);
//     }
// }
