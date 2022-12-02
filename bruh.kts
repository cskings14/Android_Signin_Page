// Python's equivalent of class attributes; shared by all instances of BankAccount
//var startingNumber: Int = 1000

class BankAccount(var funds: Int = 10000,
                  var trustedUsers: List<UserAccount> = emptyList()) {

    // define "instance attributes" here; each instance will have its own routingNumber; Kotlin's self.routingNumber
    val routingNumber: Int

    companion object{
        var startingNumber: Int = 1000
    }

    // initialize "instance attributes" in the constructor; Kotlin's __init__
    init {
        startingNumber += 1
        routingNumber = startingNumber
    }


    fun checkBalance(){
        println(funds)
        println(routingNumber)
    }

    fun withdraw(amount: Int): Int{
        if (funds - amount >= 0){
            funds = funds - amount
            println("Your funds are $funds after the withdrawal")
            println("You have withdrawn $amount")
            return amount
        }
        else{
            println("Error: can't withdraw that amount")
            return amount
        }
    }

    fun deposit(amount: Int){
        funds = funds + amount
        println(funds)
    }

    fun transferTo(account2: BankAccount, amount: Int){
        if (funds - amount >= 0){
            funds = funds - amount
            account2.deposit(amount)
            println("Process complete")
            checkBalance()
            account2.checkBalance()
        }
        else{
            println("Error: can't transfer that amount")
        }
    }


}



class UserAccount(val firstName: String, val lastName: String, val age: Int, val email: String, val password: String){


    companion object{
        var userEmails = mutableListOf<String>();

        fun signup(firstName: String, lastName: String, age: Int, email: String, password: String): UserAccount?{

            var numErrors: Int = 0

            if (password.length < 10){
                println("Error: less than 10 characters")
                numErrors += 1
            }

            if (age < 16){
                println("Error: age is less than 16")
                numErrors += 1
            }

            if (firstName.length <= 0 || lastName.length <= 0){
                println("Error: Invalid first or last name")
                numErrors += 1
            }

            if (userEmails.contains(email) == true){
                println("Error: email is already registered")
                numErrors += 1
            }

            if (email.length <= 0){
                println("invalid email")
                numErrors += 1
            }

            if (numErrors == 0){
                userEmails.add(email)
                return UserAccount(firstName, lastName, age, email, password)
            }

            return null
        }
    }
}




val acc1 = BankAccount(175)
//val testwithdrawn = acc1.withdraw(50)
//val testcheckbalance1 = acc1.checkBalance()

val acc2 = BankAccount(100)
//val testcheckbalance2 = acc2.checkBalance()




val user1 = UserAccount.signup("Chris", "King", 18, "cskings14@gmail.com", "password1234")

val user2 = UserAccount.signup("Chris", "King", 18, "cskings14@gmail.com", "password1234")






