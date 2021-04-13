import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //генирация данных
        Parent per1=new Parent("Ivanov Ivan Ivanovich");
        Parent per2=new Parent("Ivanova Kris Aleksandrovna");
        Child child1=new Child("Ivanov Alex Ivanovich",15);
        Child child2=new Child("Mihaylov Kirill Olegovich",17);
        District district = new District("Lenina 1");
        District district1 = new District("Sovetskaya 23");
        School school = new School();
        school.setDistrict(district);
        School school1 = new School();
        school1.setDistrict(district1);
        new SchoolDAO().save(school1);
        per1.setDistrict(district);
        per2.setDistrict(district1);
        child1.setSchool(school);
        child1.setParents(per1);
        child1.setParents(per2);
        child2.setParents(per2);
        child2.setSchool(school1);
        new ChildDAO().save(child1);
        new ChildDAO().save(child2);

        //получение всех данных из базы
        List<Parent> parentList= new ParentsDAO().find();
        List<District> distictList= new DistrictDAO().find();
        List<Child> childList= new ChildDAO().find();
        List<School> schoolList= new SchoolDAO().find();

        System.out.println("1. Добавление ");
        System.out.println("2. Изменение ");
        Scanner sc1 = new Scanner(System. in );
        int n1 = sc1.nextInt();
        if(n1==1){
            System.out.println("1. Добавление взрослого");
            System.out.println("2. Добавление ребенка");
            int n2 = sc1.nextInt();
            if(n2==1){
                System.out.println("Ведите ФИО");
                String n3 = sc1.next();
                Parent parent = new Parent(n3);
                System.out.println("Выберите адрес");
                int number=0;
                for (District dist:distictList){
                    number++;
                    System.out.println(number+ ". " + dist.getName());
                }
                Scanner sc2 = new Scanner(System. in );
                int n4 = sc2.nextInt();
                parent.setDistrict(distictList.get(n4-1));
                System.out.println("Выберите ребенка");
                int number2=0;
                for (Child child:childList){
                    number2++;
                    System.out.println(number2+ ". " + child.getName());
                }
                System.out.println("0. нету");
                Scanner sc3 = new Scanner(System. in );
                int n5 = sc2.nextInt();
                if (n5!=0){
                    parent.setChildren(childList.get(n5-1));
                }
                new ParentsDAO().save(parent);
                parentList.add(parent);
            }

            else {
                System.out.println("Ведите ФИО");
                String n3 = sc1.next();
                Child children = new Child(n3,0);
                System.out.println("Выберите родителя");
                Scanner sc2 = null;
                int n5 = 0;
                int n4 = -1;
                while (n5<2 && n4!=0) {
                    n5++;
                    int number=0;
                    for (Parent parent:parentList){
                        number++;
                        System.out.println(number+ ". " + parent.getName());
                    }
                    System.out.println("0. далее");
                    sc2 = new Scanner(System. in );
                    n4 = sc2.nextInt();
                    if(n4!=0){
                        children.setParents(parentList.get(n4-1));
                    }
                }
                System.out.println("Выберите школу");
                Set<School> activSchoolList = new HashSet<School>();
                for (Parent par:children.getParents()) {
                    for (School scho:schoolList){
                        if(par.getDistrict().getId()==(scho.getDistrict().getId())){
                            activSchoolList.add(scho);
                            break;
                        }
                    }
                }
                int number2=0;
                for (School schooll:activSchoolList){
                    number2++;
                    System.out.println(number2+ ". " + schooll.getId());
                }
                Scanner sc3 = new Scanner(System. in );
                int n6 = sc3.nextInt();
                children.setSchool(schoolList.get(n6-1));
                new ChildDAO().save(children);
                childList.add(children);
            }
        }

        else{
            System.out.println("1. Изменить адрес ");
            System.out.println("2. Изменить учебное учреждение ");
            Scanner sc7 = new Scanner(System. in );
            int n7 = sc7.nextInt();
            if(n7==1){
                System.out.println("Выберите родителя");
                int number3=0;
                for (Parent parent:parentList){
                    number3++;
                    System.out.println(number3+ ". " + parent.getName());
                }
                Scanner sc8 = new Scanner(System. in );
                int n8 = sc8.nextInt();
                Parent currentParent=parentList.get(n8-1);
                System.out.println("Выберите адрес");
                int number4=0;
                for (District dist:distictList){
                    number4++;
                    System.out.println(number4+ ". " + dist.getName());
                }
                Scanner sc9 = new Scanner(System. in );
                int n9 = sc9.nextInt();
                currentParent.setDistrict(distictList.get(n9-1));
                new ParentsDAO().update(currentParent);
            }
            else{
                System.out.println("Выберите ребенка");
                int number4=0;
                for (Child child:childList){
                    number4++;
                    System.out.println(number4+ ". " + child.getName());
                }
                Scanner sc10 = new Scanner(System. in );
                int n10 = sc10.nextInt();
                Child currentChild=childList.get(n10-1);
                System.out.println("Выберите школу");
                Set<School> activSchoolList = new HashSet<School>();
                for (Parent par:currentChild.getParents()) {
                    for (School scho:schoolList){
                        if(par.getDistrict().getId()==(scho.getDistrict().getId())){
                            activSchoolList.add(scho);
                            break;
                        }
                    }
                }
                int number5=0;
                for (School schooll:activSchoolList){
                    number5++;
                    System.out.println(number5+ ". " + schooll.getId());
                }
                Scanner sc11 = new Scanner(System. in );
                int n11 = sc11.nextInt();
                currentChild.setSchool(schoolList.get(n11-1));
                new ChildDAO().update(currentChild);
            }
        }
    }
}

