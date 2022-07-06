package Database;

import java.util.Stack;

public class ListUser {
    protected Stack<User> userList = new Stack<>();
    
    public ListUser(){
        userList = genUser(20);
    }
    
    public void addUser(User u){
        userList.push(u);
    }
    
    public Stack<User> getListUser(){
        return userList;
    }
    
    private final String[] nama = {
	"Abel", "Adeline", "Al", "Alexandra", "Ali", "Alisha", "Amanda", "Anita", "Aurelio", "Aurora",
	"Beatrice", "Beau", "Bethany", "Brain", "Brandy", "Brenda", "Brent", "Carey", "Cathy", "Chris",
	"Christi", "Chuck", "Cliff", "Clinton", "Dale", "Dan", "Darin", "Dazai", "Deanne", "Dewey",
	"Dirk", "Donny", "Doris", "Dwayne", "Elliot", "Emerson", "En", "Eric", "Eren", "Flora",
	"Foster", "Grady", "Gwendolyn", "Hank", "Hiro", "Jane", "Jeremy", "Jess", "Jimmie", "Joanna",
	"Joey", "Karla", "Kathy", "Katy", "Kim", "Lindsay", "Lorraine", "Lucien", "Lucy", "Luke",
	"Luz", "Mado", "Majin", "Marcy", "Maria", "Marina", "Mauro", "Meagan", "Mickey", "Myron",
	"Natsu", "Neva", "Nolan", "Ola", "Omar", "Pasquale", "Pearl", "Peter", "Phoebe", "Quinton",
	"Raphael", "Raymond", "Rebecca", "Reynaldo", "Romeo", "Rosalie", "Ryou", "Scot", "Shelia", "Shelly",
	"Staci", "Steven", "Sybil", "Takagi", "Timothy", "Tod", "Vern", "Victoria", "Violet", "Zeke"
    };
    
    private int random(int min, int max) {
	return (int) (Math.random() * (max-min+1)) + min;
    }
	
    private Stack<User> genUser(int n) {
        String name, ibu, PIN;
        int gender;
        long noRek;
        double saldo;
		
        for(int i = 0; i < n; i++) {
            noRek = 123400000000L + i;
            name = nama[random(0, 49)] + " " + nama[random(50, 99)];
            ibu = nama[random(50, 99)] + " " + nama[random(0, 49)];
            gender = random(1, 2);
            PIN = String.valueOf(random(100000, 999999));
            saldo = random(100, 99999999);
		
            userList.push(new User(noRek, name, ibu, gender, PIN, saldo));
        }
        
        return userList;
    }
}
