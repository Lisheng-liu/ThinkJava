package jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class OptionalTest {
    @Test
    public  void testOptional1(){
       Optional<User>  user = Optional.empty();
       System.out.println(user.get().getAddress().getCountry().getName());
    }

    @Test
    public  void testOptional2(){
        Optional<User>  user = Optional.of(new User(new Address(new Country("china"))));
        System.out.println(user.get().getAddress().getCountry().getName());
    }

    @Test
    public  void testOptional3(){
        Optional<User>  user = Optional.ofNullable(new User(new Address(new Country("china"))));
        System.out.println(user.get().getAddress().getCountry().getName());

        Optional<User>  user2 = Optional.ofNullable(null);
        System.out.println(user2.get().getAddress().getCountry().getName());
    }


    @Test
    public  void testOptional4(){
        Optional<User>  user = Optional.ofNullable(new User(new Address(new Country("china"))));
        System.out.println(user.get().getAddress().getCountry().getName());

        Optional<User>  user2 = Optional.ofNullable(null);
        System.out.println(user2.get().getAddress().getCountry().getName());

    }


    @Test
    public  void  testNullpointerException(){
       String countryName = "";
           User user    = new User(new Address(new Country("china")));
           if(user !=  null){
               Address address = user.getAddress();
               if(address != null){
                   Country country = address.getCountry();
                   if(country != null){
                       countryName = country.getName();
                   }
               }
           }
        log.info("countryName={}",countryName);
    }

    @Data
    @AllArgsConstructor
    static class User{
        Address address;
    }
    @Data
    @AllArgsConstructor
    static class Address{
        Country country;
    }
    @Data
    @AllArgsConstructor
    static class Country{
        private String name;
    }


}
