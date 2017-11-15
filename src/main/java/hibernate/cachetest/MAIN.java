package hibernate.cachetest;

import hibernate.cachetest.Entities.*;
import hibernate.cachetest.Storages.*;

import java.math.BigDecimal;
import java.util.List;

public class MAIN {

    public static void main(String[] args) {
        Developer developer = new Developer();
        Customers customers = new Customers();
        Project project = new Project();
        Companies companies = new Companies();
        Skills skills = new Skills();

        StorageDeveloper storage = new StorageDeveloper();
        CustomersStorage customersStorage = new CustomersStorage();
        CompaniesStorage companiesStorage = new CompaniesStorage();
        ProjectStorage projectStorage = new ProjectStorage();
        SkillsStorage skillsStorage = new SkillsStorage();


        //--------DEVELOPER-------------//
        developer.setFirstName("Pavel");
        developer.setLastName("Yurj");
        developer.setSpecialty("Crt");
        storage.createDeveloper(developer);  //create new Developer

        List<Developer> developers = storage.listDevelopers(); //find all Developers
        for(Developer developer3 : developers){
            System.out.println(developer3);
        }

        Developer firstDeveloper  = developers.get(3);
        firstDeveloper.setFirstName("Roman");
        firstDeveloper.setLastName("Nomas");
        firstDeveloper.setSpecialty("ABC");
        storage.updateDeveloper(firstDeveloper);  //update Developer

        Developer secondDeveloper  = developers.get(1);
        storage.deleteDeveloper(secondDeveloper);  //delete Developer



        //--------COMPANIES-------------//
        companies.setName("Company #1"); //create new Companies
        companiesStorage.createCompanies(companies);

         List<Companies> companies1 = companiesStorage.listCompanies(); //find all Companies
        for(Companies companies2 : companies1){
            System.out.println(companies2);
        }

        Companies secondCompanies  = companies1.get(4);
        secondCompanies.setName("Company #2");
        companiesStorage.updateCompanies(secondCompanies); //update Companies

        Companies thirdCompanies  = companies1.get(1);
        companiesStorage.deleteCompanies(thirdCompanies);  //delete Companies


        //--------CUSTOMERS-------------//
        customers.setName("Client #3"); //create new Customers
        customersStorage.createCustomers(customers);

        List<Customers> customers1 = customersStorage.listCustomers(); //find all Customers
        for(Customers customers2 : customers1){
            System.out.println(customers2);
        }

        Customers secondCustomers  = customers1.get(2);
        secondCustomers.setName("Client #4");
        customersStorage.updateCustomers(secondCustomers);  //update Customers

        Customers thirdCustomers  = customers1.get(1);
        customersStorage.deleteCustomers(thirdCustomers);  //delete Customers

        //--------PROJECT-------------//
        project.setName("Project29");
        project.setCost(new BigDecimal(29000));
        projectStorage.createProject(project);  //create new Project

        List<Project> project1 = projectStorage.listProject(); //find all Projects
        for(Project projects : project1){
            System.out.println(developer);
        }

        Project firstProject  = project1.get(3);
        firstProject.setName("Project39");
        firstProject.setCost(new BigDecimal(39000));
        projectStorage.updateProject(firstProject);  //update Project

        Project thirdDeveloper  = project1.get(1);
        projectStorage.deleteProject(thirdDeveloper);  //delete Project

        //--------SKILL-------------//
        skills.setName("Super skill");
        skillsStorage.createSkills(skills);  //create new Skill

        List<Skills> skills1 = skillsStorage.listSkills(); //find all Skill
        for(Skills skills2 : skills1){
            System.out.println(skills2);
        }

        Skills firstSkills  = skills1.get(3);
        firstSkills.setName("Skill #2");
        skillsStorage.updateSkills(firstSkills);  //update Skill

        Skills secondSkills  = skills1.get(4);
        skillsStorage.deleteSkills(secondSkills);  //delete Skill
    }
}
