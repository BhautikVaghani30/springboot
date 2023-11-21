package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.StudRepo;
import com.example.demo.entitis.student;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		StudRepo studRepo = context.getBean(StudRepo.class);

		Scanner sc = new Scanner(System.in);
		int ch;
		do {

			System.out.println("1. Insert Student : ");
			System.out.println("2. delete Student : ");
			System.out.println("3. update Student : ");
			System.out.println("4. Get all Student : ");
			System.out.println("5. get single Student : ");
			System.out.println("6. get single Student : ");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("Enter your Option : ");
			ch = sc.nextInt();
			System.out.println("-----------------------------------------------------------------------------");
			switch (ch) {
				case 1:
//					Scanner sc = new Scanner(System.in);

					System.out.println("Enter Student age: ");
					int age = sc.nextInt();

					// Consume the newline character left by nextInt()
					sc.nextLine();

					System.out.println("Enter Student name: ");
					String name = sc.nextLine();

					System.out.println("Enter Student city: ");
					String city = sc.nextLine();

					student stud = new student();
					stud.setName(name);
					stud.setCity(city);
					stud.setAge(age);

					// Assuming studRepo is an instance of a repository or data access object
					student s = studRepo.save(stud);

					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------------");
					break;
				case 2:
					System.out.println("Enter Student id: ");
					int id = sc.nextInt();
					studRepo.deleteById(id);
					System.out.println("Deleted Successfully");
					System.out.println("-----------------------------------------------------------------------------");
					break;
				case 3:
					try {
						System.out.println("Enter Student id: ");
						int updateid = sc.nextInt();
						System.out.println("Enter Student age: ");
						int uage = sc.nextInt();

						// Consume the newline character left by nextInt()
						sc.nextLine();

						System.out.println("Enter Student name: ");
						String uname = sc.nextLine();

						System.out.println("Enter Student city: ");
						String ucity = sc.nextLine();


						Optional<student> optional = studRepo.findById(updateid);
						student st = optional.get();
						st.setName(uname);
						st.setCity(ucity);
						st.setAge(uage);
						student r = studRepo.save(st);
						System.out.println(r);
					}
					catch (Exception e){
						System.out.println(e);
					}
					finally {
						System.out.println("-----------------------------------------------------------------------------");
						break;
					}
				case 4:
					Iterable<student> itr = studRepo.findAll();
					itr.forEach(e-> System.out  .println("\n Student id is : " + e.getId()+"\n Student name is : " + e.getName() + "\n Student Age is : " + e.getAge() + "\n Student City is : " + e.getCity()));
					System.out.println("-----------------------------------------------------------------------------");
					break;
				case 5:
					System.out.println("Enter Student id: ");
					int sid = sc.nextInt();
					Optional<student> a = studRepo.findById(sid);
					student s1 = a.get();
					System.out.println("\n Student id is : " + s1.getId() + "\n Student name is : " + s1.getName() + "\n Student Age is : " + s1.getAge() + "\n Student City is : " + s1.getCity());
					System.out.println("-----------------------------------------------------------------------------");
					break;
				case 6:
					System.exit(0);
					break;
			}
		}while (ch != 6);


	}

}
