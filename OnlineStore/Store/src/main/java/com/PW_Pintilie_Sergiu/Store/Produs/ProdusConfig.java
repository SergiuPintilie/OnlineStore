//package com.PW_Pintilie_Sergiu.Store.Produs;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class ProdusConfig {
//    @Bean
//    CommandLineRunner commandLineRunner1(ProdusRepository produsRepository){
//        return args -> {
//                Produs produs1=new Produs(
//                        "Telefoane",
//                        "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                        "produs1",
//                        "primul meu produs",
//                        13.5
//                );
//                Produs produs2=new Produs(
//                        "Tablete",
//                        "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                        "produs2",
//                        "al doilea produs al meu",
//                        134.3
//                );
//            Produs produs3=new Produs(
//                    "Tablete",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs3",
//                    "al treilea produs al meu",
//                    134.3
//            );
//            Produs produs4=new Produs(
//                    "Tablete",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs4",
//                    "al 4 produs al meu",
//                    134.3
//            );
//            Produs produs5=new Produs(
//                    "Tablete",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs5",
//                    "al 5 produs al meu",
//                    134.3
//            );
//            Produs produs6=new Produs(
//                    "Tablete",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs6",
//                    "al 6 produs al meu",
//                    134.3
//            );
//            Produs produs7=new Produs(
//                    "Tablete",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs7",
//                    "al 7 produs al meu",
//                    134.3
//            );
//            Produs produs8=new Produs(
//                    "Laptopuri",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs8",
//                    "al 8 produs al meu",
//                    134.3
//            );
//            Produs produs9=new Produs(
//                    "Laptopuri",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "Laptop",
//                    "al 9 produs al meu",
//                    134.3
//            );
//            Produs produs10=new Produs(
//                    "Laptopuri",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs10",
//                    "al 10 produs al meu",
//                    134.3
//            );
//            Produs produs11=new Produs(
//                    "Laptopuri",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs11",
//                    "al 11- lea laptop al meu",
//                    134.3
//            );
//            Produs produs12=new Produs(
//                    "Laptopuri",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs12",
//                    "al 12 produs al meu",
//                    134.3
//            );
//            Produs produs13=new Produs(
//                    "Laptopuri",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs13",
//                    "al 13 produs al meu",
//                    134.3
//            );
//            Produs produs14=new Produs(
//                    "Telefoane",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs14",
//                    "al 14 produs al meu",
//                    134.3
//            );
//            Produs produs15=new Produs(
//                    "Telefoane",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs15",
//                    "al 15 produs al meu",
//                    134.3
//            );
//            Produs produs16=new Produs(
//                    "Telefoane",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs16",
//                    "al 16 produs al meu",
//                    134.3
//            );
//            Produs produs17=new Produs(
//                    "Telefoane",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs17",
//                    "al 17 produs al meu",
//                    134.3
//            );
//            Produs produs18=new Produs(
//                    "Telefoane",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs18",
//                    "al 18 produs al meu",
//                    134.3
//            );
//            Produs produs19=new Produs(
//                    "Telefoane",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs19",
//                    "al 19 produs al meu",
//                    134.3
//            );
//            Produs produs20=new Produs(
//                    "Telefoane",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs20",
//                    "al 20 produs al meu",
//                    134.3
//            );
//            Produs produs21=new Produs(
//                    "Telefoane",
//                    "D:\\Facultate\\OneDrive - Universitatea Politehnica Timisoara\\Anul 3\\Sem 1\\PW\\pw_pintilie_sergiu\\Store\\src\\main\\resources\\static\\produs2.jpeg",
//                    "produs21",
//                    "al 21 produs al meu",
//                    134.3
//            );
//                produsRepository.saveAll(List.of(produs1,produs2,produs3,produs4,produs5,produs6,produs7,produs8,produs9,produs10,produs11,produs12,produs13,produs14,produs15,produs16,produs17,produs18,produs19,produs20,produs21));
//        };
//    }
//}
