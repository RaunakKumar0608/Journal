// package com.example.Journal.service;

// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import static org.mockito.Mockito.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import  org.mockito.ArgumentMatchers;
// import org.mockito.InjectMocks;

// import com.example.Journal.Entity.User;
// import com.example.Journal.repositories.UserRepo;
// import org.springframework.security.core.userdetails.UserDetails;

// public class UserDetailsServiceImplTest {

//     @InjectMocks
//     private UserDetailsServiceImpl userDetailsServiceImpl;

//     @Mock
//     private UserRepo userRepo;
    
//     @BeforeEach
//     void setUp(){
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     public void loadUserByUsernameTest(){
//         when(userRepo.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("ram").password("lkasd").build());
//         UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername("ram");
//         System.out.println(userDetails.getPassword());
//     }

    
// }
