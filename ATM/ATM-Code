import java.util.*;
class Main {
    static Scanner sc =new Scanner(System.in);
    static int twothousand=15;
    static int fivehundred=15;
    static int twohundred=15;
    static int onehundred=15;
        static List<Integer> l=new ArrayList<>();
        static List<String> user=new ArrayList<>();
        static List<String> pass=new ArrayList<>();
        static List<Integer> bal=new ArrayList<>();
        static List<String> bank=new ArrayList<>();
        static List<String> trans=new ArrayList<>();
        
        public static void main(String[] args){
        boolean val=true;
        while(val){
            user.add("aaaa");pass.add("0000");bal.add(80000);bank.add("abc");
            user.add("bbbb");pass.add("1111");bal.add(65000);bank.add("xyz");
            l.add(twothousand);l.add(fivehundred);l.add(twohundred);l.add(onehundred);
            trans.add(" ");trans.add(" ");trans.add(" ");trans.add(" ");
            System.out.println();
            System.out.println();
            System.out.println("Welcome to atm app");
            System.out.println("1.ADMIN");
            System.out.println("2.CUSTOMER");
            System.out.println("3.CLOSE");
            System.out.println("CHOOSE YOUR REQUIREMENT ......");
            int a=sc.nextInt();
            switch(a) {
            case 1:
                System.out.println("Enter your Id");
                String adminid=sc.next();
                System.out.println("Enter your pass");
                String  adminpass=sc.next();
                if(adminid.equals("admin") && adminpass.equals("0000")) {
                    while(true) {
                    System.out.println("----------ADMIN-------");
                    System.out.println("1.LOAD");
                    System.out.println("2.DISPLAY");
                    System.out.println("3.CLEAR");
                    System.out.println("CHOOSE YOUR REQUIREMENT ......");
                    int lo=sc.nextInt();
                    if(lo==1) {
                        load();
                        continue;
                    }
                        
                    else if(lo==2) {
                        display();
                        continue;
                    }
                    else if(lo==3)
                        break;
                    }
                }
                else
                    System.out.println("Invalid username or password");
                break;
            case 2:
           
            int attempt=0;
            while(true){
    			System.out.println("Welcome user ");
    			System.out.println("Enter your name");
    			String username = sc.next();
    			System.out.println("Enter your password");
    			String  userpass = sc.next();
    			
    			int key=0;
    			for(int i=0;i<user.size();i++){
    			    if(user.get(i).equals(username)){
    			        key=i;
    			        break;
    			    }
    			}
    			
    			if(user.get(key).equals(username) && userpass.equals(pass.get(key)) &&attempt<=2){
                    while(true) {
    			    System.out.println("Welcome "+user.get(key));
    			    System.out.println("1.Withdrawal");
    			    System.out.println("2.Check Balance");
    			    System.out.println("3.Transaction History");
    			    System.out.println("4.Pin Change");
                    System.out.println("5.Deposit");
                    System.out.println("6.Money Transfer");
    			    System.out.println("7.Exit");
    			    System.out.println("Enter your choice");
    			    int n=sc.nextInt();
    			    sc.nextLine();
    			if(n==1)
    		        withdraw(key);
			    else if(n==2)
			        checkBalance(key);
			    else if(n==3)
			        transaction(key);
			    else if(n==4)
			        pinchange(key);
			    else if(n==5)
			        deposit(key);
                else if(n==6)
			        moneytransfer(key);
                else if(n==7)
			        break;
			    else
                    System.out.println("Enter a valid choice...");
            }
			} else if(attempt>2){
			    System.out.println("Too Many Attempts");
			    break;
			}
			else{
			    System.out.println("Invalid username or password");
			    attempt++;
			}
		}
    		case 3:
    			System.out.println("----Closed----");
    			val=false;
    			break;
    		default:
    			System.out.println("----Invalid Input-----"); 
            }
        }
    }
    public static void load(){
        System.out.println("Enter the amount to be loaded ");
        System.out.println("Enter the 2000 to be loaded : ");
        int ttl=sc.nextInt();
        twothousand+=ttl;
        System.out.println("Enter the 500 to be loaded : ");
        int fhl=sc.nextInt();
        fivehundred+=fhl;
        System.out.println("Enter the 200 to be loaded : ");
        int thl=sc.nextInt();
        twohundred+=thl;
        System.out.println("Enter the 100 to be loaded : ");
        int ohl=sc.nextInt();
        onehundred+=ohl;
        System.out.println("-----amount added successfully-----");
        l.set(0,twothousand);
        l.set(1,fivehundred);
        l.set(2,twohundred);
        l.set(3,onehundred);
    }
    public static void display(){
        System.out.println("amount in bank ");
        System.out.println("2000 : "+twothousand);
        System.out.println("500 : "+fivehundred);
        System.out.println("200 : "+twohundred);
        System.out.println("100 : "+onehundred);
        System.out.println();
        int total=tot(twothousand,fivehundred,twohundred,onehundred);
        System.out.println("total amount in bank : "+total);
    }
    public static int tot(int a,int b,int c,int d){
        return (2000*a+500*b+200*c+100*d);}
    public static void withdraw(int key){
        System.out.println("Enter the amount to be withdrawn .....");
        int cash=sc.nextInt();
        int userbal=bal.get(key);
        if(cash<userbal){
            if(cash%100!=0)
                System.out.println("enter multiples of hundred");
            else if(tot(twothousand,fivehundred,twohundred,onehundred)<cash)
                System.out.println("insufficient cash");
            else{
                denomination(cash,key);
                trans.set(key,trans.get(key)+"\n amount withdrawn "+cash);
            }
        }
        else
            System.out.println("insufficient balance in ur account");
    }
    private static void denomination(int cash,int key) {
        int a=0,b=0,c=0,d=0;
        int temp=cash;
        if(temp>=2000 && twothousand>0){
            int x=temp/2000;
            if(twothousand>=x)
                a=x;
            else
                a=twothousand;
        }
        temp=temp-(2000*a);
        if(temp>=500 && fivehundred>0){
            int x=temp/500;
            if(fivehundred>=x)
                b=x;
            else
                b=fivehundred;
        }
        temp-=(500*b);
        if(temp>=200 && twohundred>0){
            int x=temp/200;
            if(twohundred>=x)
                c=x;
            else
                c=twohundred;
        }
        temp-=(200*c);
        if(temp>=100 && onehundred>0){
            int x=temp/100;
            if(onehundred>=x)
                d=x;
            else
                d=onehundred;
        }
        temp-=(100*d);
        if(temp==0){
            twothousand-=a;
            fivehundred-=b;
            twohundred-=c;
            onehundred-=d;
            System.out.println("Amount withdrawn succesfully");
            bal.set(key, bal.get(key)-cash);
        }
        else 
            System.out.println("Denomination not found");
    }
    public static void checkBalance(int key){
        System.out.println(bal.get(key));
    }
    public static void pinchange(int key){
        System.out.println("Enter new password");
        String newpass=sc.next();
        pass.set(key,newpass);
        System.out.println("Password updated.....");
    }
    public static void transaction(int key){
        System.out.println(trans.get(key));
    }
    public static void moneytransfer(int key){
        System.out.println("Enter the user name to which money is to be sent ....");
        String name=sc.next();
        int flag=-1;
        for(int i=0;i<user.size();i++){
            if(name.equals(user.get(i)))
                flag=i;
        }
        System.out.println("Enter the amount to be sent ..");
            int amount=sc.nextInt();
        if(flag==-1){
            
            bal.set(key,bal.get(key)-amount);
            System.out.println("Amount sended succesfully");
        }
        else{
            bal.set(key,bal.get(key)-amount);
            bal.set(flag,bal.get(flag)+amount);
            System.out.println("amount sended succesfully");
        }
        trans.set(key,trans.get(key)+"\n money transfer to "+name + " "+amount );
    }
    public static void deposit(int key){
        System.out.println("Enter the denomination of amount to be added....");
        System.out.println("Enter 2000 notes....");
        int a=sc.nextInt();
        System.out.println("Enter 500 notes....");
        int b=sc.nextInt();
        System.out.println("Enter 200 notes....");
        int c=sc.nextInt();
        System.out.println("Enter 100 notes....");
        int d=sc.nextInt();
        int tot=a*2000+b*500+c*200+d*100;
        bal.set(key,bal.get(key)+tot);
        System.out.println("amount added : "+tot);
        trans.set(key,trans.get(key)+"\n amount deposited "+tot);
    }
}
