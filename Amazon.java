import java.util.*;
public class Main{
    static Scanner sc =new Scanner(System.in);
    static List<String> pending=new ArrayList<>();
    static List<String> approved=new ArrayList<>();
    static List<String> ven_id=new ArrayList<>();
    static List<String> ven_pass=new ArrayList<>();
    static List<String> products=new ArrayList<>();
    public static void main(String[] args){
        ven_id.add("p");
        ven_pass.add("p");
        boolean val=true;
        while(val){
             System.out.print("\033[H\033[2J");
        System.out.println("-------WELCOME TO AMAZON-------");
        System.out.println("--Please select the category--");
        System.out.println("1.ADMIN");
        System.out.println("2.VENDOR");
        System.out.println("3.USER");
        System.out.println("4.PRODUCT");
        System.out.println("5.END");
        int ch=sc.nextInt();
        switch(ch){
            case 1:
                admin();
                break;
            case 2:
                vendor();
                break;
            case 3:
                //user();
                break;
            case 4:
                //product();
                break;
            case 5:
                val=false;
                System.out.print("!!!! Application terminated !!!!");
                break;
            }
        }
    }
    public static void admin(){
        boolean val=true;
        while(val){
            System.out.println("Enter admin id : ");
            String admin_id=sc.next();
            System.out.println("Enter password : ");
            String admin_pass=sc.next();
            if(admin_id.equals("p") && admin_pass.equals("p")){
                System.out.print("\033[H\033[2J");
                while(val){
                
                System.out.println("--WELCOME ADMIN--");
                System.out.println("Please select options");
       
                System.out.println("1.APPROVE VENDOR");
                System.out.println("2.REMOVE VENDOR");
                System.out.println("3.ADD VENDOR");
                System.out.println("4.APPROVED VENDORS");
                System.out.println("5.EXIT");
                int ch=sc.nextInt();
                switch(ch){
                    case 1:
                        if(pending.size()==0) System.out.println("\n\nNo vendor in pending approval list\n\n");
                        else{
                            for(int i=0;i<pending.size();i++){
                                System.out.println(i+1+" vendor "+ pending.get(i));
                                System.out.print("press 1 for approval and 0 for not approval");
                                int a=sc.nextInt();
                                if(a==1){
                                    System.out.print(pending.get(i)+" is APPROVED");
                                    approved.add(pending.get(i));
                                    pending.remove(i);
                                }
                                else{
                                    System.out.print(pending.get(i)+" is NOT APPROVED");
                                    pending.remove(i);
                                }
                            }
                        }
                        continue;
                    
                    case 2:
                        System.out.println("enter the vandor id to be removed");
                        String a=sc.next();
                        int flag=0;
                        for(int i=0;i<approved.size();i++){
                            if(approved.get(i).equals(a)){
                                System.out.print(approved.get(i)+" removed succesfully");
                                approved.remove(i);
                                flag=1;
                                break;
                                
                            }
                        }
                        if(flag==0)
                            System.out.println("no such vendor found !!!");
                        continue;
                        
                    case 3:
                        System.out.println("Name of the vendor to be added : ");
                        String name=sc.next();
                         System.out.println("password: ");
                        String pass=sc.next();
                        System.out.println(name + " !! is added succesfully as vendor");
                        approved.add(name);
                        ven_id.add(name);
                        ven_pass.add(pass);
                        continue;
                    case 4:
                        if(approved.size()==0)
                             System.out.println("No vendors approved");
                        else{
                        System.out.println("vendors approved are : ");
                        for(int i=0;i<approved.size();i++)
                            System.out.println(i+1+" " +approved.get(i));
                        }
                        continue;
                    
                    case 5:
                        val=false;
                        break;
                }
            }
        }
        else
            System.out.println("Invalid username or password");
        }
    }
    public static void vendor(){
        boolean val=true;
        while(val){
            System.out.println("-------WELCOME VENDOR --------");
            System.out.println("Choose an option : ");
            System.out.println("1.New vendor ");
            System.out.println("2.Existing vendor");
            System.out.println("3.EXIT");
            int a=sc.nextInt();
            switch(a){
                case 1:
                    register();
                    break;
                case 2:
                    Existing_vendor();
                    break;
                case 3:
                    val=false;
                    break;
            }
        }
    }
    public static void register(){
        while(true){
        System.out.println("For registeration :  ");
        System.out.println("Enter vendor id : ");
        String vendor_id=sc.next();
        System.out.println("Enter password : ");
        String vendor_pass=sc.next();
        if(ven_id.contains(vendor_id)){
            System.out.println("the vendor_id is already taken ....");
            System.out.println("choose another vendor id : ");
            continue;
            }
        else{
            System.out.println("vendor registered succesfully !!!!!");
            System.out.println("On waiting list of approval.......");
            pending.add(vendor_id);
            ven_id.add(vendor_id);
            ven_pass.add(vendor_pass);
            break;
            }
        }
    }
    public static void Existing_vendor(){
        boolean val=true;
        while(val){
        System.out.println("Enter vendor id : ");
        String vendor_id=sc.next();
        System.out.println("Enter password : ");
        String vendor_pass=sc.next();
        int key=-1;
        
        for(int i=0;i<ven_id.size();i++){
            if(vendor_id.equals(ven_id.get(i)))
                key=i;
            }
        if(key==-1){
            System.out.println("vendor not found !!!!!!!!");
            
        }
        else{
            if(ven_id.get(key).equals(vendor_id) && ven_pass.get(key).equals(vendor_pass)){
                while(val){
                    System.out.println("--WELCOME Vendor--");   
                    System.out.println("1.Approval status");
                    System.out.println("2.Add product");
                    System.out.println("3.Remove product");
                    System.out.println("4.List products");
                    System.out.println("5.EXIT");
                    int a=sc.nextInt();
                    switch(a){
                        case 1:
                            if(aprove_check(key))
                                System.out.println("Vendor approved !!!");
                            else
                                System.out.println("Not approved !!!");
                            break;
                        case 2:
                            if(aprove_check(key)){
                                System.out.println("Product addition");
                                System.out.println("Enter the product name to be added !!");
                                String pro=sc.next();
                                pro=pro+String.valueOf(key);
                                products.add(pro);
                                System.out.println("Product added succesfully !! ");
                            }
                            else 
                                System.out.println("Not approved vendor yet  !!!!");
                            break;
                        case 3:
                            System.out.println("Enter the name of the Product to be removed  : ");
                            String pro=sc.next();
                            if(products.contains(pro)){
                                products.remove(pro);
                                System.out.println(pro +" is removed fro the products");
                            }
                            else
                            System.out.println("No such Product found !!");
                            break;
                        case 4:
                            System.out.println("List of products : ");
                            for(int i=0;i<products.size();i++){
                                String prod=products.get(i);
                                
                                int k=Integer.valueOf(prod.charAt(prod.length()-1))-48;
                                if(k==key)
                                    System.out.println(products.get(i));
                            }
                            break;
                        case 5:
                            val=false;
                            break;
                            
                    }
                }
            }
            else{
                System.out.println("id or password wrong !!!!");
                continue;
                }
            }
        }
    }
    public static boolean aprove_check(int key){
        if(pending.contains(ven_id.get(key)))
            return false;
        else
            return true;
    }
}
