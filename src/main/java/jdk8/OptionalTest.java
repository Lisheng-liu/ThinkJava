package jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
    public void testwhenCheckIfPresent_thenOk(){
        Person person = (Person) Optional.ofNullable(null).orElse(new Person("xa","xa.com"));
        log.debug(" "+person);
    }

    @Test
    public void whenValueNotNull_thenIgnoreDefault(){
        Person person = (Person) Optional.ofNullable(null).orElseGet(()-> new Person("xa","xa.com"));
        log.debug(" "+person);
    }

    @Test
    public void whenThrowException_thenOk(){
        Person person = (Person) Optional.ofNullable(null).orElseThrow(()-> new IllegalArgumentException("illegal "));
        log.debug(" "+person);
    }

    @Test
    public void whenMap_thenOk(){
        String email =  Optional.ofNullable(new Person("xa","xa.com")).map(p -> p.getEmail()).orElse("defaule.com");
        log.debug(" "+email);
    }

    @Test
    public void whenFilter_thenOk(){
        Optional<Person> person = Optional.ofNullable(new Person("xa","xa.com")).filter(p ->{
            return p.getEmail() != null && p.getEmail().contains(".com");
        });
        log.debug(" "+person.get());
    }

    @Test
    public void testOptional(){
        User1 user    = new User1(new Address1(new Country1("china")));
        String cName = Optional.ofNullable(user)
                .flatMap(user1 -> user1.getAddress())
                .flatMap(address1 -> address1.getCountry())
                .flatMap(country1 -> country1.getName())
                .orElse("default");
        log.debug("cName={}",cName);


        User1 userNUll    = null;
        String cNameNull = Optional.ofNullable(userNUll)
                .flatMap(user1 -> user1.getAddress())
                .flatMap(address1 -> address1.getCountry())
                .flatMap(country1 -> country1.getName())
                .orElse("default");
        log.debug("cNameNull={}",cNameNull);


        User1 userF    = new User1(new Address1(new Country1("userF")));
        String cNameF = Optional.ofNullable(userF)
                .flatMap(User1::getAddress)
                .flatMap(Address1::getCountry)
                .flatMap(Country1::getName)
                .orElse("default");
        log.debug("cNameF={}",cNameF);
    }

    @Test
    public void whenEmptyStream_thenReturnDefaultOptional() {
          List<Person> people = new ArrayList<>();
          Person person = people.stream().findFirst().orElse(new Person("default","1234"));
          log.debug("person={}",person);
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
    class Person{
        String name;
        String email;
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


    @Data
    @AllArgsConstructor
    static class User1{
        Address1 address;

        public Optional<Address1> getAddress(){
            return Optional.ofNullable(address);
        }
    }
    @Data
    @AllArgsConstructor
    static class Address1{
        Country1 country;
        public Optional<Country1> getCountry(){
            return Optional.ofNullable(country);
        }
    }
    @Data
    @AllArgsConstructor
    static class Country1{
        private String name;
        public Optional<String> getName(){
            return Optional.ofNullable(name);
        }
    }

}
