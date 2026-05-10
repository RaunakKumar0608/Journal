// package com.example.Journal.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvSource;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// public class journalServicetest {

//     @Autowired
//     private UserService service;

//     @Test
//     void add(){
//         // assertEquals( 4,2*2 );
//         assertNotNull(service.findByusername("Sita"));
//     }

//     @ParameterizedTest
//     @CsvSource({
//         "Sita",
//         "Gita",
//         "Papita"
//     })
    
//     public void check(String user){
//         assertNotNull(service.findByusername(user)+"it's not null" + user);
//     }
// }